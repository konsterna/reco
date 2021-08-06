package dev.konsterna.reco.component

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MessageBuilderImpl : MessageBuilder {

    @Autowired
    lateinit var answerCodeConverter: AnswerCodeConverter

    override fun build(template: String, eventId: String, answerCode: String): String {
        val hash = answerCodeConverter.encode(eventId, answerCode)
        return template.replace(MessageBuilder.TEMPLATE_TAG_HASH, hash)
    }

}