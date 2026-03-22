package com.example.week6catfacts

import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class CatFactUiState(
    val isLoading: Boolean = false,
    val fact: CatFactResponse? = null,
    @param:StringRes @field:StringRes val errorMessageRes: Int? = null
)

class CatFactViewModel : ViewModel() {

    var uiState by mutableStateOf(CatFactUiState())
        private set

    init {
        loadFact()
    }

    fun loadFact() {
        if (uiState.isLoading) {
            return
        }

        viewModelScope.launch {
            uiState = CatFactUiState(isLoading = true)

            uiState = try {
                val response = CatFactService.api.getRandomFact()
                CatFactUiState(fact = response)
            } catch (_: Exception) {
                CatFactUiState(errorMessageRes = R.string.error_loading_fact)
            }
        }
    }
}
