package com.isansc.genericadapterpoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.isansc.genericadapterpoc.adapter.GenericAdapter
import com.isansc.genericadapterpoc.binder.GenericBinder
import com.isansc.genericadapterpoc.binder.InsertedItemBinder
import com.isansc.genericadapterpoc.binder.MainItemBinder
import com.isansc.genericadapterpoc.databinding.ActivityMainBinding
import com.isansc.genericadapterpoc.model.EdgeItem
import com.isansc.genericadapterpoc.model.InsertedItem
import com.isansc.genericadapterpoc.model.MainItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val adapter = GenericAdapter(getItems(), getBinders())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.rcvGeneric.adapter = adapter

        val totalItems = ArrayList<EdgeItem>()
        totalItems.addAll(getItems())
        totalItems.addAll(getInsertedItems())

        adapter.updateItems(totalItems)
    }

    private fun getItems(): List<MainItem> {
        val items = arrayListOf<MainItem>()
        for (i in 0..20) {
            items.add(
                MainItem(
                    "MainItem Title $i",
                    "MainItem Text $i"
                )
            )
        }

        return items
    }

    private fun getInsertedItems(): List<InsertedItem> {
        val items = arrayListOf<InsertedItem>()
        for (i in 0..5) {
            items.add(
                InsertedItem(
                    "InsertedItem Title $i",
                    "InsertedItem Text $i"
                )
            )
        }

        return items
    }

    private fun getBinders(): List<GenericBinder> {
        val binders = arrayListOf<GenericBinder>()

        binders.add(
            MainItemBinder()
        )

        binders.add(
            InsertedItemBinder()
        )

        return binders
    }
}