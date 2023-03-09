package com.isansc.genericadapterpoc.model

import androidx.annotation.DrawableRes
import com.isansc.genericadapterpoc.R

class InsertedItem(
    val title: String = "InsertedItem Title",
    val text: String = "InsertedItem Text",
    @DrawableRes val image: Int = R.drawable.ic_android_black_24dp
) : EdgeItem