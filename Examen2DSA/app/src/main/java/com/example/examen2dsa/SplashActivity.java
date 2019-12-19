package com.example.examen2dsa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar splashProgress;
    private ImageView diputacioBCNlogoImageView;
    //Context context; //In order to open the new Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashProgress = findViewById(R.id.splashProgressBar);
        diputacioBCNlogoImageView = findViewById(R.id.dialogoImageView);

        //Load 'Diputacio de Barcelona' logo (https://www.vectorlogo.es/wp-content/uploads/2014/12/logo-vector-diputacion-barcelona-horizontal.jpg)
        Picasso.with(this).load("https://www.vectorlogo.es/wp-content/uploads/2014/12/logo-vector-diputacion-barcelona-horizontal.jpg").noFade().into(diputacioBCNlogoImageView);

        //We will open the new Activity when 'loading time' is finished
        Random r = new Random();
        int loadtime = (r.nextInt(9 - 4) + 4);
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Open the ListActivity
                Intent intent = new Intent (getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        }, 9000);

    }
}
