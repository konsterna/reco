package dev.konsterna.reco.repository

import dev.konsterna.reco.model.Attendee
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository : DatastoreRepository<Attendee, Long> {
    fun findByEventId(eventId: String): List<Attendee>
    fun findByEventIdAndAnswerCode(eventId: String, answerCode: String): List<Attendee>
}