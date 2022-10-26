package com.lukebusch.fetchlist.data.repository

import com.lukebusch.fetchlist.common.Resource
import com.lukebusch.fetchlist.data.dto.toListDisplayItem
import com.lukebusch.fetchlist.data.service.ListItemService
import com.lukebusch.fetchlist.domain.ListDisplayItem
import com.lukebusch.fetchlist.domain.repository.ListItemRepository
import javax.inject.Inject

class ListItemRepositoryImpl @Inject constructor(private val service: ListItemService) :
    ListItemRepository {

    override suspend fun getAllListItems(): Resource<List<ListDisplayItem>> {

        return try {
            val items = service.getAllListItems()
            val mappedItems = items.map { it.toListDisplayItem() }
            Resource.Success(mappedItems)
        } catch (error: Exception) {
            Resource.Error("There was a problem", null)
        }
    }
}