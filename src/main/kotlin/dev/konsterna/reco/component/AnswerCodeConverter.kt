package dev.konsterna.reco.component

import org.springframework.stereotype.Component

@Component
interface AnswerCodeConverter {

    /**
     * Decode hash to EventID and AnswerCode
     *
     * @return if hash can be decoded, A tuple of EventID and AnswerCode, otherwise null
     */
    fun decode(hash: String): Pair<String, String>?


    /**
     * Encode EventID and AnswerCode to hash
     *
     * @return hash encoded by EventID and AnswerCode
     */
    fun encode(eventId: String, answerCode: String): String

}
