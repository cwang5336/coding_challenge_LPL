package com.example.code

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState

class MainActivity : ComponentActivity() {
    private val viewModel: SummarizedEmailCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val summarizedEmailCardState = viewModel.summarizedEmailCard.collectAsState()
            SummarizedEmailCardCompose(summarizedEmailCardState.value)
        }
    }
}