package com.example.solidprinciples

/**
 * O- Open for extension and closed for modification
 *
 * In order to log some custom errors we can pass the instance of CustomErrorLogger
 * We do not need to change the code where we are handling authentication
 * which helps to write clean code
 */

/*class CustomErrorLogger: FileErrorLogger() {
    override fun logError(errorMessage: String) {
        // do not super otherwise error logs will be written in main error file not in custom error file
//        super.logError(errorMessage)

//        Create a new Custom Error Logs File
        val file = File("custom_error_logs_file.txt")
        file.appendText(text = errorMessage)

    }
}*/

/**
 * L- Liskov Substitution Principle
 * This principle says that parent class should be replaceable without altering the behaviour
 * In other words if we replace parent class with subclass then the code should not break
 *
 * Here if we define customLogError function then all the places where CustomErrorLogger is used
 * will end up calling parent class logError function even if we pass CustomErrorLogger instance
 * and the new customLogError will not be called
 *
 * This is an issue because now our parent class is not replaceable any more and it breaks the behaviour
 * of parent class
 *
 */

//class CustomErrorLogger: FileErrorLogger() { // extends class
class CustomErrorLogger: FileErrorLogger { // implements interface

    fun customLogError(errorMessage: String) {

    }
}