package dev.konsterna.reco.service

import dev.konsterna.reco.component.MessageBuilder
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
    lateinit var messageBuilder: MessageBuilder

    @Autowired
    lateinit var messagingGateway: MessagingGateway

    override fun sendMessages(eventId: String, template: String): List<SendMessageResult> {
        return attendeeRepository.findByEventId(eventId).map {
            val message = messageBuilder.build(template, eventId, it.answerCode)
            val isSuccess = messagingGateway.send(it.destination, message)
            return@map SendMessageResult(it.id, isSuccess)
        }
    }

}