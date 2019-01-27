package com.maciejko.share.di

import androidx.room.Room
import com.maciejko.share.data.source.local.CoordinatedGroupDatabase
import com.maciejko.share.data.source.local.CoordinatedGroupLocalDataSource
import com.maciejko.share.feature.master.MasterViewModel
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
        Room.databaseBuilder(androidApplication(), CoordinatedGroupDatabase::class.java, "coordinated-group-db")
            .build()
    }

    // DAO
    single { get<CoordinatedGroupDatabase>().coordinatedGroupDao() }

    // Data source
    single { CoordinatedGroupLocalDataSource(get()) }

    single { Moshi.Builder().build() }

    viewModel { MasterViewModel() }
}