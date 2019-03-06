package com.maciejko.share.di

import androidx.room.Room
import com.maciejko.share.data.source.CoordinatedGroupDataSource
import com.maciejko.share.data.source.CoordinatedGroupRepository
import com.maciejko.share.data.source.local.CoordinatedGroupDatabase
import com.maciejko.share.data.source.local.CoordinatedGroupLocalDataSource
import com.maciejko.share.feature.master.coordinated_group_list.CoordinatedGroupListViewModel
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Koin main module
 */
val appModule = module {

    // Database
    single {
        Room.databaseBuilder(androidApplication(), CoordinatedGroupDatabase::class.java, DB_NAME).build()
    }

    // DAO
    single { get<CoordinatedGroupDatabase>().coordinatedGroupDao() }

    // Data source
    single { CoordinatedGroupLocalDataSource(get()) as CoordinatedGroupDataSource }

    //Moshi
    single { Moshi.Builder().build() }

    //Coordinated group repository
    single { CoordinatedGroupRepository(get()) }

    //View models
    viewModel { CoordinatedGroupListViewModel(get()) }
}

private const val DB_NAME = "coordinated-group-db"