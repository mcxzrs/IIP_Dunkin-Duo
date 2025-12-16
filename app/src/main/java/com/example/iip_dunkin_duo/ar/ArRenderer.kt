package com.example.iip_dunkin_duo.ar

import android.content.Context
import com.google.ar.core.*
import javax.microedition.khronos.opengles.GL10
import javax.microedition.khronos.egl.EGLConfig
import android.opengl.GLSurfaceView
import com.example.iip_dunkin_duo.ar.render.BackgroundRenderer
import com.example.iip_dunkin_duo.common.samplerender.SampleRender

class ArRenderer(
    private val context: Context
) : SampleRender.Renderer {

    lateinit var sampleRender: SampleRender

    private lateinit var session: Session

    private lateinit var backgroundRenderer: BackgroundRenderer

    override fun onSurfaceCreated(render: SampleRender) {
        sampleRender = render
        session = Session(context)

        session.configure(
            Config(session).apply {
                planeFindingMode = Config.PlaneFindingMode.HORIZONTAL
            }
        )

        backgroundRenderer = BackgroundRenderer(render)
        backgroundRenderer.setUseDepthVisualization(render, false)
    }

    override fun onSurfaceChanged(
        render: SampleRender?,
        width: Int,
        height: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun onDrawFrame(render: SampleRender) {

        val frame = session.update()

        // REQUIRED for camera texture
        backgroundRenderer.updateDisplayGeometry(frame)

        // Draw camera image
        backgroundRenderer.drawBackground(render)

        val camera = frame.camera
        if (camera.trackingState != TrackingState.TRACKING) return

        // draw image planes here later
    }

}
