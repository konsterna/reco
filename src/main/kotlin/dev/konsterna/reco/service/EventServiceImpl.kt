package dev.konsterna.reco.service

import dev.konsterna.reco.model.Attendee
import dev.konsterna.reco.repository.AttendeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventServiceImpl : EventService {

    @Autowired
    lateinit var attendeeRepository: AttendeeRepository

    override fun getAttendees(eventId: String): List<Attendee> {
        return attendeeRepository.findAttendees(eventId)
    }

    override fun updateAttendees(eventId: String, attendees: List<Attendee>): List<Attendee> {
        val currentAttendees = getAttendees(eventId)
        val removedAttendees = currentAttendees.minus(attendees)
        attendeeRepository.performTransaction {
            it.deleteAll(removedAttendees)
            it.saveAll(attendees)
        }
        return getAttendees(eventId)
    }

}