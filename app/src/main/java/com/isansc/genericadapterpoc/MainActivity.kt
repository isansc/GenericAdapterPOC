package com.isansc.genericadapterpoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.isansc.genericadapterpoc.adapter.GenericAdapter
import com.isansc.genericadapterpoc.binder.GenericBinder
import com.isansc.genericadapterpoc.binder.InsertedItemBinder
import com.isansc.genericadapterpoc.binder.MainItemBinder
import com.isansc.genericadapterpoc.binder.PacedItemBinder
import com.isansc.genericadapterpoc.databinding.ActivityMainBinding
import com.isansc.genericadapterpoc.model.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val adapter = GenericAdapter(getItems(), getBinders(), getPacingConfigs())

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
//        totalItems.addAll(getInsertedItems())

        adapter.updateItems(totalItems)
    }

    private fun getItems(): List<MainItem> {
        val items = arrayListOf<MainItem>()
        for (i in 0..50) {
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

    private fun getPacingConfigs(): List<PacingConfig> {
//        return listOf(
//            SingleItemPacingConfig(PacedItem("SinglePacedItem", "SinglePacedItem Text", "#00FF00")),
//            SingleItemPacingConfig(PacedItem("SinglePacedItem", "SinglePacedItem Text", "#22FF00")),
//            PacingConfig(PacedItem("SinglePacedItem", "SinglePacedItem Text", "#00FF22"), 5, 3, 5),
//            PacingConfig(PacedItem("SinglePacedItem", "SinglePacedItem Text", "#22FF22"), 3, 5, 2),
//            PacingConfig(PacedItem("SinglePacedItem", "SinglePacedItem Text", "#CCCCCC"), 3, 7, 4),
//            PacingConfig(PacedItem("SinglePacedItem", "SinglePacedItem Text", "#00FF22"), 3, 10)
//
//        )

//        // PosJogo
//        return listOf(
//            PacingConfig(PacedItem("UnderSubTitle", "SinglePacedItem Text", "#00FF22"), 2, 0, 1),
//            PacingConfig(PacedItem("InfinitePacedItem", "SinglePacedItem Text", "#22FF22"), 3, 3)
//        )
        // Lance a Lance
        return listOf(
            PacingConfig(PacedItem("Publicidade Inicial", "PacedItem Text", "#00FF00"), 0, 0, 1),
            PacingConfig(PacedItem("Transmission", "PacedItem Text", "#CCCCCC"), 0, 0, 1),
            PacingConfig(PacedItem("Penalty", "PacedItem Text", "#00FFFF"), 0, 0, 1),
            PacingConfig(PacedItem("Publicidade 3", "PacedItem Text", "#FFFF00"), 3, 0, 1),
            PacingConfig(PacedItem("Publicidade 5", "PacedItem Text", "#222222"), 5, 0, 1),
            PacingConfig(PacedItem("Publicidade 10", "PacedItem Text", "#FF00FF"), 10, 10)
        )
    }

    private fun getBinders(): List<GenericBinder> {
        val binders = arrayListOf<GenericBinder>()

        binders.add(
            MainItemBinder()
        )

        binders.add(
            InsertedItemBinder()
        )

        binders.add(
            PacedItemBinder()
        )

        return binders
    }
}