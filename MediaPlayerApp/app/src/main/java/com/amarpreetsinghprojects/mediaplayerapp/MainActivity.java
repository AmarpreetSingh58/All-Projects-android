package com.amarpreetsinghprojects.mediaplayerapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mp = MediaPlayer.create(this,R.raw.audio); to play file present locally.
        //Uri uri = Uri.parse("android.resources://<package name>/"+R.raw.audio); to make uri from a resource
       // Uri uri = Uri.parse("android.resources://com.amarpreetsinghprojects.mediaplayerapp/"+R.raw.audio); to make uri from a resource
         /*
         this is synchronus in nature.
         mp = MediaPlayer.create(this, Uri.parse("https://raw.githubusercontent.com/the-dagger/sample-media/master/audio.mp3"));
        mp.start();*/

        // this is asynchronous in nature.
        Uri uri = Uri.parse("https://raw.githubusercontent.com/the-dagger/sample-media/master/audio.mp3");
        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mp.setDataSource(this,uri);
            mp.prepareAsync();
            final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressbar);
            progressBar.setVisibility(View.VISIBLE);

            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.INVISIBLE);
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Boolean[] paused = {false};
        final Button playPauseButton = (Button)findViewById(R.id.play_pause_button);
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paused[0] = false){
                    mp.pause();

                    paused[0] =true;

                }
                else {
                    mp.start();
                    paused[0] = false;
                }

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.release();
    }
}
