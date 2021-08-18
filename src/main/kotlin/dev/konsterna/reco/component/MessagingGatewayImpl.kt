package dev.konsterna.reco.component

import org.springframework.stereotype.Component

@Component
class MessagingGatewayImpl : MessagingGateway {

    override fun send(destination: String, message: String): Boolean {
        // TODO: Send message
        return true
    }

}