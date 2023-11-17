package com.example.solidprinciples

import java.io.File

/**
 * O- Open For Extension and Closed for Modification
 * If you need to create a custom error logs file to log some errors then
 * do not modify existing FileErrorLogger otherwise you will break Single Responsibility Principle
 * instead create a new class CustomFileErrorLogger
 */
/*open class FileErrorLogger {

    open fun logError(errorMessage: String) {
        val file = File("error_logs_file.txt")
        file.appendText(text = errorMessage)
    }
}*/

/**
 * I- Interface segregation
 * This principle says that clients / classes should not be forced to implement functions
 * of an interface they actually do not need
 *
 * Here if add a new function printLogs to FileErrorLogger interface then
 * all the clients / classes will be forced to implement the new function printLogs
 *
 * If all the clients need the printLogs function then there is no problem at all but if all clients  do need printLogs function
 * then it breaks the Interface Segregation Principle
 *
 * Following are the solutions to this problem
 * (1) define a default method in interface
 * (2) declare function, assign Unit in kotlin in interface
 * (3) declare the function in an internal interface this way
 * only the client who need the printLogs will implement the internal interface and other clients are not affected
 *
 */
interface FileErrorLogger {
    fun logError(errorMessage: String) {
        val file = File("custom_error_logs_file.txt")
        file.appendText(text = errorMessage)
    }

//    fun printLogs() // Problem
//    fun printLogs() {  // (Solution (1))
//
//    }

    //fun printLogs() = Unit // (Solution (2))

    interface PrintLogger { // (Solution (3))
        fun printLogs()
    }
}