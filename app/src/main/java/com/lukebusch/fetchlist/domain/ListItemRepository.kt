package com.lukebusch.fetchlist.domain

import com.lukebusch.fetchlist.common.Resource
import com.lukebusch.fetchlist.data.ListItemDTO

interface ListItemRepository {
    suspend fun getAllListItems() : Resource<List<ListItemDTO>?>
}