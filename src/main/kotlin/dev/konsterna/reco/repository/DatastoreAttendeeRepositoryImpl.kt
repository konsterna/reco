package dev.konsterna.reco.repository

import dev.konsterna.reco.model.Attendee
import org.springframework.stereotype.Repository

@Repository
class DatastoreAttendeeRepositoryImpl : AttendeeRepository {

    override fun updateAttendee(eventId: String, attendee: Attendee) {
        return
    }

    override fun getAttendees(eventId: String): List<Attendee> {
        return emptyList()
    }

    override fun findAttendee(eventId: String, answerCode: String): Attendee? {
        return null
    }

    override fun setAttendees(eventId: String, attendees: List<Attendee>) {
        return
    }

}