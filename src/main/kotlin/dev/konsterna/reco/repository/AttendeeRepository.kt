package dev.konsterna.reco.repository

import dev.konsterna.reco.model.Attendee
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository {
    fun updateAttendee(eventId: String, attendee: Attendee)
    fun getAttendees(eventId: String): List<Attendee>
    fun findAttendee(eventId: String, answerCode: String): Attendee?
    fun setAttendees(eventId: String, attendees: List<Attendee>)
}