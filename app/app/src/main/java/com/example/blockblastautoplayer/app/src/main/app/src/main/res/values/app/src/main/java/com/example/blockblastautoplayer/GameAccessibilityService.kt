package com.example.blockblastautoplayer

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent

class GameAccessibilityService : AccessibilityService() {

    companion object {
        var running = false
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}

    override fun onInterrupt() {
        running = false
    }

    fun stopBot() {
        running = false
    }

    fun drag(
        fromX: Float,
        fromY: Float,
        toX: Float,
        toY: Float
    ) {
        if (!running) return

        val path = Path().apply {
            moveTo(fromX, fromY)
            lineTo(toX, toY)
        }

        val gesture = GestureDescription.Builder()
            .addStroke(
                GestureDescription.StrokeDescription(
                    path, 0, 350
                )
            )
            .build()

        dispatchGesture(gesture, null, null)
    }
}
