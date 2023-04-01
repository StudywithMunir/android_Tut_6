package com.example.android_tut_6;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class activity_2 extends Activity {

    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ourSong=MediaPlayer.create(activity_2.this, R.raw.sigma);
        ourSong.start();

        Thread timer = new Thread(){
          public void run(){
              try {
                  sleep(5000);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }finally {
                  Intent OpenMainAct = new Intent("com.example.android_tut_6.Menu");
                  startActivity(OpenMainAct);
              }
          }
        };
        timer.start();




    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.release();
        finish();
    }
}
