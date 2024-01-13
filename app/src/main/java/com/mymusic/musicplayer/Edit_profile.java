package com.mymusic.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Edit_profile extends AppCompatActivity {

    EditText name,username,bio;
    Button saved;
    CardView cimg1, cimg2, cimg3, cimg4, cimg5, cimg6, cimg7, cimg8, cimg9, cimg10, cimg11, cimg12;
    Context context;
    ImageView img001 ,img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        name =findViewById(R.id.Name);
        username =findViewById(R.id.Username);
        bio =findViewById(R.id.Bio);
        saved =findViewById(R.id.profilebtn);
        img001 =findViewById(R.id.editimg);
        img1 =findViewById(R.id.editimg01);
        img2 =findViewById(R.id.editimg02);
        img3 =findViewById(R.id.editimg03);
        img4 =findViewById(R.id.editimg04);
        img5 =findViewById(R.id.editimg05);
        img6 =findViewById(R.id.editimg06);
        img7 =findViewById(R.id.editimg07);
        img8 =findViewById(R.id.editimg08);
        img9 =findViewById(R.id.editimg09);
        img10 =findViewById(R.id.editimg010);
        img11 =findViewById(R.id.editimg011);
        img12 =findViewById(R.id.editimg012);
        cimg1 =findViewById(R.id.cceditimg01);
        cimg2 =findViewById(R.id.cceditimg02);
        cimg3 =findViewById(R.id.cceditimg03);
        cimg4 =findViewById(R.id.cceditimg04);
        cimg5 =findViewById(R.id.cceditimg05);
        cimg6 =findViewById(R.id.cceditimg06);
        cimg7 =findViewById(R.id.cceditimg07);
        cimg8 =findViewById(R.id.cceditimg08);
        cimg9 =findViewById(R.id.cceditimg09);
        cimg10 =findViewById(R.id.cceditimg010);
        cimg11 =findViewById(R.id.cceditimg011);
        cimg12 =findViewById(R.id.cceditimg012);
        Avtar();

        img1.setVisibility(View.GONE);
        img2.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
        img4.setVisibility(View.GONE);
        img5.setVisibility(View.GONE);
        img6.setVisibility(View.GONE);
        img7.setVisibility(View.GONE);
        img8.setVisibility(View.GONE);
        img9.setVisibility(View.GONE);
        img10.setVisibility(View.GONE);
        img11.setVisibility(View.GONE);
        img12.setVisibility(View.GONE);
        cimg1.setVisibility(View.GONE);
        cimg2.setVisibility(View.GONE);
        cimg3.setVisibility(View.GONE);
        cimg4.setVisibility(View.GONE);
        cimg5.setVisibility(View.GONE);
        cimg6.setVisibility(View.GONE);
        cimg7.setVisibility(View.GONE);
        cimg8.setVisibility(View.GONE);
        cimg9.setVisibility(View.GONE);
        cimg10.setVisibility(View.GONE);
        cimg11.setVisibility(View.GONE);
        cimg12.setVisibility(View.GONE);

        img001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.VISIBLE);
                img7.setVisibility(View.VISIBLE);
                img8.setVisibility(View.VISIBLE);
                img9.setVisibility(View.VISIBLE);
                img10.setVisibility(View.VISIBLE);
                img11.setVisibility(View.VISIBLE);
                img12.setVisibility(View.VISIBLE);
                cimg1.setVisibility(View.VISIBLE);
                cimg2.setVisibility(View.VISIBLE);
                cimg3.setVisibility(View.VISIBLE);
                cimg4.setVisibility(View.VISIBLE);
                cimg5.setVisibility(View.VISIBLE);
                cimg6.setVisibility(View.VISIBLE);
                cimg7.setVisibility(View.VISIBLE);
                cimg8.setVisibility(View.VISIBLE);
                cimg9.setVisibility(View.VISIBLE);
                cimg10.setVisibility(View.VISIBLE);
                cimg11.setVisibility(View.VISIBLE);
                cimg12.setVisibility(View.VISIBLE);


            }
        });




          img1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String img1007= "0";
                  SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                  SharedPreferences.Editor ed=preferences.edit();
                  ed.putString("ProfilePicture",img1007);
                  ed.putBoolean("is_ok",true);
                  ed.apply();
                  Intent intent = getIntent();
                  finish();
                  startActivity(intent);

              }
          });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "1";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "2";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "3";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "4";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "5";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "6";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "7";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "8";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "9";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "10";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img1007= "11";
                SharedPreferences preferences =getSharedPreferences("Avtar", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("ProfilePicture",img1007);
                ed.putBoolean("is_ok",true);
                ed.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });


        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences =getSharedPreferences("UData" , Context.MODE_PRIVATE);
                SharedPreferences.Editor edit=preferences.edit();
                edit.putString("Name",(String) name.getText().toString());
                edit.putString("UserName",(String) username.getText().toString());
                edit.putString("Bio",(String) bio.getText().toString());
                edit.putBoolean("is_Done",true);
                edit.apply();
                Intent intent =new Intent(Edit_profile.this,Musicpage.class);
                startActivity(intent);

            }
        });
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


            SharedPreferences preferences = getSharedPreferences("Avtar", Context.MODE_PRIVATE);
            String UIMG = preferences.getString("ProfilePicture", null);
            img001.setImageResource(iitem.get(Integer.parseInt(UIMG)).image);


    }
}