package com.lukebusch.fetchlist.domain.repository

import com.lukebusch.fetchlist.common.Resource
import com.lukebusch.fetchlist.domain.ListDisplayItem

interface ListItemRepository {
    suspend fun getAllListItems(): Resource<List<ListDisplayItem>>
}