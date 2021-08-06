package dev.konsterna.reco.service

import dev.konsterna.reco.component.MessagingGateway
import dev.konsterna.reco.model.SendMessageResult
import dev.konsterna.reco.repository.AttendeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessagingServiceImpl : MessagingService {

    @Autowired
    lateinit var attendeeRepository: AttendeeRepository

    @Autowired
    lateinit var messagingGateway: MessagingGateway

    override fun sendMessages(eventId: String): List<SendMessageResult> {
        return attendeeRepository.getAllContacts(eventId).map {
            val isSuccess = messagingGateway.send(it.destination, "Test")
            return@map SendMessageResult(it.id, isSuccess)
        }
    }

}