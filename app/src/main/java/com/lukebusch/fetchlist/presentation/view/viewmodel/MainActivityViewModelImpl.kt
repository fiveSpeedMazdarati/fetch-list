package com.lukebusch.fetchlist.presentation.view.viewmodel

import com.lukebusch.fetchlist.domain.ListDisplayItem
import com.lukebusch.fetchlist.domain.use_case.GetAllListItemsUseCase

class MainActivityViewModelImpl(val useCase: GetAllListItemsUseCase) : MainActivityViewModel {
    /**
     * Prepares a List of [ListDisplayItem] for display.
     * The list is arranged this way: items are grouped by listId, then sorted by name
     * Then items where name is null are removed
     *
     * @param items The list of items to prepare for display
     * @return a list of items sorted for display
     */
    override fun prepareDisplayData(items: List<ListDisplayItem>) : List<ListDisplayItem> {
        return items.sortedWith(compareBy({ it.listId }, { it.name })).filter { it.name != null }
    }

    override fun getListItems(): List<ListDisplayItem> {

        return useCase.invoke()
    }
}