package com.onemm.common.exception

import kong.unirest.UnirestInstance
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SlackService(
    private val http: UnirestInstance,

    @Value("\${slack}")
    private val slackUrl: String,
) {

    fun sendMessage(text: String) {
        http.post(slackUrl)
            .body(
                mapOf(
                    "channel" to "#error", // 니 채널 이름으로 수정하소
                    "username" to "webhoozkbot",
                    "text" to text,
                    "icon_emoji" to ":ghost:",
                )
            )
            .asEmptyAsync()
    }

}
