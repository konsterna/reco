package dev.konsterna.reco.model

data class Attendee(
    val id: Int,
    val name: String,
    val isSent: Boolean,
    val isConfirmed: Boolean
)

