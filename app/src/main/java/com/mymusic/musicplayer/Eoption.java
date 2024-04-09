package com.mymusic.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Eoption extends AppCompatActivity {

    TextView songname;
    CardView ca0001,ca0002,ca0006,ca0007 ;

    public Musicpage musicpage;
    ImageView soimg;
    int[] imagelist={R.drawable.mbac1,R.drawable.mbac2,R.drawable.tur1,R.drawable.tur2,R.drawable.tur3,R.drawable.tur4,R.drawable.tur5,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eoption);
        songname =findViewById(R.id.musname);
        ca0001 =findViewById(R.id.ccust01);
        ca0002 =findViewById(R.id.ccust02);
        ca0006 =findViewById(R.id.ccust06);
        ca0007 =findViewById(R.id.ccust07);
        soimg =findViewById(R.id.musimg);


        SharedPreferences preferences =getSharedPreferences("Play_Song" , Context.MODE_PRIVATE);
        String Mysong =preferences.getString("Music_Name",null);
        int Mysongimg =preferences.getInt("Music_Image",0);
        songname.setText(Mysong);
        soimg.setImageResource(imagelist[Mysongimg]);

        ca0001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Eoption.this,Homepage.class);
                startActivity(intent);
                finish();
            }
        });

        ca0002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Eoption.this,Light.class);
                startActivity(intent);
                finish();
            }
        });

        ca0006.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Eoption.this,Close_App.class);
                startActivity(intent);
                finish();



            }
        });

        ca0007.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL");
                intent.resolveActivity(getPackageManager());
                    startActivity(intent);
                    finish();
            }
        });



    }
}