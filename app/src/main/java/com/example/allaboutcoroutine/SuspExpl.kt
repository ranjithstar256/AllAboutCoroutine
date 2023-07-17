package com.example.allaboutcoroutine

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

class SuspExpl {
}
@Composable
fun MyScreen() {
    var data by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        data = fetchData4()
    }

    Text(text = data)
}

 suspend fun fetchData4(): String {
    // Simulating a network request delay
    delay(2000)

    return "Fetched data from the network"
}
