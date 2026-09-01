package com.example.formulario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val nombre = findViewById<EditText>(R.id.nombre)
        val edad = findViewById<EditText>(R.id.edad)
        val email = findViewById<EditText>(R.id.email)
        val botonEnviar = findViewById<Button>(R.id.enviar)

        botonEnviar.setOnClickListener {
            val TextNombre = nombre.text.toString()
            val Tedad = edad.text.toString()
            val Temail = email.text.toString()

            if (TextNombre.isBlank() || Tedad.isBlank() || Temail.isBlank()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val edadNumero = Tedad.toIntOrNull()

            if (edadNumero == null) {
                Toast.makeText(this, "La edad debe ser un numero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val estudiante1 = student(TextNombre, edadNumero, Temail)

            var intent = Intent(this, ActivityShow::class.java)

            intent.putExtra("estudiante", estudiante1)

            startActivity(intent)

        }


    }
}
