package dev.konsterna.reco.repository

import dev.konsterna.reco.model.Attendee
import dev.konsterna.reco.model.Contact
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository {
    fun answer(eventId: String, userId: Int)
    fun getAllAttendees(eventId: String): List<Attendee>
    fun getAllContacts(eventId: String): List<Contact>
    fun setAllAttendees(eventId: String, attendees: List<Attendee>)
}