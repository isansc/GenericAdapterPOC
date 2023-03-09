package com.isansc.genericadapterpoc.binder

import android.view.ViewGroup
import com.isansc.genericadapterpoc.holder.GenericViewHolder
import com.isansc.genericadapterpoc.model.EdgeItem

interface GenericBinder {
    fun isBinderFor(): Class<out EdgeItem>
    fun createViewHolder(parent: ViewGroup): GenericViewHolder
    fun isan(parent: ViewGroup): GenericViewHolder
}