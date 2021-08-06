package dev.konsterna.reco.service

import dev.konsterna.reco.model.SendMessageResult
import org.springframework.stereotype.Service

@Service
interface MessagingService {
    fun sendMessages(eventId: String, template: String): List<SendMessageResult>
}