package org.example.jismd.presentation
import org.example.jismd.repository.UsuarioRepository
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.example.jismd.model.Usuario
class UsuarioViewModel {

    private val repository = UsuarioRepository()

    private val json = Json {
        ignoreUnknownKeys = true
    }
    // CREATE
    suspend fun crear(documento: String, nombres: String, apellidos: String): String {
        return repository.crear(documento, nombres, apellidos)
    }

    // READ (🔥 AQUÍ ESTÁ EL FIX)
    suspend fun listar(): List<Usuario> {
        val response = repository.listar()
        return json.decodeFromString(response)
    }

    // UPDATE
    suspend fun actualizar(id: Int, nombres: String, apellidos: String): String {
        return repository.actualizar(id, nombres, apellidos)
    }

    // DELETE
    suspend fun eliminar(id: Int): String {
        return repository.eliminar(id)
    }
}
