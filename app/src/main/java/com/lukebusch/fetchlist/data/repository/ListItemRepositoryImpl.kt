package com.lukebusch.fetchlist.data.repository

import com.lukebusch.fetchlist.common.Resource
import com.lukebusch.fetchlist.data.ListItemDTO
import com.lukebusch.fetchlist.data.service.ListItemService
import com.lukebusch.fetchlist.domain.ListItemRepository

class ListItemRepositoryImpl(val service: ListItemService) : ListItemRepository {
    override suspend fun getAllListItems(): Resource<List<ListItemDTO>?> {
        val response = service.getAllListItems()
        return if (response.isSuccessful) {
            Resource.Success(response.body())
        } else {
            Resource.Error(response.message())
        }
    }
}