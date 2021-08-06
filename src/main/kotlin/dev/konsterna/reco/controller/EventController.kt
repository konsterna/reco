package dev.konsterna.reco.controller

import dev.konsterna.reco.rest.AttendeesRequest
import dev.konsterna.reco.rest.AttendeesResponse
import dev.konsterna.reco.rest.SendMessageRequest
import dev.konsterna.reco.rest.SendMessagesResultResponse
import dev.konsterna.reco.service.EventService
import dev.konsterna.reco.service.MessagingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class EventController {

    @Autowired
    lateinit var eventService: EventService

    @Autowired
    lateinit var messagingService: MessagingService

    @GetMapping("/events/{eventId}/attendees")
    fun getAttendees(@PathVariable eventId: String): AttendeesResponse {
        val attendees = eventService.getAttendees(eventId)
        return AttendeesResponse(attendees)
    }

    @PutMapping("/events/{eventId}/attendees")
    fun updateAttendees(@PathVariable eventId: String, @RequestBody body: AttendeesRequest) {
        eventService.updateAttendees(eventId, body.attendees)
    }

    @PostMapping("/events/{eventId}/messages")
    fun sendMessages(@PathVariable eventId: String, @RequestBody body: SendMessageRequest): SendMessagesResultResponse {
        val result = messagingService.sendMessages(eventId, body.template)
        return SendMessagesResultResponse(result)
    }

}