package com.mymusic.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class Light extends AppCompatActivity {

    androidx.constraintlayout.widget.ConstraintLayout lcolor;
    private FlashlightUtil flashlightUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        lcolor =findViewById(R.id.lightcolor);
        flashlightUtil = new FlashlightUtil(this);

        if (!flashlightUtil.hasFlash()) {
            // The device doesn't have a flashlight
            Toast.makeText(this, "Your device doesn't have a flashlight.", Toast.LENGTH_SHORT).show();
            return;
        }

        color1();
        color2();
        color3();
        color4();
        color5();
        color6();
        color7();
        color8();
        color9();
        color10();
        color11();
        color12();
        color13();
        color14();
        color15();
        color16();
        color17();
        color18();
        color19();
        color20();
        color21();
        color22();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent intent =new Intent(Light.this,Eoption.class);
               startActivity(intent);
            }
        },11000);



    }

    public void color1(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.blue_A400);
                flashlightUtil.turnOnFlash();
            }
        },1);
    }

    public void color2(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.Darkpink);
                flashlightUtil.turnOffFlash();
            }
        },500);
    }

    public void color3(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.brown_400);
                flashlightUtil.turnOnFlash();
            }
        },1000);
    }
    public void color4(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.amber_A400);
                flashlightUtil.turnOffFlash();
            }
        },1500);
    }
    public void color5(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.cus);
                flashlightUtil.turnOnFlash();
            }
        },2000);
    }

    public void color6(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.blue_gray_400);
                flashlightUtil.turnOffFlash();
            }
        },2500);
    }
    public void color7(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.orange_A400);
                flashlightUtil.turnOnFlash();
            }
        },3000);
    }
    public void color8(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.deep_purple_A400);
                flashlightUtil.turnOffFlash();
            }
        },3500);
    }
    public void color9(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.light_blue_A400);
                flashlightUtil.turnOnFlash();
            }
        },4000);
    }
    public void color10(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.purple_A400);
                flashlightUtil.turnOffFlash();
            }
        },4500);
    }
    public void color11(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.teal_200);
                flashlightUtil.turnOnFlash();
            }
        },5000);
    }
    public void color12(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.light);
                flashlightUtil.turnOffFlash();
            }
        },5500);
    }
    public void color13(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.cus);
                flashlightUtil.turnOnFlash();
            }
        },6000);
    }
    public void color14(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.amber_A400);
                flashlightUtil.turnOffFlash();
            }
        },6500);
    }
    public void color15(){new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.deep_orange_A400);
                flashlightUtil.turnOnFlash();
            }
        },7000);
    }
    public void color16(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.blue_gray_400);
                flashlightUtil.turnOffFlash();
            }
        },7500);
    }
    public void color17(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.Darkpink);
                flashlightUtil.turnOnFlash();
            }
        },8000);
    }
    public void color18(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.teal_200);
                flashlightUtil.turnOffFlash();
            }
        },8500);
    }
    public void color19(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.red_A400);
                flashlightUtil.turnOnFlash();
            }
        },9000);
    }
    public void color20(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.pink_A400);
                flashlightUtil.turnOffFlash();
            }
        },9500);
    }
    public void color21(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.blue_A400);
                flashlightUtil.turnOnFlash();
            }
        },10000);
    }

    public void color22(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lcolor.setBackgroundResource(R.color.Darkpink);
                flashlightUtil.turnOffFlash();
            }
        },10500);
    }



}
