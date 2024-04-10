package com.example.pingme

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pingme.ModelView.PingMeClass

enum class windowType{
    LIST_ONLY,LIST_AND_DETAILS
}

@Composable
fun PingMe(
    windowSize : WindowWidthSizeClass,
    pingMVVM : PingMeClass = viewModel()
){

    val uistate by pingMVVM.uistate.collectAsState()

    var contentType : windowType by remember{
        mutableStateOf(value = windowType.LIST_ONLY)
    }

    when(windowSize){
        WindowWidthSizeClass.Compact -> contentType = windowType.LIST_ONLY
        WindowWidthSizeClass.Expanded -> contentType = windowType.LIST_AND_DETAILS
        WindowWidthSizeClass.Medium -> contentType = windowType.LIST_ONLY
        else -> contentType = windowType.LIST_ONLY
    }

    if(contentType == windowType.LIST_ONLY){

    }

}