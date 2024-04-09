package com.example.a30daysworkout.Model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Workout (
    val day :Int,
    @DrawableRes val ImageRes:Int,
    @StringRes val TitleRes: Int,
    @StringRes val DescriptionRes : Int
){}