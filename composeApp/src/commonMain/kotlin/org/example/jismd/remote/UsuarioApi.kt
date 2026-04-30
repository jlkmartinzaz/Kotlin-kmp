package org.example.jismd.remote

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
object UsuarioApi {

    // CREATE
    suspend fun crear(documento: String, nombres: String, apellidos: String): String {
        return ApiClient.client.get(
            "${ApiClient.BASE_URL}/crearUsuario.php" +
                    "?documento=$documento&nombres=$nombres&apellidos=$apellidos"
        ).bodyAsText()
    }

    // READ (LISTAR)
    suspend fun listar(): String {
        return ApiClient.client.get(
            "${ApiClient.BASE_URL}/listarUsuario.php"
        ).bodyAsText()
    }

    // UPDATE
    suspend fun actualizar(id: Int, nombres: String, apellidos: String): String {
        return ApiClient.client.get(
            "${ApiClient.BASE_URL}/modificarUsuario.php" +
                    "?id=$id&nombres=$nombres&apellidos=$apellidos"
        ).bodyAsText()
    }

    // DELETE
    suspend fun eliminar(id: Int): String {
        return ApiClient.client.get(
            "${ApiClient.BASE_URL}/eliminarUsuario.php?id=$id"
        ).bodyAsText()
    }
}