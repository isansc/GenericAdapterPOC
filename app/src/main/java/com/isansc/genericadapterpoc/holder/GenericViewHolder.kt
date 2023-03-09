package com.isansc.genericadapterpoc.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.isansc.genericadapterpoc.model.EdgeItem

abstract class GenericViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: EdgeItem)
}