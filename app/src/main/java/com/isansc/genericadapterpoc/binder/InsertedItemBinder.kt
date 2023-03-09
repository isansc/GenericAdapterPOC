package com.isansc.genericadapterpoc.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.isansc.genericadapterpoc.databinding.ViewInsertedItemBinding
import com.isansc.genericadapterpoc.holder.GenericViewHolder
import com.isansc.genericadapterpoc.holder.InsertedItemViewHolder
import com.isansc.genericadapterpoc.model.EdgeItem
import com.isansc.genericadapterpoc.model.InsertedItem

class InsertedItemBinder : GenericBinder {
    override fun isBinderFor(): Class<out EdgeItem> {
        return InsertedItem::class.java
    }

    override fun createViewHolder(parent: ViewGroup): GenericViewHolder {
        return InsertedItemViewHolder(
            ViewInsertedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}