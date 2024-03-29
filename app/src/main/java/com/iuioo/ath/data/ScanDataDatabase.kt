package com.iuioo.ath.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Data Layer important step 1-3:
// Define Room(SQLite-Local Database)
// class of DB:
// Define DB class whit instance object


@Database(entities = [ScanData::class], version = 1)
abstract class ScanDataDatabase : RoomDatabase() {
    abstract fun scanDataDao(): ScanDataDao

    companion object {
        @Volatile
        private var INSTANCE: ScanDataDatabase? = null

        fun getDatabase(context: Context): ScanDataDatabase {
            return INSTANCE ?: synchronized(this) {
                //initiate the DB
                //https://github.com/google-developer-training/basic-android-kotlin-compose-training-inventory-app.git
                Room.databaseBuilder(context, ScanDataDatabase::class.java, "scan_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}

