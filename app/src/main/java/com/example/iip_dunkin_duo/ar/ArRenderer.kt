package com.example.iip_dunkin_duo.ar

import android.content.Context
import com.google.ar.core.*
import javax.microedition.khronos.opengles.GL10
import javax.microedition.khronos.egl.EGLConfig
import android.opengl.GLSurfaceView
import com.example.iip_dunkin_duo.ar.render.BackgroundRenderer

class ArRenderer(
    private val context: Context
) : GLSurfaceView.Renderer {

    private val backgroundRenderer = BackgroundRenderer()

    lateinit var session: Session

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        session = Session(context)
        session.configure(
            Config(session).apply {
                planeFindingMode = Config.PlaneFindingMode.HORIZONTAL
            }
        )
        backgroundRenderer.createOnGlThread(context)
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        session.setDisplayGeometry(0, width, height)
    }

    override fun onDrawFrame(gl: GL10?) {
        val frame = session.update()
        backgroundRenderer.draw(frame)

        val camera = frame.camera

        if (camera.trackingState != TrackingState.TRACKING) return

        // Rendering comes next
    }
}
