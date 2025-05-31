package com.example.code

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SummarizedEmailCardViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SummarizedEmailCardRepository(application)

    private val _summarizedEmailCard = MutableStateFlow<List<SummarizedEmailCard>>(emptyList())
    val summarizedEmailCard: StateFlow<List<SummarizedEmailCard>> = _summarizedEmailCard

    init {
        loadSummarizedEmailCard()
    }

    private fun loadSummarizedEmailCard() {
        viewModelScope.launch {
            _summarizedEmailCard.value = repository.getSummarizedEmailCardData()
        }
    }
}
