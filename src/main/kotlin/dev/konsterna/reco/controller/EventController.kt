package dev.konsterna.reco.controller

import dev.konsterna.reco.rest.AttendeesResponse
import dev.konsterna.reco.rest.SendMessagesResultResponse
import dev.konsterna.reco.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class EventController {

    @Autowired
    lateinit var eventService: EventService

    @GetMapping("/events/{eventId}/attendees")
    fun getAttendees(@PathVariable eventId: String): AttendeesResponse {
        val attendees = eventService.getAttendees(eventId)
        return AttendeesResponse(attendees)
    }

    @PutMapping("/events/{eventId}/attendees")
    fun updateAttendees(@PathVariable eventId: String) {
        eventService.updateAttendees(eventId)
    }

    @PostMapping("/events/{eventId}/messages")
    fun sendMessages(@PathVariable eventId: String): SendMessagesResultResponse {
        val result = eventService.sendMessages(eventId)
        return SendMessagesResultResponse(result)
    }

}