package com.example.epe2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Clases_ACT extends AppCompatActivity {
    private DBHelper dbHelper;
    private EditText editTextCodigo;
    private EditText editTextLocal;
    private EditText editTextDesc;
    private Button btnAñadir;
    private Button btnMostrar;
    private Button btnEliminar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextLocal = findViewById(R.id.editTextLocal);
        editTextDesc = findViewById(R.id.editTextDesc);
        btnAñadir = findViewById(R.id.btnAñadir);
        btnEliminar = findViewById(R.id.btnEliminar);



        // Crear una instancia de DBHelper
        dbHelper = new DBHelper(this);

        // Obtener una instancia de SQLiteDatabase
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        // Realizar operaciones en la base de datos (ejemplo: insertar registros)
        ContentValues values = new ContentValues();
        values.put("local", "Local A");
        values.put("descripcion", "Descripción del Local A");
        database.insert("completo", null, values);

        // Cerrar la base de datos cuando hayas terminado
        dbHelper.close();
    }
    public void guardarDatos(View view) {
        // Obtener los valores ingresados por el usuario
        int codigo = Integer.parseInt(editTextCodigo.getText().toString());
        String local = editTextLocal.getText().toString();
        String descripcion = editTextDesc.getText().toString();

        // Crear una instancia de DBHelper
        DBHelper dbHelper = new DBHelper(this);

        // Obtener una instancia de SQLiteDatabase
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        // Crear un objeto ContentValues con los datos a insertar
        ContentValues values = new ContentValues();
        values.put("idcompleto", codigo);
        values.put("local", local);
        values.put("descripcion", descripcion);

        // Insertar los datos en la base de datos
        long result = database.insert("completo", null, values);

        if (result != -1) {
            Toast.makeText(this, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al ingresar los datos", Toast.LENGTH_SHORT).show();
        }

        // Cerrar la base de datos cuando hayas terminado
        dbHelper.close();
    }
    public void mostrarDatos(View view) {
        // Obtener el valor ingresado por el usuario
        int codigo = Integer.parseInt(editTextCodigo.getText().toString());

        // Crear una instancia de DBHelper
        DBHelper dbHelper = new DBHelper(this);

        // Obtener una instancia de SQLiteDatabase
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        // Realizar la consulta en la base de datos
        String query = "SELECT local, descripcion FROM completo WHERE idcompleto = ?";
        Cursor cursor = database.rawQuery(query, new String[]{String.valueOf(codigo)});

        // Verificar si se encontraron resultados
        if (cursor.moveToFirst()) {
            // Obtener los datos del cursor
            String local = cursor.getString(cursor.getColumnIndex("local"));
            String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));

            // Asignar los valores a los campos de entrada de texto
            editTextLocal.setText(local);
            editTextDesc.setText(descripcion);
        } else {
            // No se encontraron datos para el código ingresado
            editTextLocal.setText("");
            editTextDesc.setText("");
            Toast.makeText(this, "No se encontraron datos para el código ingresado", Toast.LENGTH_SHORT).show();
        }

        // Cerrar el cursor y la base de datos cuando hayas terminado
        cursor.close();
        dbHelper.close();
    }

    public void eliminarDatos(View view) {
        // Obtener el idcompleto ingresado por el usuario
        int idcompleto = Integer.parseInt(editTextCodigo.getText().toString());

        // Crear una instancia de DBHelper
        DBHelper dbHelper = new DBHelper(this);

        // Obtener una instancia de SQLiteDatabase
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        // Eliminar los datos relacionados al idcompleto de la tabla completo
        int result = database.delete("completo", "idcompleto = ?", new String[]{String.valueOf(idcompleto)});

        if (result > 0) {
            Toast.makeText(this, "Datos eliminados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se encontraron datos para el idcompleto especificado", Toast.LENGTH_SHORT).show();
        }

        // Cerrar la base de datos cuando hayas terminado
        dbHelper.close();
    }

    public void actualizarDatos(View view) {
        // Obtener el idcompleto ingresado por el usuario
        int idcompleto = Integer.parseInt(editTextCodigo.getText().toString());

        // Obtener los nuevos valores ingresados por el usuario
        String local = editTextLocal.getText().toString();
        String descripcion = editTextDesc.getText().toString();

        // Crear una instancia de DBHelper
        DBHelper dbHelper = new DBHelper(this);

        // Obtener una instancia de SQLiteDatabase
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        // Crear un objeto ContentValues con los nuevos valores
        ContentValues values = new ContentValues();
        values.put("local", local);
        values.put("descripcion", descripcion);

        // Actualizar los datos en la tabla completo
        int result = database.update("completo", values, "idcompleto = ?", new String[]{String.valueOf(idcompleto)});

        if (result > 0) {
            Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se encontraron datos para el idcompleto especificado", Toast.LENGTH_SHORT).show();
        }

        // Cerrar la base de datos cuando hayas terminado
        dbHelper.close();
    }

}