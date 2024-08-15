package com.kkyume.android.mindmints.ui

import androidx.lifecycle.liveData
import androidx.lifecycle.ViewModel
import com.kkyume.android.mindmints.data.model.CompletionResponse
import com.kkyume.android.mindmints.data.remote.AnthropicRepository
import com.kkyume.android.mindmints.utils.Resource
import kotlinx.coroutines.Dispatchers

/**
 * ViewModel에서 Anthropic API를 호출합니다.
 */
class AnthropicViewModel(private val repository: AnthropicRepository) : ViewModel(){
    fun getCompletion(prompt : String) = liveData(Dispatchers.IO) {

        /**
         * emit은 주로 liveData 빌더 블록 안에서 사용되며, LiveData가 관찰되고 있을 때 관찰자에게 새로운 데이터를 제공하는 역할을 합니다.
         */
        emit(Resource.loading<CompletionResponse>())
    try {
        val response = repository.getCompletion(prompt)
        emit(Resource.success(response))
    }catch (e : Exception){
        emit(e.localizedMessage?.let { Resource.error(it) })
    }
    }
}