package com.ceduc.comm

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteDB(context: Context) : SQLiteOpenHelper(context, "productos", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE productos (id INTEGER PRIMARY KEY AUTOINCREMENT, code TEXT, descripcion TEXT, precio REAL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    // Insertar un producto en la base de datos
    fun insertarProducto(codigo: String, descripcion: String, precio: Double): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("code", codigo)
            put("descripcion", descripcion)
            put("precio", precio)
        }
        val id = db.insert("productos", null, values)
        db.close()
        return id
    }

    // Obtener todos los productos de la base de datos
    fun obtenerTodosLosProductos(): ArrayList<Producto> {
        val productos = ArrayList<Producto>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM productos", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndex("id"))
                val codigo = cursor.getString(cursor.getColumnIndex("code"))
                val descripcion = cursor.getString(cursor.getColumnIndex("descripcion"))
                val precio = cursor.getDouble(cursor.getColumnIndex("precio"))
                productos.add(Producto(id, codigo, descripcion, precio))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return productos
    }

    // Actualizar un producto existente
    fun actualizarProducto(id: Long, codigo: String, descripcion: String, precio: Double): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("code", codigo)
            put("descripcion", descripcion)
            put("precio", precio)
        }
        val count = db.update("productos", values, "id=?", arrayOf(id.toString()))
        db.close()
        return count
    }


}

