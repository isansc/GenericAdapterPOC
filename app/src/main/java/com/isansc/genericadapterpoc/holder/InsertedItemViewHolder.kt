package com.isansc.genericadapterpoc.holder

import com.isansc.genericadapterpoc.databinding.ViewInsertedItemBinding
import com.isansc.genericadapterpoc.model.EdgeItem
import com.isansc.genericadapterpoc.model.InsertedItem

class InsertedItemViewHolder(private val binding: ViewInsertedItemBinding) :
    GenericViewHolder(binding.root) {

    override fun bind(item: EdgeItem) {
        item as InsertedItem
        binding.txtTitle.setText(item.title)
        binding.txtContent.setText(item.text)
        binding.imgInserted.setImageResource(item.image)
    }
}
