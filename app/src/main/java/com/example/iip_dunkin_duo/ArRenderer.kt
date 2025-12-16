package com.example.iip_dunkin_duo

import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import com.example.iip_dunkin_duo.common.samplerender.SampleRender

class ArRenderer(
    private val context: Context
) : SampleRender.Renderer, DefaultLifecycleObserver {

    override fun onSurfaceCreated(render: SampleRender) {
        // Will set up background, plane renderer, shaders later
    }

    override fun onSurfaceChanged(
        render: SampleRender,
        width: Int,
        height: Int
    ) {
        // Called when surface size changes (rotation, resize)
        // Nothing needed for now
    }

    override fun onDrawFrame(render: SampleRender) {
        // Draw AR frame
    }
}

