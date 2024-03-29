/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iuioo.ath.data

import kotlinx.coroutines.flow.Flow

// Data Layer important step 2-2:
// Interface of repo:provide data from data source to Use_case/UI layer
// override function in Repository[step2-1]: link repo function to "data source Dao"

// Flow for data observation in the UI or Use_case layer

// solution of "offline first"
// https://developer.android.com/topic/architecture/data-layer/offline-first?hl=zh-cn

// Define the OFFLINE repository interface

class OfflineScanDataRepository(private val scanDataDao: ScanDataDao) : ScanDataRepository {
    override fun getAll(): Flow<List<ScanData>> = scanDataDao.getAll()
    override suspend fun insert(scanData: ScanData) = scanDataDao.insert(scanData)
    override suspend fun delete(scanData: ScanData) = scanDataDao.delete(scanData)
    override suspend fun update(scanData: ScanData) = scanDataDao.update(scanData)
}
