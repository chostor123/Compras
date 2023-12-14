package com.ceduc.comm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botón 1
        val button1: ImageButton = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(this, Formulario::class.java)
            startActivity(intent)
        }

        // Botón 2
        val button2: ImageButton = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, Formulario::class.java)
            startActivity(intent)
        }

        // Botón 3
        val button3: ImageButton = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, Formulario::class.java)
            startActivity(intent)
        }

        // Botón 4
        val button4: ImageButton = findViewById(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this, Formulario::class.java)
            startActivity(intent)
        }

        // Resto de tu lógica para los botones 5 y 6 (ver carrito y lista)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)

        button6.setOnClickListener {
            // Ir a la actividad Lista
            val intent = Intent(this, Lista::class.java)
            startActivity(intent)
        }

        button5.setOnClickListener {
            // Ir a la actividad Carrito
            val intent = Intent(this, Carrito::class.java)
            startActivity(intent)
        }
    }
}

