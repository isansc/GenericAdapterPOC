package com.isansc.genericadapterpoc.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.isansc.genericadapterpoc.databinding.ViewPacedItemBinding
import com.isansc.genericadapterpoc.holder.GenericViewHolder
import com.isansc.genericadapterpoc.holder.PacedItemViewHolder
import com.isansc.genericadapterpoc.model.EdgeItem
import com.isansc.genericadapterpoc.model.PacedItem

class PacedItemBinder : GenericBinder {
    override fun isBinderFor(): Class<out EdgeItem> {
        return PacedItem::class.java
    }

    override fun createViewHolder(parent: ViewGroup): GenericViewHolder {
        return PacedItemViewHolder(
            ViewPacedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}