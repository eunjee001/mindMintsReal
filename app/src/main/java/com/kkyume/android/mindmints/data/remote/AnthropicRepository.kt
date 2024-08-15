package com.kkyume.android.mindmints.data.remote

import com.kkyume.android.mindmints.data.model.CompletionRequest
import com.kkyume.android.mindmints.data.model.CompletionResponse

/**
 * Anthropic API에서 데이터를 가져오는 Repository 클래스를 정의합니다.
 */

class AnthropicRepository(private val apiService: ApiService) {
    suspend fun getCompletion(prompt : String) : CompletionResponse{
        val request = CompletionRequest()
        return apiService.getCompletion(request)
    }
}