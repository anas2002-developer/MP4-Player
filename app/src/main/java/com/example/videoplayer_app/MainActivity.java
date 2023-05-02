package com.example.videoplayer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaController2;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    VideoView vVV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vVV = findViewById(R.id.vVV);

        //raw folder - rubicorn drill
        String videoPath_app = "android.resource://"+getPackageName()+"/raw/vid_rubicorndrill";

        //online - rubicorn drill
//        String videoPath_online = "path";
        
        Uri videoPath_app_uri = Uri.parse(videoPath_app);

        findViewById(R.id.btnPlayVid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vVV.setVideoURI(videoPath_app_uri);
                vVV.start();

                //android.widget.MediaController
                //for allowing seekBar with pop up function and buttons for play and skip 5sec
                MediaController mediaController = new MediaController(MainActivity.this);
                mediaController.setAnchorView(vVV);
                vVV.setMediaController(mediaController);
            }
        });
    }
}