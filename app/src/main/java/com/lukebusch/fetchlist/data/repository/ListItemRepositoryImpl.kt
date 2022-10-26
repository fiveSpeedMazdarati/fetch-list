package com.lukebusch.fetchlist.data.repository

import com.lukebusch.fetchlist.data.dto.ListItemDTO
import com.lukebusch.fetchlist.data.service.ListItemService
import com.lukebusch.fetchlist.domain.repository.ListItemRepository
import javax.inject.Inject

class ListItemRepositoryImpl @Inject constructor(private val service: ListItemService) : ListItemRepository {

    override suspend fun getAllListItems(): List<ListItemDTO> {
        return service.getAllListItems()

    }
}