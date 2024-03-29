package com.iuioo.ath.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


// Data Layer important step 1-2:
// DAO of Room(SQLite-Local Database) -  DB data source Dao
// Interface of DAO:
// Define the DAO interface for the data entity

// data write to DB mast use kotlin coroutines(suspend fun)
// use Flow for data observation in the UI or Use_case layer

interface ScanDataDao {

    @Query("SELECT * FROM sacndata")
    fun getAll(): Flow<List<ScanData>>

    @Query("SELECT  barcode FROM sacndata")
    fun getBarcode(): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(scanData: ScanData)

    @Delete
    suspend fun delete(scanData: ScanData)

    @Update
    suspend fun update(scanData: ScanData)
}