package com.skm.soothe;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    boolean night = true;
    boolean[] isPlaying = {false, false, false, false, false, false};
    int[] song = {R.raw.violin, R.raw.piano, R.raw.guitar, R.raw.thunder, R.raw.rain, R.raw.bird};
    int[] imgColored = {R.drawable.violinc, R.drawable.pianoc, R.drawable.guitarc, R.drawable.thunderc, R.drawable.rainc, R.drawable.birdc};
    int[] imgUncolored = {R.drawable.vu, R.drawable.pu, R.drawable.gu, R.drawable.tu, R.drawable.ru, R.drawable.bu};

    int btnTag = -1;
    MediaPlayer[] mediaPlayer = new MediaPlayer[6];

    public void changeBG(View view){
        ConstraintLayout constraintLayout = findViewById(R.id.mainLay);

        if(!night){
            constraintLayout.setBackgroundResource(R.drawable.night);
            night = true;
        }
        else{
            constraintLayout.setBackgroundResource(R.drawable.light);
            night = false;
        }

    }

    public void btnPressed(View view){
        ImageView imageView = (ImageView) view;

        btnTag = Integer.parseInt(imageView.getTag().toString());

        if((!isPlaying[btnTag])){
            mediaPlayer[btnTag] = MediaPlayer.create(this, song[btnTag]);

            mediaPlayer[btnTag].start();

            mediaPlayer[btnTag].setLooping(true);

            isPlaying[btnTag] = true;

            imageView.setImageResource(imgColored[btnTag]);
        }

        else{
            mediaPlayer[btnTag].pause();
            mediaPlayer[btnTag].seekTo(0);

            mediaPlayer[btnTag].setLooping(false);

            imageView.setImageResource(imgUncolored[btnTag]);

            isPlaying[btnTag] = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}