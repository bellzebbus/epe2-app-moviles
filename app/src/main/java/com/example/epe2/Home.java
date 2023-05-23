package com.example.epe2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URL;

public class Home {

    VideoView videoView;

    protected void onCreate(Bundle savedInstanceState) {


        setContentView(R.layout.home);

            videoView = (VideoView)findViewByID(R.id.videoView);
            Uri uri= Uri.parse("https://www.youtube.com/shorts/de6g4zz6Gt4");
            videoView.setMediaController((new MediaController(this)));
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();


    }

}
