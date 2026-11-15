package com.example.blockblastautoplayer

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(30, 50, 30, 30)

        val title = TextView(this)
        title.text = "Block Blast Auto Player"
        title.textSize = 24f

        val status = TextView(this)
        status.text = "Статус: остановлен"
        status.textSize = 18f

        val start = Button(this)
        start.text = "START"
        start.setOnClickListener {
            status.text = "Статус: запущен"
        }

        val stop = Button(this)
        stop.text = "STOP"
        stop.setOnClickListener {
            status.text = "Статус: остановлен"
        }

        layout.addView(title)
        layout.addView(status)
        layout.addView(start)
        layout.addView(stop)

        setContentView(layout)
    }
}
