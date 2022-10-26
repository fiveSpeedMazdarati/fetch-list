package com.lukebusch.fetchlist.presentation.view

import com.lukebusch.fetchlist.domain.ListDisplayItem

data class DisplayState(
    val isLoading: Boolean = false,
    val listItems: List<ListDisplayItem> = emptyList(),
    val error: String = ""
)