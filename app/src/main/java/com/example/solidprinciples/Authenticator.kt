package com.example.solidprinciples

import com.google.firebase.auth.FirebaseAuth

/**
 * D- Dependency Inversion
 * This principle says that a class should depend on abstractions not on concrete implementations
 *
 * We can achieve abstraction by passing interface type as argument to constructor
 * this way the client is dependent on abstraction not on concrete implementation.
 *
 * So we can use the same class Repository or function loginUser for authentication
 * using Firebase Auth or or custom authentication using Firebase or any other authentication
 */
interface Authenticator {
    fun createUserWithEmailAndPassword(name: String, password: String)
}

class FirebaseAuthenticator: Authenticator {
    override fun createUserWithEmailAndPassword(name: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(name, password)
    }
}

class CustomApiAuthenticator: Authenticator {
    override fun createUserWithEmailAndPassword(name: String, password: String) {
//        retrofit call to authenticate
    }
}