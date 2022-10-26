package com.lukebusch.fetchlist.data.dto

import com.lukebusch.fetchlist.domain.ListDisplayItem

data class ListItemDTO(
    val id: String,
    val listId: String,
    val name: String
)

fun ListItemDTO.toListDisplayItem() : ListDisplayItem {
    return ListDisplayItem(
        id = this.id,
        listId = this.listId,
        name = this.name
    )
}