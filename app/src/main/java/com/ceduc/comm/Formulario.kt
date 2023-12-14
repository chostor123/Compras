package com.ceduc.comm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Formulario : AppCompatActivity() {

    private lateinit var editTextCode: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var editTextPrice: EditText
    private lateinit var buttonSave: Button

    private lateinit var db: SQLiteDB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        db = SQLiteDB(this)


        editTextCode = findViewById(R.id.editTextCode)
        editTextDescription = findViewById(R.id.editTextDescription)
        editTextPrice = findViewById(R.id.editTextPrice)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener {
            val code = editTextCode.text.toString()
            val description = editTextDescription.text.toString()
            val price = editTextPrice.text.toString()

            if (code.isNotEmpty() && description.isNotEmpty() && price.isNotEmpty()) {
                val precioDouble = price.toDouble()


                db.insertarProducto(code, description, precioDouble)



                Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
