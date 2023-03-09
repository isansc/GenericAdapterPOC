package com.isansc.genericadapterpoc.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.isansc.genericadapterpoc.databinding.ViewMainItemBinding
import com.isansc.genericadapterpoc.holder.GenericViewHolder
import com.isansc.genericadapterpoc.holder.MainItemViewHolder
import com.isansc.genericadapterpoc.model.EdgeItem
import com.isansc.genericadapterpoc.model.MainItem

class MainItemBinder : GenericBinder {
    override fun isBinderFor(): Class<out EdgeItem> {
        return MainItem::class.java
    }

    override fun createViewHolder(parent: ViewGroup): GenericViewHolder {
        return MainItemViewHolder(
            ViewMainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}