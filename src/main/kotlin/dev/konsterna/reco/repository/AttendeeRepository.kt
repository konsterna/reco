package dev.konsterna.reco.repository

import dev.konsterna.reco.model.Attendee
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository : DatastoreRepository<Attendee, Long> {
    fun findAttendees(eventId: String): List<Attendee>
    fun findAttendeesByEventIdAndAnswerCode(eventId: String, answerCode: String): List<Attendee>
}