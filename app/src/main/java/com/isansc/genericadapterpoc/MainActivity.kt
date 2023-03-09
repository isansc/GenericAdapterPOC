package com.isansc.genericadapterpoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.isansc.genericadapterpoc.adapter.GenericAdapter
import com.isansc.genericadapterpoc.binder.GenericBinder
import com.isansc.genericadapterpoc.binder.MainItemBinder
import com.isansc.genericadapterpoc.databinding.ActivityMainBinding
import com.isansc.genericadapterpoc.model.MainItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        val items = getItems()
        val binders = getBinders()
        binding.rcvGeneric.adapter = GenericAdapter(items, binders)
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

    private fun getBinders(): List<GenericBinder> {
        val binders = arrayListOf<GenericBinder>()

        binders.add(
            MainItemBinder()
        )

        return binders
    }
}