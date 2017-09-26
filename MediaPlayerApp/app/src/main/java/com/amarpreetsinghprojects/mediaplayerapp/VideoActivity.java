package com.amarpreetsinghprojects.mediaplayerapp;

import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        final VideoView videoView = (VideoView)findViewById(R.id.videoView);

       Uri uri = Uri.parse("android.resource://com.amarpreetsinghprojects.mediaplayerapp/"+R.raw.video);

       // Uri uri = Uri.parse("https://raw.githubusercontent.com/the-dagger/sample-media/master/video.mp4");

        videoView.setVideoURI(uri);

        android.widget.MediaController mediaController = new android.widget.MediaController(this);

        mediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // videoView.getCurrentPosition();
                Toast.makeText(VideoActivity.this, ""+ videoView.getCurrentPosition(), Toast.LENGTH_SHORT).show();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // videoView.getCurrentPosition();
                Toast.makeText(VideoActivity.this, ""+ videoView.getCurrentPosition(), Toast.LENGTH_SHORT).show();
            }
        });
        
        videoView.setMediaController(mediaController);
        videoView.start();


    }
}
