package com.example.formulario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val botonFormulario = findViewById<Button>(R.id.formulario)

        botonFormulario.setOnClickListener {

            val intent = Intent(this, FormularioActivity::class.java)

            startActivity(intent);
        }

        val botonPassword = findViewById<Button>(R.id.password)

        botonPassword.setOnClickListener {

            val intent = Intent(this, FormularioRestorepassword::class.java)

            startActivity(intent);
        }

        val botonLogin = findViewById<Button>(R.id.login)

        botonLogin.setOnClickListener {

            val intent = Intent(this, FormularioLogin::class.java)

            startActivity(intent);
        }



    }

}