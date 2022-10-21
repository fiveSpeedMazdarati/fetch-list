package com.lukebusch.fetchlist.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lukebusch.fetchlist.R
import com.lukebusch.fetchlist.domain.ListDisplayItem
import com.lukebusch.fetchlist.domain.ListItemAdapter
import com.lukebusch.fetchlist.presentation.view.viewmodel.MainActivityViewModel
import com.lukebusch.fetchlist.presentation.view.viewmodel.MainActivityViewModelImpl

class MainActivity() : AppCompatActivity() {

    val viewModel = MainActivityViewModelImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateView()
    }

    private fun populateView() {

        val recyclerView = findViewById<RecyclerView>(R.id.item_list_rv)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = mutableListOf<ListDisplayItem>()

        data.add(ListDisplayItem("684", "1", "Item 684"))
        data.add(ListDisplayItem("755", "2", ""))
        data.add(ListDisplayItem("276", "1", "Item 276"))
        data.add(ListDisplayItem("680", "3", "Item 680"))
        data.add(ListDisplayItem("684", "1", null))

        val filteredData = viewModel.prepareDisplayData(data)

        val adapter = ListItemAdapter(filteredData)

        recyclerView.adapter = adapter

    }
}