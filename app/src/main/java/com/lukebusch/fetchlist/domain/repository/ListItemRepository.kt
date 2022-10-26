package com.lukebusch.fetchlist.domain.repository

import com.lukebusch.fetchlist.common.Resource
import com.lukebusch.fetchlist.data.dto.ListItemDTO

interface ListItemRepository {
    suspend fun getAllListItems() : List<ListItemDTO>
}