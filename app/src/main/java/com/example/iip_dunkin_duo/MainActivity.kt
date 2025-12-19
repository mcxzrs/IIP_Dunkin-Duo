package com.example.iip_dunkin_duo

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.iip_dunkin_duo.ar.ArRenderer
import com.example.iip_dunkin_duo.ui.ARScreen
import com.example.iip_dunkin_duo.ui.theme.IIP_Dunkin_DuoTheme

class MainActivity : ComponentActivity() {

    private var renderer: ArRenderer? = null

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                renderer?.onCameraPermissionGranted()
            } else {
                finish() // or show error UI
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IIP_Dunkin_DuoTheme {
                ARScreen { r ->
                    renderer = r
                }
            }
        }

        if (checkSelfPermission(Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            permissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    override fun onResume() {
        super.onResume()
        renderer?.onResume()
    }

    override fun onPause() {
        renderer?.onPause()
        super.onPause()
    }
}



