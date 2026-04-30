package org.example.jismd.domain
import org.example.jismd.repository.UsuarioRepository

class EliminarUsuario(
    private val repository: UsuarioRepository
) {
    suspend operator fun invoke(id: Int): String {
        return repository.eliminar(id)
    }
}
