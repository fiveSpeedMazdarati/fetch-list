package com.lukebusch.fetchlist.di

import com.lukebusch.fetchlist.common.Constants
import com.lukebusch.fetchlist.data.repository.ListItemRepositoryImpl
import com.lukebusch.fetchlist.data.service.ListItemService
import com.lukebusch.fetchlist.domain.repository.ListItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideListItemService(): ListItemService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ListItemService::class.java)
    }

    @Provides
    @Singleton
    fun provideListItemRepository(api: ListItemService): ListItemRepository {
        return ListItemRepositoryImpl(api)
    }
}