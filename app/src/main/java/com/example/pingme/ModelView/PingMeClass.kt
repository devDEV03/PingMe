package com.example.pingme.ModelView

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.pingme.data.PingData
import com.example.pingme.data.PingDataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PingMeClass : ViewModel() {
    private val _uistate = MutableStateFlow(PingDataState())
    val uistate : StateFlow<PingDataState> = _uistate.asStateFlow()

    fun selectCard(
        item : PingData?
    ){
        _uistate.update {
            currentState -> currentState.copy(
                itemSelected = item
            )
        }
    }
}