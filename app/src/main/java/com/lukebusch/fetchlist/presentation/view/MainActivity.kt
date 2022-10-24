package com.lukebusch.fetchlist.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lukebusch.fetchlist.R
import com.lukebusch.fetchlist.data.service.ListItemService
import com.lukebusch.fetchlist.domain.ListDisplayItem
import com.lukebusch.fetchlist.domain.ListItemAdapter
import com.lukebusch.fetchlist.domain.use_case.GetAllListItemsUseCase
import com.lukebusch.fetchlist.presentation.view.viewmodel.MainActivityViewModel
import com.lukebusch.fetchlist.presentation.view.viewmodel.MainActivityViewModelImpl

class MainActivity(private val viewModel: MainActivityViewModelImpl) : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateView()
    }

    private fun populateView() {

        val recyclerView = findViewById<RecyclerView>(R.id.item_list_rv)

        recyclerView.layoutManager = LinearLayoutManager(this)

       val data = viewModel.getListItems()

        val filteredData = viewModel.prepareDisplayData(data)

        val adapter = ListItemAdapter(filteredData)

        recyclerView.adapter = adapter

    }
}