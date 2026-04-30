package org.example.jismd

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform