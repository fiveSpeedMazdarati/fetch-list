package com.lukebusch.fetchlist.domain.use_case

import com.lukebusch.fetchlist.data.service.ListItemService
import com.lukebusch.fetchlist.domain.ListDisplayItem

class GetAllListItemsUseCase(val service: ListItemService) {

    operator fun invoke() : List<ListDisplayItem> {

       // service.getAllListItems()

        val data = mutableListOf<ListDisplayItem>()

        data.add(ListDisplayItem("684", "1", "Item 684"))
        data.add(ListDisplayItem("755", "2", ""))
        data.add(ListDisplayItem("276", "1", "Item 276"))
        data.add(ListDisplayItem("680", "3", "Item 680"))
        data.add(ListDisplayItem("685", "1", null))

        return data
    }
}