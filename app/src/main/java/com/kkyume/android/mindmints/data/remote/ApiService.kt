package com.kkyume.android.mindmints.data.remote

import com.kkyume.android.mindmints.BuildConfig
import com.kkyume.android.mindmints.data.model.CompletionRequest
import com.kkyume.android.mindmints.data.model.CompletionResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Anthropic API의 엔드포인트를 정의합니다. API 키는 BuildConfig에서 가져와 헤더로 설정합니다.
 */
interface ApiService {
    @Headers(
        "x-api-key: ${BuildConfig.ANTHROPIC_API_KEY}",
        "Content-Type: application/json",
        "anthropic-version: 2023-06-01"
    )
    @POST("v1/messages")   // Anthropic api 의 앤드포인트
    suspend fun getCompletion(@Body requestBody: CompletionRequest) :CompletionResponse
}