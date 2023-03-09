package com.isansc.genericadapterpoc.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isansc.genericadapterpoc.binder.GenericBinder
import com.isansc.genericadapterpoc.holder.GenericViewHolder
import com.isansc.genericadapterpoc.model.EdgeItem

class GenericAdapter(
    val itemList: List<EdgeItem>,
    val itemBinderList: List<GenericBinder>
) : RecyclerView.Adapter<GenericViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val item = itemList[position]
        val itemBinder = itemBinderList.find {
            it.isBinderFor() == item.javaClass
        }

        return itemBinderList.indexOf(itemBinder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val itemBinder = itemBinderList[viewType]
        return itemBinder.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}