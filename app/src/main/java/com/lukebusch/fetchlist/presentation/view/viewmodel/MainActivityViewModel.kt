package com.lukebusch.fetchlist.presentation.view.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukebusch.fetchlist.common.Resource
import com.lukebusch.fetchlist.domain.ListDisplayItem
import com.lukebusch.fetchlist.presentation.view.DisplayState
import com.lukebusch.fetchlist.domain.use_case.GetAllListItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val getItemsUseCase: GetAllListItemsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(DisplayState())
    val state: State<DisplayState> = _state

    init {
        getListItems()
    }

    /**
     * Prepares a List of [ListDisplayItem] for display.
     * The list is arranged this way: items are grouped by listId, then sorted by name
     * Then items where name is null are removed
     *
     * @param items The list of items to prepare for display
     * @return a list of items sorted for display
     */
    fun prepareDisplayData(items: List<ListDisplayItem>): List<ListDisplayItem> {
        return items.sortedWith(compareBy({ it.listId }, { it.name })).filterNot { it.name.isNullOrBlank() }
    }

    fun getListItems() {
        getItemsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val filteredData = result.data?.let { prepareDisplayData(it) }
                    _state.value = DisplayState(listItems = filteredData ?: emptyList())
                }

                is Resource.Loading -> {
                    _state.value = DisplayState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        DisplayState(error = result.message ?: "No error message available")
                }
            }
        }.launchIn(viewModelScope)
    }
}