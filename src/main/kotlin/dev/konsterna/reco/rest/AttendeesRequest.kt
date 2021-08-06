package dev.konsterna.reco.rest

import dev.konsterna.reco.model.Attendee

data class AttendeesRequest(
    val attendees: List<Attendee>
)
