package com.iuioo.ath.data

import android.content.Context
import android.app.Application

// Build application container after define Data Layer
// Build application container step 1:
// https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository#4

// this version commit only for data source from Room, not for Retrofit

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val scanDataRepository: ScanDataRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [Repository]
     */
    override val scanDataRepository: ScanDataRepository by lazy {
        OfflineScanDataRepository(ScanDataDatabase.getDatabase(context).scanDataDao())
    }
}
