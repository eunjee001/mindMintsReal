package com.kkyume.android.mindmints.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kkyume.android.mindmints.data.remote.AnthropicRepository

class AnthropicViewModelFactory (private val repository: AnthropicRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnthropicViewModel::class.java)){
            return AnthropicViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}