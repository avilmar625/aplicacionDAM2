package com.example.aplicaciondam2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistorialAdapter(private val personas: List<Persona>) :
    RecyclerView.Adapter<HistorialAdapter.PersonaViewHolder>() {

    class PersonaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textoNombre: TextView = view.findViewById(R.id.textoNombreFila)
        val textoEdad: TextView = view.findViewById(R.id.textoEdadFila)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.fila_persona, parent, false)
        return PersonaViewHolder(vista)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val persona = personas[position]
        holder.textoNombre.text = persona.nombre
        holder.textoEdad.text = "${persona.edad} años"
    }

    override fun getItemCount(): Int = personas.size
}