package com.example.epe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class insumos_ACT extends AppCompatActivity {

    Spinner spinner;
    RatingBar ratingBar;
    TextView textView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        Button btnCalificar = findViewById(R.id.btnCalificar);
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textInsumos);

        btnCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarAgradecimiento();
            }
        });

        // Crear un arreglo de elementos
        String[] items = {"Completo italiano",
                "Completo dinamico",
                "completo clasico",
                "completo americano",
                "completo espacial"};

        // Crear un ArrayAdapter y asignarlo al Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el elemento seleccionado del Spinner
                String selectedItem = parent.getItemAtPosition(position).toString();

                // Mostrar el elemento seleccionado en el TextView
                textView.setText(selectedItem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Acción a realizar cuando no se selecciona ningún elemento
            }




        });

        ratingBar = findViewById(R.id.ratingBar);
        float rating = ratingBar.getRating();  // Obtener el valor actual del RatingBar
        ratingBar.setRating(3.5f);  // Establecer el valor del RatingBar a 3.5
    }

    private void mostrarAgradecimiento() {
        Toast.makeText(this, "¡Gracias por tu opinión!", Toast.LENGTH_SHORT).show();

    }


}









