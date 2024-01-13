package com.mymusic.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class Profile extends AppCompatActivity {

    TextView btn ,uname,username,bio;

    Context context;


    ImageView profilepic;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        uname =findViewById(R.id.userid);
        username =findViewById(R.id.uname);
        bio =findViewById(R.id.ubio);
        btn=findViewById(R.id.EditDatabtn);
        profilepic =findViewById(R.id.profileid);

        Avtar();



       SharedPreferences preferences =getSharedPreferences("UData", Context.MODE_PRIVATE);
        String UNAME =preferences.getString("Name",null);
        String USERNAME =preferences.getString("UserName",null);
        String BIO =preferences.getString("Bio",null);



        uname.setText(UNAME);
        username.setText(USERNAME);
        bio.setText(BIO);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Profile.this,Edit_profile.class);
                startActivity(intent);
            }
        });
    }

    public void Avtar(){

            List<imgitems> iitems = new ArrayList<imgitems>();
            iitems.add(new imgitems(R.drawable.avtar1));
            iitems.add(new imgitems(R.drawable.avtar2));
            iitems.add(new imgitems(R.drawable.avtar3));
            iitems.add(new imgitems(R.drawable.avtar4));
            iitems.add(new imgitems(R.drawable.avtar5));
            iitems.add(new imgitems(R.drawable.avtar6));
            iitems.add(new imgitems(R.drawable.avtar7));
            iitems.add(new imgitems(R.drawable.avtar8));
            iitems.add(new imgitems(R.drawable.avtar9));
            iitems.add(new imgitems(R.drawable.avtar10));
            iitems.add(new imgitems(R.drawable.avtar11));
            iitems.add(new imgitems(R.drawable.avtar12));
            iitems.add(new imgitems(R.drawable.profile_dp));


            SharedPreferences preferences = getSharedPreferences("Avtar", Context.MODE_PRIVATE);
            String UIMG = preferences.getString("ProfilePicture", null);
            profilepic.setImageResource(iitems.get(Integer.parseInt(UIMG)).image);


    }

}