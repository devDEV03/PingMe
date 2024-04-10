package com.example.pingme.ModelView

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.pingme.data.PingDataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PingMeClass : ViewModel() {
    private val _uistate = MutableStateFlow(PingDataState())
    val uistate : StateFlow<PingDataState> = _uistate.asStateFlow()
}