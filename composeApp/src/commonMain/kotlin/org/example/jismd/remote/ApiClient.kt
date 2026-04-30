package org.example.jismd.remote
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
object ApiClient {

    val client = HttpClient(CIO) {

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
    }

    // ⚠️ ANDROID EMULATOR: 10.0.2.2
    const val BASE_URL = "http://10.0.2.2/API"
}
