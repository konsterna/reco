package dev.konsterna.reco.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(EventController::class)
internal class EventControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun getAttendees() {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/events/20210806/attendees"))
            .andExpect(status().isOk)
    }

    @Test
    fun updateAttendees() {
        mockMvc
            .perform(MockMvcRequestBuilders.put("/events/20210806/attendees"))
            .andExpect(status().isOk)
    }

    @Test
    fun sendMessages() {
        mockMvc
            .perform(MockMvcRequestBuilders.post("/events/20210806/messages"))
            .andExpect(status().isOk)
    }
}