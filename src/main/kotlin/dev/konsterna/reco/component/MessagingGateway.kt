package dev.konsterna.reco.component

import org.springframework.stereotype.Component

@Component
interface MessagingGateway {
    fun send(destination: String, message: String): Boolean
}