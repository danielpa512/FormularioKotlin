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

class FormularioRestorepassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_restorepassword)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val email = findViewById<EditText>(R.id.email)

        val botonEnviar = findViewById<Button>(R.id.enviar)

        botonEnviar.setOnClickListener {
            val Temail = email.text.toString()

            if (Temail.isBlank()) {
                Toast.makeText(this, "Ingresa tu correo primero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Hola , se envio el codigo de recuperacion a \n tu Correo Electronico es: $Temail ",
                Toast.LENGTH_LONG
            ).show()

            AlertDialog.Builder(this)
                .setTitle("Enviado")
                .setMessage("Hola , se envio el codigo de recuperacion a \n tu Correo Electronico es: $Temail ")
                .setPositiveButton("Aceptar") { _, _ ->
                    val intent = Intent(this, FormularioCodigoRestorepassword::class.java)
                    intent.putExtra("email", Temail)
                    startActivity(intent)
                }
                .show()

        }


    }
}
