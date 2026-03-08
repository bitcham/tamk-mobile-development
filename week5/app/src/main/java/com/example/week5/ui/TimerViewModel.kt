package com.example.week5.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _secondsElapsed = MutableStateFlow(0)
    val secondsElapsed: StateFlow<Int> = _secondsElapsed.asStateFlow()

    init {
        startTimer()
    }

    private fun startTimer() {
        viewModelScope.launch {
            while (isActive) {
                delay(1_000)
                _secondsElapsed.update { it + 1 }
            }
        }
    }
}
