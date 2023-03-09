package com.isansc.genericadapterpoc.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isansc.genericadapterpoc.binder.GenericBinder
import com.isansc.genericadapterpoc.holder.GenericViewHolder
import com.isansc.genericadapterpoc.model.EdgeItem

class GenericAdapter(
    items: List<EdgeItem> = listOf(),
    private val itemBinderList: List<GenericBinder>,
    private val insertDinamicItemList: List<InsertDynamicItem>
) : RecyclerView.Adapter<GenericViewHolder>() {
    private val itemList: ArrayList<EdgeItem> = ArrayList(items)

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

    fun updateItems(items: List<EdgeItem>) {
        itemList.clear()
        itemList.addAll(items)






        notifyDataSetChanged() // EU SEI
    }

    private fun insertDynamicItems() {
        jhkasjdhkasjdh
    }
}