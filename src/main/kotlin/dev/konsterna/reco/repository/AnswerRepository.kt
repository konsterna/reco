package dev.konsterna.reco.repository

import dev.konsterna.reco.model.Answer
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepository {
    fun find(answerCode: String): Answer?
}