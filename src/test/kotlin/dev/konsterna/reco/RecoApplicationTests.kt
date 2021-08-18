package dev.konsterna.reco

import dev.konsterna.reco.controller.AnswerController
import dev.konsterna.reco.controller.EventController
import dev.konsterna.reco.repository.AttendeeRepository
import dev.konsterna.reco.service.AnswerService
import dev.konsterna.reco.service.EventService
import dev.konsterna.reco.service.MessagingService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class RecoApplicationTests {

    @Suppress("unused")
    @Autowired
    lateinit var answerController: AnswerController

    @Suppress("unused")
    @MockBean
    lateinit var answerService: AnswerService

    @Suppress("unused")
    @Autowired
    lateinit var eventController: EventController

    @Suppress("unused")
    @MockBean
    lateinit var eventService: EventService

    @Suppress("unused")
    @MockBean
    lateinit var messagingService: MessagingService

    @Suppress("unused")
    @MockBean
    lateinit var attendeeRepository: AttendeeRepository

    @Test
    fun contextLoads() {
    }

}
