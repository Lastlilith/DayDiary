package com.imnidasoftware.daydiary.presentation.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imnidasoftware.daydiary.data.repository.Diaries
import com.imnidasoftware.daydiary.data.repository.MongoDB
import com.imnidasoftware.daydiary.model.RequestState
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    var diaries: MutableState<Diaries> = mutableStateOf(RequestState.Idle)

    init {
        observeAllDiaries()
    }

    private fun observeAllDiaries() {
        viewModelScope.launch {
            MongoDB.getAllDiaries().collect {result ->
                diaries.value = result
            }
        }
    }
}