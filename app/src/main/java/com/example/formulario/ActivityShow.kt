package com.example.formulario

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityShow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val Estudiante = intent.getSerializableExtra("estudiante") as? student

        val TxtNombre = findViewById<TextView>(R.id.nombre)
        val TxtEdad = findViewById<TextView>(R.id.edad)
        val TxtEmail = findViewById<TextView>(R.id.email)
        val botonSalir = findViewById<Button>(R.id.salir)

        TxtNombre.text = Estudiante?.nombre ?: "Sin nombre"
        TxtEdad.text = Estudiante?.edad?.toString() ?: "Sin edad"
        TxtEmail.text = Estudiante?.email ?: "Sin email"

        botonSalir.setOnClickListener {
            finishAffinity()
        }
    }
}
