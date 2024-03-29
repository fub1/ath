package com.iuioo.ath.data

import kotlinx.coroutines.flow.Flow

// UI elements (state) ->  ViewModel  ->  Use_case Layer  ->Repository  ->  Data Source
// Data Source: (DB/network/file/DataStore)
// ViewModel or Use_case Layer only access the data from  "repository" not from data source

// Data Layer important step 2-1:
// Interface of repo:provide data from data source to Use_case/UI layer
// Define the repository interface

// Flow for data observation in the UI or Use_case layer

// data write to DB mast use kotlin coroutines(suspend fun)
interface ScanDataRepository{
    fun getAll(): Flow<List<ScanData>>
    suspend fun insert(scanData: ScanData)
    suspend fun delete(scanData: ScanData)
    suspend fun update(scanData: ScanData)
}