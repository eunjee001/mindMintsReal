package com.kkyume.android.mindmints.data.model

/**
 * Anthropic API 요청과 응답에 사용할 데이터 클래스를 정의합니다.
 */
data class CompletionRequest(
    val model : String = "claude-3-5-sonnet-20240620",
    val max_tokens : Int = 1024,
    val messages: List<Message> = listOf(
Message(role = "user", content = "Hello, world")
)
)
data class Message(
    val role: String,
    val content: String
)

