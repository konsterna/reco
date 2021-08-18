package dev.konsterna.reco.model

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id
import java.util.*

@Entity(name = "event")
data class Attendee(
    @Id val id: Long,
    val eventId: String,
    val name: String,
    val destination: String,
    val answerCode: String,
    var sentDate: Date? = null,
    var answerDate: Date? = null,
)
