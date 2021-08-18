package dev.konsterna.reco.service

import dev.konsterna.reco.component.MessageBuilder
import dev.konsterna.reco.component.MessageBuilderImplTest
import dev.konsterna.reco.component.MessagingGateway
import dev.konsterna.reco.model.Attendee
import dev.konsterna.reco.repository.AttendeeRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(MessageBuilderImplTest.Config::class)
internal class MessagingServiceImplTest {

    @ComponentScan(
        "dev.konsterna.reco.repository",
        "dev.konsterna.reco.component"
    )
    internal class Config

    @Suppress("unused")
    @InjectMocks
    lateinit var service: MessagingServiceImpl

    @Suppress("unused")
    @MockBean
    lateinit var attendeeRepository: AttendeeRepository

    @Suppress("unused")
    @MockBean
    lateinit var builder: MessageBuilder

    @Suppress("unused")
    @MockBean
    lateinit var gateway: MessagingGateway

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun sendMessages() {
        whenever(attendeeRepository.findAttendees(anyString())).doReturn(listOf(
            Attendee(0, "A", "000-000-000A", "a", "abcdefg0"),
            Attendee(1, "B", "000-000-000B", "b", "abcdefg1"),
            Attendee(2, "C", "000-000-000C", "c", "abcdefg2"),
        ))
        whenever(gateway.send(anyString(), anyString())).doReturn(true)
        whenever(builder.build(anyString(), anyString(), anyString())).doReturn("")

        val result = service.sendMessages("20200808", "template %hash%")
        Assertions.assertEquals(3, result.count())
        Assertions.assertEquals(3, result.count { it.isSuccess })
    }
}