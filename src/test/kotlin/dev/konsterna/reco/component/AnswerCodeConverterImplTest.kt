package dev.konsterna.reco.component

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(AnswerCodeConverterImplTest.Config::class)
class AnswerCodeConverterImplTest {

    @ComponentScan("dev.konsterna.reco.component")
    internal class Config

    @Autowired
    lateinit var converter: AnswerCodeConverterImpl

    @Test
    fun encode() {
        assertEquals("", converter.encode("20200806", "abcdef"))
    }

    @Test
    fun decode() {
        val converter = AnswerCodeConverterImpl()
        assertEquals(null, converter.decode("1234567890"))
    }

}