package com.isansc.genericadapterpoc.holder

import com.isansc.genericadapterpoc.databinding.ViewMainItemBinding
import com.isansc.genericadapterpoc.model.EdgeItem
import com.isansc.genericadapterpoc.model.MainItem

class MainItemViewHolder(private val binding: ViewMainItemBinding) :
    GenericViewHolder(binding.root) {

    override fun bind(item: EdgeItem) {
        item as MainItem
        binding.txtTitle.setText(item.title)
        binding.txtContent.setText(item.text)
    }
}
