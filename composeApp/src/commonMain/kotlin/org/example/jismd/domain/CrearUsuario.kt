package org.example.jismd.domain
import org.example.jismd.repository.UsuarioRepository

class CrearUsuario(
    private val repository: UsuarioRepository
) {
    suspend operator fun invoke(
        documento: String,
        nombres: String,
        apellidos: String
    ): String {
        return repository.crear(documento, nombres, apellidos)
    }
}
