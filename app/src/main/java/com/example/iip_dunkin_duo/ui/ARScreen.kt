package com.example.iip_dunkin_duo.ui

import android.opengl.GLSurfaceView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.example.iip_dunkin_duo.ar.ArRenderer
import com.example.iip_dunkin_duo.common.samplerender.SampleRender

@Composable
fun ARScreen(onRendererReady: (ArRenderer) -> Unit) {
    AndroidView(
        factory = { context ->
            GLSurfaceView(context).apply {
                val renderer = ArRenderer(context)
                onRendererReady(renderer)
                SampleRender(this, renderer, context.assets)
            }
        }
    )
}

