package com.mymusic.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Muplay extends AppCompatActivity {
ImageView cdplayer ,cdbac;
TextView tre1,tre2,tre3;
 int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muplay);
        cdplayer =findViewById(R.id.bbroim);
        cdbac =findViewById(R.id.bbmove);
        tre1 =findViewById(R.id.mvmove);
        tre2 =findViewById(R.id.mmove);
        tre3 =findViewById(R.id.mnbmove);

       Muplay.this.runOnUiThread(new Runnable() {
           @Override
           public void run() {
               cdplayer.setRotation(x++);
               new Handler().postDelayed(this,20);

           }
       });

       cdplayer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent =new Intent(Muplay.this,Homepage.class);
               startActivity(intent);
           }
       });

        cdbac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Muplay.this,Homepage.class);
                startActivity(intent);
            }
        });
        tre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Muplay.this,Homepage.class);
                startActivity(intent);
            }
        });

        tre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Muplay.this,Homepage.class);
                startActivity(intent);
            }
        });
        tre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Muplay.this,Homepage.class);
                startActivity(intent);
            }
        });




    }

}