package com.isansc.genericadapterpoc.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isansc.genericadapterpoc.binder.GenericBinder
import com.isansc.genericadapterpoc.holder.GenericViewHolder
import com.isansc.genericadapterpoc.model.EdgeItem
import com.isansc.genericadapterpoc.model.PacingConfig

class GenericAdapter(
    items: List<EdgeItem> = listOf(),
    private val itemBinderList: List<GenericBinder>,
    private val pacingConfigList: List<PacingConfig> = listOf()
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
        itemList.addAll(insertDynamicItems(items))

        notifyDataSetChanged() // EU SEI
    }

    private fun insertDynamicItems(items: List<EdgeItem>): List<EdgeItem> {
        val itemsTotalList = ArrayList(items)

        if (pacingConfigList.size > 0) {
            var pacingIndex = 0
            var itemIndex = 0

            while (pacingIndex < pacingConfigList.size && itemIndex < itemsTotalList.size) {
                val currentPacing = pacingConfigList[pacingIndex]

                itemIndex += currentPacing.start
                var currentPacingOccurrence = 0

                while (itemIndex < itemsTotalList.size && (currentPacing.occurrences == PacingConfig.INFINITE || currentPacingOccurrence < currentPacing.occurrences)) {
                    itemsTotalList.add(itemIndex, currentPacing.item)
                    currentPacingOccurrence++
                    itemIndex += currentPacing.pacing + 1
                }

                pacingIndex++
            }
        }

        return itemsTotalList
    }
}