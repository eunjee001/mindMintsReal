package com.kkyume.android.mindmints.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.kkyume.android.mindmints.BuildConfig
import com.kkyume.android.mindmints.R
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kkyume.android.mindmints.data.remote.AnthropicRepository
import com.kkyume.android.mindmints.data.remote.RetrofitClient
import com.kkyume.android.mindmints.utils.Status

class MainActivity : AppCompatActivity() {
    private val viewModel : AnthropicViewModel by viewModels{
        AnthropicViewModelFactory(AnthropicRepository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val promptInput = findViewById<TextView>(R.id.promptInput)
        val responseView = findViewById<TextView>(R.id.responseView)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val prompt = promptInput.text.toString()

            viewModel.getCompletion(prompt).observe(this, Observer { resource ->
                if (resource != null) {
                    when (resource.status) {
                        Status.SUCCESS -> {
                            responseView.text = resource.data?.completion
                        }

                        Status.ERROR -> {
                            responseView.text = "Error: ${resource.message}"
                        }

                        Status.LOADING -> {
                            responseView.text = "Loading..."
                        }
                    }
                }
            })
        }
    }
}