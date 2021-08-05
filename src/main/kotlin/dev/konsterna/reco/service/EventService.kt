package dev.konsterna.reco.service

import dev.konsterna.reco.model.Attendee
import dev.konsterna.reco.model.SendMessageResult
import org.springframework.stereotype.Service

@Service
interface EventService {
    fun getAttendees(eventId: String): List<Attendee>
    fun updateAttendees(eventId: String)
    fun sendMessages(eventId: String): List<SendMessageResult>
}
