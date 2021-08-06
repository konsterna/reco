package dev.konsterna.reco.component

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(MessageBuilderImplTest.Config::class)
internal class MessageBuilderImplTest {

    @ComponentScan("dev.konsterna.reco.component")
    internal class Config

    @Autowired
    lateinit var messageBuilder: MessageBuilderImpl

    @MockBean
    lateinit var answerCodeConverter: AnswerCodeConverter

    @Test
    fun build() {
        whenever(answerCodeConverter.encode(anyString(), anyString())).doReturn("BBB")

        assertEquals("", messageBuilder.build("", "20200807", "000000"))
        assertEquals("AAA", messageBuilder.build("AAA", "20200807", "000000"))
        assertEquals("AAABBB", messageBuilder.build("AAA%hash%", "20200807", "000000"))
    }

}