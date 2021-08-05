package dev.konsterna.reco.controller

import dev.konsterna.reco.service.AnswerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AnswerController {

    @Autowired
    lateinit var answerService: AnswerService

    @PutMapping("/answers/{answerCode}")
    fun answer(@PathVariable answerCode: String) {
        answerService.answer(answerCode)
    }

}