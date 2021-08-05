package dev.konsterna.reco.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(AnswerController::class)
internal class AnswerControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun answer() {
        mockMvc
            .perform(MockMvcRequestBuilders.put("/answers/1x39pKL"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
}