package com.example.iip_dunkin_duo

import android.opengl.GLSurfaceView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import com.example.iip_dunkin_duo.common.helpers.ARCoreSessionLifecycleHelper
import com.example.iip_dunkin_duo.common.samplerender.SampleRender

@Composable
fun ArSurface(
    lifecycle: Lifecycle,
    arSessionHelper: ARCoreSessionLifecycleHelper
) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->

            val surfaceView = GLSurfaceView(context).apply {
                preserveEGLContextOnPause = true
                setEGLContextClientVersion(2)
            }

            val renderer = ArRenderer(context)
            lifecycle.addObserver(renderer)

            SampleRender(surfaceView, renderer, context.assets)

            surfaceView
        }
    )
}
