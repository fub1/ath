package com.iuioo.ath.data

import androidx.room.Entity
import androidx.room.PrimaryKey


// Data Layer important step 1-1:
// Define the data Entity class


@Entity(tableName = "sacndata")
data class ScanData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val barcode: String,
)
