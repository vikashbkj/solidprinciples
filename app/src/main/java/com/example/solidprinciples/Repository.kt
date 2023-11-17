package com.example.solidprinciples

/**
 * initial version of Repository
 * Reference link
 * https://www.youtube.com/watch?v=t8VTLxMsufU
 *
 * Problems in the initial version of class Repository and loginUser functions
 *
 * loginUser function violates the first principle (Single Responsibility Principle) of SOILED
 *
 * The loginUser function should be responsible for single task only
 * Here there could be two reasons to change loginUser
 * (1) We want to implement a different way of authentication or
 * (2) We want to change the way to log errors
 * So there are two different reasons to change the loginUser function that violates the Single Responsibility Principle
 * Single Responsibility Principle says the the classes or functions should always have a single responsibility
 * If a class / function has more than one responsibility then we need to refactor / change the class / function
 *
 * So create a separate class to create file for logs and put logs i.e FileErrorLogger
 */
/*
class Repository(private val auth: FirebaseAuth) {
    fun loginUser(name: String, password: String) {
        try {
            auth.createUserWithEmailAndPassword(name, password)
        } catch (exception: Exception) {
            val file = File("error_logs_file.txt")
            file.appendText(text = exception.message.toString())
        }
    }
}*/

/**
 * O- Open for extension closed for modification
 * Pass FileErrorLogger in constructor so it can be used for CustomFileErrorLogger as well
 */
/*
class Repository (private val auth: FirebaseAuth, private val errorLogger: FileErrorLogger) {

    fun loginUser(name: String, password: String) {
        try {
            auth.createUserWithEmailAndPassword(name, password)
        } catch (exception: Exception) {
            errorLogger.logError(exception.message.toString())
        }
    }
}*/


/**
 * D- Dependency Inversion
 * Says that we should depend on abstraction not on concrete implementation
 *
 * We can use the same class Repository or function loginUser for authentication
 * using Firebase Auth or or custom authentication using Firebase or any other authentication
 */
class Repository (private val auth: Authenticator, private val errorLogger: FileErrorLogger) {

    fun loginUser(name: String, password: String) {
        try {
            auth.createUserWithEmailAndPassword(name, password)
        } catch (exception: Exception) {
            errorLogger.logError(exception.message.toString())
        }
    }
}