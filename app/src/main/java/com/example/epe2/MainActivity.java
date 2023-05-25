package com.example.epe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editTextUsername = findViewById(R.id.editTextNombre);
        editTextPassword = findViewById(R.id.editTextPass);
        buttonLogin = findViewById(R.id.btnIngresar);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.equals("administrador") && password.equals("123")) {
                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Clases_ACT.class);
                    startActivity(intent);
                } else {
                    if (username.equals("sebastian") && password.equals("123")) {
                        Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Clases_ACT.class);
                        startActivity(intent);
                    }
                    if (username.equals("martin") && password.equals("123")) {
                        Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Clases_ACT.class);
                        startActivity(intent);
                    }
                    if (username.equals("") && password.equals("")) {
                        Toast.makeText(MainActivity.this, "Por favor ingrese sus credenciales", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
    }
}