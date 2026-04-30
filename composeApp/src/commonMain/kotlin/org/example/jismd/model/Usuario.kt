package org.example.jismd.model
import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    val idUsu: Int? = null,
    val documento: String,
    val nombres: String,
    val apellidos: String
)
