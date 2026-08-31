package com.example.formulario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioCodigoRestorepassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_codigo_restorepassword)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val correo = intent.getStringExtra("email").orEmpty()
        val mensajeCorreo = findViewById<TextView>(R.id.mensajeCorreo)
        val codigo = findViewById<EditText>(R.id.codigo)
        val nuevaContrasena = findViewById<EditText>(R.id.nuevaContrasena)
        val repetirContrasena = findViewById<EditText>(R.id.repetirContrasena)
        val botonRecuperar = findViewById<Button>(R.id.recuperar)

        mensajeCorreo.text = if (correo.isNotBlank()) {
            "Codigo enviado a: $correo"
        } else {
            "Codigo enviado al correo registrado"
        }

        botonRecuperar.setOnClickListener {
            val Tcodigo = codigo.text.toString()
            val TnuevaContrasena = nuevaContrasena.text.toString()
            val TrepetirContrasena = repetirContrasena.text.toString()

            if (Tcodigo.isBlank() || TnuevaContrasena.isBlank() || TrepetirContrasena.isBlank()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TnuevaContrasena != TrepetirContrasena) {
                Toast.makeText(this, "Las contrasenas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            AlertDialog.Builder(this)
                .setTitle("Listo")
                .setMessage("Codigo verificado. Tu contrasena fue actualizada de forma simulada.")
                .setPositiveButton("Aceptar", null)
                .show()
        }
    }
}
