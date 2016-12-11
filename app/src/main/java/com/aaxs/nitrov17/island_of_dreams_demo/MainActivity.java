package com.aaxs.nitrov17.island_of_dreams_demo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView vv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        vv = (VideoView)findViewById(R.id.VideoView01);

        //Video Loop
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                vv.start(); //need to make transition seamless.
            }
        });

        Uri uri = Uri.parse("android.resource://com.aaxs.nitrov17.island_of_dreams_demo/"
                + R.raw.a);

        vv.setVideoURI(uri);
        vv.setScaleX(1);
        vv.setScaleY(1);
        vv.requestFocus();
        vv.start();

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

}
