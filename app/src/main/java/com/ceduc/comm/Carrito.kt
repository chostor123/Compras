package com.ceduc.comm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast

class Carrito : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        val codigoProducto = "Dron"
        val descripcion = "Producto"
        val precio = 1000.0

        val txtProd: TextView = findViewById(R.id.txtProd)
        val message = "Código: $codigoProducto\nDescripción: $descripcion\nPrecio: $precio"
        txtProd.text = message

        Toast.makeText(this, "¡Carrito abierto!", Toast.LENGTH_SHORT).show()
    }
}
