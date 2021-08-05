package dev.konsterna.reco.rest

import dev.konsterna.reco.model.SendMessageResult

data class SendMessagesResultResponse(
    val results: List<SendMessageResult>
)
