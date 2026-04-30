package org.example.jismd.repository
import org.example.jismd.remote.UsuarioApi

class UsuarioRepository {

    // CREATE
    suspend fun crear(documento: String, nombres: String, apellidos: String): String {
        return UsuarioApi.crear(documento, nombres, apellidos)
    }

    // READ
    suspend fun listar(): String {
        return UsuarioApi.listar()
    }

    // UPDATE
    suspend fun actualizar(id: Int, nombres: String, apellidos: String): String {
        return UsuarioApi.actualizar(id, nombres, apellidos)
    }

    // DELETE
    suspend fun eliminar(id: Int): String {
        return UsuarioApi.eliminar(id)
    }
}
