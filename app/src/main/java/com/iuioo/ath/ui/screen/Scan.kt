package com.iuioo.ath.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iuioo.ath.ui.screen.ScanViewModel


@Composable
fun scanX() {
    val viewModel: ScanViewModel = viewModel(factory = ScanViewModel.Factory)
    val bar by viewModel.allBarcode.collectAsState(initial = emptyList())
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Scan Screen",
            style = MaterialTheme.typography.bodyMedium
        )
        Button(onClick = { viewModel.addrandombarcode() }) {
            Text(text = "Scan")
        }
        LazyColumn {
            items(bar) { barcode ->
                Text("Barcode: ${barcode.barcode.toString()}")
            }
        }
    }
}