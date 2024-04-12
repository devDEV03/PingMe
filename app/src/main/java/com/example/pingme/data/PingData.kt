package com.example.pingme.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PingData(
    @DrawableRes val imageId : Int = 0,
    @StringRes val heading : Int = 0,
    @StringRes val description : Int = 0,
    @StringRes val time : Int = 0,
)

val itemList = listOf(
    PingData(
        imageId = 0
    )
)
