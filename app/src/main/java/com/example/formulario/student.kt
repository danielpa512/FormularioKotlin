package com.example.formulario

import java.io.Serializable

@Suppress("ClassName")
data class student(
    val nombre: String,
    val edad: Int,
    val email: String
) : Serializable
