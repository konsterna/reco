package dev.konsterna.reco.service

import dev.konsterna.reco.component.AnswerCodeConverter
import dev.konsterna.reco.repository.AttendeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AnswerServiceImpl : AnswerService {

    @Autowired
    lateinit var attendeeRepository: AttendeeRepository

    @Autowired
    lateinit var answerCodeConverter: AnswerCodeConverter

    override fun answer(hash: String) {
        val (eventId, answerCode) = answerCodeConverter.decode(hash) ?: throw IllegalArgumentException()
        val attendee = attendeeRepository.findByEventIdAndAnswerCode(eventId, answerCode).firstOrNull()
            ?: throw IllegalStateException()
        attendee.answerDate = Date()

        attendeeRepository.save(attendee)
    }

}