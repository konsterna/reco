package dev.konsterna.reco.service

import dev.konsterna.reco.repository.AnswerRepository
import dev.konsterna.reco.repository.AttendeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AnswerServiceImpl : AnswerService {

    @Autowired
    lateinit var answerRepository: AnswerRepository

    @Autowired
    lateinit var attendeeRepository: AttendeeRepository

    override fun answer(answerCode: String) {
        answerRepository.find(answerCode)?.also {
            attendeeRepository.answer(it.eventId, it.userId)
        }
    }

}