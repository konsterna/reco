package dev.konsterna.reco.service

import dev.konsterna.reco.repository.AttendeeRepository
import org.junit.jupiter.api.Assertions.assertTrue
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

@SpringJUnitConfig(EventServiceImplTest.Config::class)
internal class EventServiceImplTest {

    @ComponentScan(
        "dev.konsterna.reco.repository",
        "dev.konsterna.reco.component"
    )
    internal class Config

    @InjectMocks
    lateinit var service: EventServiceImpl

    @MockBean
    lateinit var attendeeRepository: AttendeeRepository

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getAttendees() {
        whenever(attendeeRepository.getAttendees(anyString())).doReturn(emptyList())
        assertTrue(service.getAttendees("20210820").isEmpty())
    }

    @Test
    fun updateAttendees() {
        whenever(attendeeRepository.getAttendees(anyString())).doReturn(emptyList())
        assertTrue(service.updateAttendees("20200820", emptyList()).isEmpty())
    }
}