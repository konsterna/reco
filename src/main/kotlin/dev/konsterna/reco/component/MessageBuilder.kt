package dev.konsterna.reco.component

import org.springframework.stereotype.Component

@Component
interface MessageBuilder {

    /**
     * Build message to send to attendees.
     *
     * @param template Template string to be replaced the tags with specific values
     *                 %hash% : Hash of Event ID and Answer Code
     */
    fun build(template: String, eventId: String, answerCode: String): String

    companion object {
        const val TEMPLATE_TAG_HASH = "%hash%"
    }
}