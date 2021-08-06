package dev.konsterna.reco.component

import org.springframework.stereotype.Component

@Component
class AnswerCodeConverterImpl : AnswerCodeConverter {

    override fun decode(hash: String): Pair<String, String>? {
        return null
    }

    override fun encode(eventId: String, answerCode: String): String {
        return ""
    }

}