package com.example.iip_dunkin_duo.ar

import android.content.Context
import com.example.iip_dunkin_duo.ar.render.BackgroundRenderer
import com.example.iip_dunkin_duo.common.samplerender.SampleRender
import com.google.ar.core.*

class ArRenderer(
    private val context: Context
) : SampleRender.Renderer {

    private lateinit var backgroundRenderer: BackgroundRenderer
    private var session: Session? = null
    private var hasCameraPermission = false

    fun onCameraPermissionGranted() {
        hasCameraPermission = true
    }

    fun onResume() {
        if (!hasCameraPermission || session != null) return

        session = Session(context).apply {
            configure(
                Config(this).apply {
                    planeFindingMode = Config.PlaneFindingMode.HORIZONTAL
                }
            )
            resume()
        }
    }


    fun onPause() {
        session?.pause()
    }


    override fun onSurfaceCreated(render: SampleRender) {
        backgroundRenderer = BackgroundRenderer(render)
    }


    override fun onSurfaceChanged(render: SampleRender, width: Int, height: Int) {
        session?.setDisplayGeometry(0, width, height)
    }


    override fun onDrawFrame(render: SampleRender) {
        val s = session ?: return

        val frame = s.update()

        // 🔑 REQUIRED
        backgroundRenderer.updateDisplayGeometry(frame)

        // Draw camera image
        backgroundRenderer.drawBackground(render)

        val camera = frame.camera
        if (camera.trackingState != TrackingState.TRACKING) return

        // Virtual content will go here later
    }



}
