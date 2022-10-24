package com.lukebusch.fetchlist.presentation.view.viewmodel

import com.lukebusch.fetchlist.domain.ListDisplayItem

interface MainActivityViewModel {

    fun prepareDisplayData(items: List<ListDisplayItem>) : List<ListDisplayItem>

    fun getListItems() : List<ListDisplayItem>
}