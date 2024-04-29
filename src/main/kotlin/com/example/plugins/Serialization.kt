package com.example.plugins

import io.ktor.serialization.gson.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.random.Random

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
        gson {
            }
    }
    routing {
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/json/gson") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/check"){
            val random = Random.nextInt(1, 100)
            call.respond(mapOf(
                "Message" to "If you see this message the server is working fine",
                "Health" to "$random%"
            ))
        }
    }
}
