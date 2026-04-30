package org.example.jismd.domain
import org.example.jismd.repository.UsuarioRepository

class ActualizarUsuario(
    private val repository: UsuarioRepository
) {
    suspend operator fun invoke(
        id: Int,
        nombres: String,
        apellidos: String
    ): String {
        return repository.actualizar(id, nombres, apellidos)
    }
}
