package com.iuioo.ath.ui.screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


import com.iuioo.ath.data.OfflineScanDataRepository
import com.iuioo.ath.ScanDataApplication
import com.iuioo.ath.data.ScanData
// use flow observe data from repo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


// network request exception
//import retrofit2.HttpException


// Process3 - Step 1：
// ADD repo to ViewModel
// Process3 - Step 2：
// observe data from repo as state by Flow
// https://github.com/google-developer-training/basic-android-kotlin-compose-training-bus-schedule-app
// Process3 - Step 3：
// important step: initialize VM & DB



class ScanViewModel(private val offlinescanDataRepository: OfflineScanDataRepository) : ViewModel(){

    //add function to get data from repo - define UI state
    val allBarcode: Flow<List<ScanData>> = offlinescanDataRepository.getAll()

    fun addrandombarcode() {
        var randombarcode = (100000..999999).random().toString()
        val scanData = ScanData(barcode = randombarcode)
        viewModelScope.launch {
            offlinescanDataRepository.insert(scanData)
        }
    }





/*    // how to initialize the UI state
    init {
        //TODO: initialize UI state
    }*/

    /**
     * Gets Scan data information from the Scan API Retrofit service and updates the
     * [ScanData] [List] [MutableList].
     */


    /**
     * Factory for [ScanViewModel] that takes [ScanDataRepository] as a dependency
     */

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ScanDataApplication)
                val offlineScanDataRepository = application.container.offlineScanDataRepository
                ScanViewModel(offlineScanDataRepository)
            }
        }
    }

}