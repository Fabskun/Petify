package com.example.petify

interface AuthResponse {

    data object Success: AuthResponse
    data class Error (val message: String):AuthResponse
}