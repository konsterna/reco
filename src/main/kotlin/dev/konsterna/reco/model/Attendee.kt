package dev.konsterna.reco.model

import java.util.*

data class Attendee(
    val id: Int,
    val name: String,
    val destination: String,
    val answerCode: String,
    var sentDate: Date? = null,
    var answerDate: Date? = null,
)
