package com.lukebusch.fetchlist.data.service

import com.lukebusch.fetchlist.data.dto.ListItemDTO
import retrofit2.Response
import retrofit2.http.GET

interface ListItemService {
    @GET("hiring.json")
    suspend fun getAllListItems() : List<ListItemDTO>
}