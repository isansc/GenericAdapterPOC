package com.isansc.genericadapterpoc.holder

import android.graphics.Color
import com.isansc.genericadapterpoc.databinding.ViewPacedItemBinding
import com.isansc.genericadapterpoc.model.EdgeItem
import com.isansc.genericadapterpoc.model.PacedItem

class PacedItemViewHolder(private val binding: ViewPacedItemBinding) :
    GenericViewHolder(binding.root) {

    override fun bind(item: EdgeItem) {
        item as PacedItem
        binding.txtTitle.setText(item.title)
        binding.txtContent.setText(item.text)
        binding.grpContainer.setBackgroundColor(Color.parseColor(item.color))
    }
}
