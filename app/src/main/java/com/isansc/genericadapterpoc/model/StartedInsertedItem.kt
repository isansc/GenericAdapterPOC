package com.isansc.genericadapterpoc.model

import androidx.annotation.DrawableRes
import com.isansc.genericadapterpoc.R

class StartedInsertedItem(
    val title: String = "StartedInsertedItem Title",
    val text: String = "StartedInsertedItem Text",
    @DrawableRes val image: Int = R.drawable.baseline_woman_24
) : EdgeItem