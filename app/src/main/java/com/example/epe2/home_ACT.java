package com.example.epe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class home_ACT extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videocompleto));
        videoView.start();
    }



    public void cambiarActClases(View view) {
        Intent intent = new Intent(home_ACT.this, Clases_ACT.class);
        startActivity(intent);
    }
    public void cambiarActInfo(View view) {
        Intent intent = new Intent(home_ACT.this, infos_ACT.class);
        startActivity(intent);
    }
    public void cambiarActInsumos(View view) {
        Intent intent = new Intent(home_ACT.this, insumos_ACT.class);
        startActivity(intent);
    }

}