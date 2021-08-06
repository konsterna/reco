package dev.konsterna.reco.service

import dev.konsterna.reco.component.AnswerCodeConverter
import dev.konsterna.reco.repository.AttendeeRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(AnswerServiceImplTest.Config::class)
internal class AnswerServiceImplTest {

    @ComponentScan(
        "dev.konsterna.reco.repository",
        "dev.konsterna.reco.component"
    )
    internal class Config

    @InjectMocks
    lateinit var service: AnswerServiceImpl

    @Suppress("unused")
    @MockBean
    lateinit var attendeeRepository: AttendeeRepository

    @MockBean
    lateinit var answerCodeConverter: AnswerCodeConverter

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun answer() {
        whenever(answerCodeConverter.decode(anyString())).doReturn(null)
        assertThrows<IllegalArgumentException> { service.answer("00000000") }

        whenever(answerCodeConverter.decode(anyString())).doReturn(Pair("", ""))
        assertThrows<IllegalStateException> { service.answer("00000000") }
    }
}