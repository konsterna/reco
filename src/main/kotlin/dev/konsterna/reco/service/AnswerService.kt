package dev.konsterna.reco.service

import org.springframework.stereotype.Service

@Service
interface AnswerService {
    fun answer(hash: String)
}