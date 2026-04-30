package org.example.jismd.domain
import org.example.jismd.repository.UsuarioRepository

class ListarUsuarios(
    private val repository: UsuarioRepository
) {
    suspend operator fun invoke(): String {
        return repository.listar()
    }
}
