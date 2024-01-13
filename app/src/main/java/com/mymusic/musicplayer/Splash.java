package com.mymusic.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Splash extends AppCompatActivity {

    ImageView imageView;
    Animation animation;
    private static int Screen=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView =findViewById(R.id.imageView01);
        animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        imageView.setAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences =getSharedPreferences("UData" , Context.MODE_PRIVATE);
                Boolean b = preferences.getBoolean("is_Done",false);

                if (b) {
                    Intent intent = new Intent(Splash.this, Muplay.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    uData();
                    Avtar();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Splash.this, Muplay.class);
                            startActivity(intent);
                            finish();
                        }
                    },500);
                }
            }
        },Screen);
    }

    public void uData(){
        Random rand = new Random();
        int number = rand.nextInt(1842) + 1;
        int nutr = rand.nextInt(14793921) + 1;
        int zsaf = rand.nextInt(1582) + 1;
        String mmcx = String.valueOf(number);
        String mgf =String.valueOf(nutr);
        String xdt =String.valueOf(zsaf);
        SharedPreferences preferences =getSharedPreferences("UData" , Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=preferences.edit();
        String setname ="User"+mmcx+"azf"+mgf;
        String setuname ="User@"+xdt;
        String setdebio ="Har Har Mahadev";

        edit.putString("Name",setname);
        edit.putString("UserName",setuname);
        edit.putString("Bio",setdebio);
        edit.putBoolean("is_Done",true);
        edit.apply();

    }
    public void Avtar(){
        List<imgitems> iitem = new ArrayList<imgitems>();
        iitem.add(new imgitems(R.drawable.avtar1));
        iitem.add(new imgitems(R.drawable.avtar2));
        iitem.add(new imgitems(R.drawable.avtar3));
        iitem.add(new imgitems(R.drawable.avtar4));
        iitem.add(new imgitems(R.drawable.avtar5));
        iitem.add(new imgitems(R.drawable.avtar6));
        iitem.add(new imgitems(R.drawable.avtar7));
        iitem.add(new imgitems(R.drawable.avtar8));
        iitem.add(new imgitems(R.drawable.avtar9));
        iitem.add(new imgitems(R.drawable.avtar10));
        iitem.add(new imgitems(R.drawable.avtar11));
        iitem.add(new imgitems(R.drawable.avtar12));
        iitem.add(new imgitems(R.drawable.profile_dp));

        String Setdefault ="12";
        SharedPreferences preferences = getSharedPreferences("Avtar", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=preferences.edit();
        ed.putString("ProfilePicture",Setdefault);
        ed.putBoolean("is_ok",true);
        ed.apply();
    }
}