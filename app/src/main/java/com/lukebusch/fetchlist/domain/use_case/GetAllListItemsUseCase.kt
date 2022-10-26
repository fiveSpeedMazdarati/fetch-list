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
        /*val data = mutableListOf<ListDisplayItem>()

        data.add(ListDisplayItem("684", "1", "Item 684"))
        data.add(ListDisplayItem("755", "2", ""))
        data.add(ListDisplayItem("276", "1", "Item 276"))
        data.add(ListDisplayItem("680", "3", "Item 680"))
        data.add(ListDisplayItem("685", "1", null))

        */
}