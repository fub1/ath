package com.iuioo.ath.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import java.io.IOException
// network request exception
//import retrofit2.HttpException


// Viewmodel in this version commit is without useful function
class ScanViewModel : ViewModel() {
    //define UI state
    //TODO: define UI state


    // how to initialize the UI state
    init {
        //TODO: initialize UI state
    }

    /**
     * Gets Scan data information from the Scan API Retrofit service and updates the
     * [ScanData] [List] [MutableList].
     */


    /**
     * Factory for [ScanViewModel] that takes [ScanDataRepository] as a dependency
     */

    // TODO: implement factory
/*    class Factory(private val scanDataRepository: ScanDataRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ScanViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ScanViewModel(scanDataRepository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }*/
}