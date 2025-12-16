package com.example.iip_dunkin_duo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import com.example.iip_dunkin_duo.common.helpers.ARCoreSessionLifecycleHelper

@Composable
fun ArScreen(
    lifecycle: Lifecycle,
    arSessionHelper: ARCoreSessionLifecycleHelper
) {
    Box(modifier = Modifier.fillMaxSize()) {

        ArSurface(
            lifecycle = lifecycle,
            arSessionHelper = arSessionHelper
        )

        FloatingActionButton(
            onClick = { /* later */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add image")
        }
    }
}
