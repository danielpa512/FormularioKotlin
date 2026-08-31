package com.example.formulario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val email = findViewById<EditText>(R.id.email)
        val contraseña = findViewById<EditText>(R.id.contraseña)
        val botonEnviar = findViewById<Button>(R.id.enviar)

        botonEnviar.setOnClickListener {
            val Temail = email.text.toString()
            val Tcontraseña = contraseña.text.toString()

            Toast.makeText(
                this,
                "Hola estas intentando inciar con el correo \n $Temail \n y contraseña : \n $Tcontraseña ",
                Toast.LENGTH_LONG
            ).show()

            AlertDialog.Builder(this)
                .setTitle("Enviado")
                .setMessage("Hola estas intentando inciar con el correo \n $Temail \n y contraseña : \n $Tcontraseña ")
                .setPositiveButton("Aceptar",null)
                .show()

        }


    }
}
