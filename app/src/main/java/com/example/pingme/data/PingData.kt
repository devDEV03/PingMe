package com.example.pingme.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pingme.R

data class PingData(
    @DrawableRes val imageId : Int = 0,
    @StringRes val heading : Int = 0,
    @StringRes val description : Int = 0,
    @StringRes val time : Int = 0,
    @StringRes val message : Int = 0
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
        bagde = 10
    )

)

val itemList = listOf(
    PingData(
        imageId = R.drawable.avatar_0,
        heading = R.string.account_1_first_name,
        description = R.string.account_1_last_name,
        time = R.string.email_1_time
    ),
    PingData(
        imageId = R.drawable.avatar_4,
        heading = R.string.account_4_first_name,
        description = R.string.account_4_last_name,
        time = R.string.email_4_time
    ),
    PingData(
        imageId = R.drawable.avatar_10,
        heading = R.string.account_5_first_name,
        description = R.string.account_5_last_name,
        time = R.string.email_5_time
    ),
    PingData(
        imageId = R.drawable.avatar_2,
        heading = R.string.account_6_first_name,
        description = R.string.account_6_last_name,
        time = R.string.email_6_time
    )
)