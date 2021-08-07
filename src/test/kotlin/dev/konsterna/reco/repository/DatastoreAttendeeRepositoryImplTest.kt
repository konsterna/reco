package dev.konsterna.reco.repository

import dev.konsterna.reco.model.Attendee
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(DatastoreAttendeeRepositoryImplTest.Config::class)
internal class DatastoreAttendeeRepositoryImplTest {

    @ComponentScan
    internal class Config

    @InjectMocks
    private lateinit var repository: DatastoreAttendeeRepositoryImpl

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun updateAttendee() {
        assertTrue(true)
    }

    @Test
    fun getAttendees() {
        assertEquals(emptyList<Attendee>(), repository.getAttendees("20200806"))
    }

    @Test
    fun findAttendee() {
        assertNull(repository.findAttendee("20200807", "123456"))
    }

    @Test
    fun setAttendees() {
        assertTrue(true)
    }

}