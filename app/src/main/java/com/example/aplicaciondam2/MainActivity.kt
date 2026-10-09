package com.example.aplicaciondam2  // cambia esto por el package real de cada proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texto = findViewById<TextView>(R.id.textoSaludo)
        val editNombre = findViewById<EditText>(R.id.editNombre)
        val editEdad = findViewById<EditText>(R.id.editEdad)
        val boton = findViewById<Button>(R.id.botonSaludo)
        val botonVerHistorial = findViewById<Button>(R.id.botonVerHistorial)

        val prefs = getSharedPreferences("MisDatos", MODE_PRIVATE)
        val nombreGuardado = prefs.getString("NOMBRE_GUARDADO", "")
        editNombre.setText(nombreGuardado)

        boton.setOnClickListener {
            val nombre = editNombre.text.toString()
            val edadTexto = editEdad.text.toString()

            when {
                nombre.isEmpty() -> {
                    Toast.makeText(this, "Escribe tu nombre antes de continuar", Toast.LENGTH_SHORT).show()
                }
                edadTexto.isEmpty() -> {
                    Toast.makeText(this, "Escribe tu edad antes de continuar", Toast.LENGTH_SHORT).show()
                }
                edadTexto.toIntOrNull() == null -> {
                    Toast.makeText(this, "La edad tiene que ser un número", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    prefs.edit().putString("NOMBRE_GUARDADO", nombre).apply()

                    val edad = edadTexto.toIntOrNull() ?: 0
                    Historial.personas.add(Persona(nombre, edad))

                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("NOMBRE_EXTRA", nombre)
                    intent.putExtra("EDAD_EXTRA", edadTexto)
                    startActivity(intent)
                }
            }
        }

        botonVerHistorial.setOnClickListener {
            startActivity(Intent(this, HistorialActivity::class.java))
        }
    }
}