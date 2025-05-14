package com.example.petify.FirebaseAuth

import com.example.petify.AuthResponse
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class AuthenticationManager() {


    private val auth = Firebase.auth

    fun createAccountWithEmail(email: String, password: String): Flow<AuthResponse> = callbackFlow {

        val authListener = auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    trySend(AuthResponse.Success)
                } else {

                    val errorMessage = task.exception?.message ?: "Ocurrió un error"
                    trySend(AuthResponse.Error(message = errorMessage))

                }
            }

        awaitClose { authListener.isComplete }

    }

    fun loginWithEmail(email: String, password: String): Flow<AuthResponse> = callbackFlow {
        val authListener =  auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    trySend(AuthResponse.Success)
                } else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?: ""))
                }
            }
    awaitClose { authListener.isComplete }
    }

    fun SignOutAccount (){
        auth.signOut()
    }

}