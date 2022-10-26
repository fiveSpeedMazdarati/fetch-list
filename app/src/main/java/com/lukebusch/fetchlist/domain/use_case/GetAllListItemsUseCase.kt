package com.lukebusch.fetchlist.domain.use_case

import com.lukebusch.fetchlist.common.Resource
import com.lukebusch.fetchlist.domain.ListDisplayItem
import com.lukebusch.fetchlist.domain.repository.ListItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllListItemsUseCase @Inject constructor(
    private val repository: ListItemRepository
) {

    operator fun invoke(): Flow<Resource<List<ListDisplayItem>>> = flow {

        emit(Resource.Loading())
        val items = repository.getAllListItems()

        items.data?.let {
            emit(Resource.Success(items.data))
        }
    }
}