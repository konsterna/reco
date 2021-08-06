package dev.konsterna.reco.service

import dev.konsterna.reco.model.Attendee
import org.springframework.stereotype.Service

@Service
interface EventService {
    fun getAttendees(eventId: String): List<Attendee>
    fun updateAttendees(eventId: String, attendees: List<Attendee>)
}
