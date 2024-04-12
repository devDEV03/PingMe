package com.example.pingme.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

data class PingData(
    @DrawableRes val imageId : Int = 0,
    @StringRes val heading : Int = 0,
    @StringRes val description : Int = 0,
    @StringRes val time : Int = 0,
)

enum class Screens{
    Start,
    Mid,
    End
}

data class RailIcons(
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val navRoute : Screens,
    val bagde : Int? = null,
)

val iconList = listOf(
    RailIcons(
        title = "Go right",
        selectedIcon = Icons.AutoMirrored.Default.ArrowBack,
        unselectedIcon = Icons.AutoMirrored.Filled.ArrowBack,
        navRoute = Screens.Start,
    ),

    RailIcons(
        title = "Go left",
        selectedIcon = Icons.AutoMirrored.Default.ArrowForward,
        unselectedIcon = Icons.AutoMirrored.Filled.ArrowForward,
        navRoute = Screens.Mid,
    ),

    RailIcons(
        title = "Play",
        selectedIcon = Icons.Default.PlayArrow,
        unselectedIcon = Icons.Filled.PlayArrow,
        navRoute = Screens.Start,
    )

)

val itemList = listOf(
    PingData(

    )
)