package com.example.aplicaciondam2

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        val recycler = findViewById<RecyclerView>(R.id.recyclerHistorial)
        val botonVolver = findViewById<Button>(R.id.botonVolverHistorial)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = HistorialAdapter(Historial.personas)

        botonVolver.setOnClickListener {
            finish()
        }
    }
}