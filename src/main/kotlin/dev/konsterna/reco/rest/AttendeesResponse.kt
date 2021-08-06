package dev.konsterna.reco.rest

import dev.konsterna.reco.model.Attendee

data class AttendeesResponse(
    val attendees: List<Attendee>
)
