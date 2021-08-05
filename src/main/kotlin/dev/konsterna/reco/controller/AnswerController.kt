package dev.konsterna.reco.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@Controller
class AnswerController {

    @PutMapping("/answers/{answerCode}")
    fun answer(@PathVariable answerCode: String) {

    }

}