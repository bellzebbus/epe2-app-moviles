package com.example.epe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home_ACT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void cambiarActClases(View view) {
        Intent intent = new Intent(home_ACT.this, Clases_ACT.class);
        startActivity(intent);
    }
    public void cambiarActInfo(View view) {
        Intent intent = new Intent(home_ACT.this, infos_ACT.class);
        startActivity(intent);
    }

}