package dev.konsterna.reco.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

@Controller
class EventController {

    @GetMapping("/events/{eventId}/attendees")
    fun getAttendees(@PathVariable eventId: String) {

    }

    @PutMapping("/events/{eventId}/attendees")
    fun updateAttendees(@PathVariable eventId: String) {

    }

    @PostMapping("/events/{eventId}/messages")
    fun sendMessages(@PathVariable eventId: String) {

    }

}