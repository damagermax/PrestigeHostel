package com.example.prestigehostel.utils

data class AuthState
    (
    var isLoading: Boolean = false,
    var errorMessage: String? = null,
    var isSuccess: Boolean = false
)