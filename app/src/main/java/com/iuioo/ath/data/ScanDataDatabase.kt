package com.iuioo.ath.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Data Layer important step 1-3:
// Define Room(SQLite-Local Database)
// class of DB:
// Define DB class whit instance object

// https://developer.android.com/codelabs/basic-android-kotlin-compose-persisting-data-room?hl=zh-cn&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-6-pathway-2%3Fhl%3Dzh-cn%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-persisting-data-room#6
// [ bug ]java.lang.RuntimeException: Cannot find implementation
// forScanDataDatabase_Impl does not exist ]
// update by copilot

@Database(entities = [ScanData::class], version = 1, exportSchema = false)
abstract class ScanDataDatabase : RoomDatabase() {
    abstract fun scanDataDao(): ScanDataDao

    companion object {
        @Volatile
        private var Instance: ScanDataDatabase? = null

        fun getDatabase(context: Context): ScanDataDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ScanDataDatabase::class.java, "ScanDataDatabase")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }



}