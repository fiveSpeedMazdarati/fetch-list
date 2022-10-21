package com.lukebusch.fetchlist.data.service

import com.lukebusch.fetchlist.data.ListItemDTO
import retrofit2.Response
import retrofit2.http.GET

interface ListItemService {
    @GET
    suspend fun getAllListItems() : Response<List<ListItemDTO>>
}