package com.mymusic.musicplayer;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class Homepage extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<AudioModel>songslist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        recyclerView =findViewById(R.id.recycler);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkPermission() == false){
                requestPermission();
                otherequestPermission();
                return;
            }
        }

        String[] projection ={
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION

        };

        String selection = MediaStore.Audio.Media.IS_MUSIC +"!= 0";

        Cursor cursor =getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
        while (cursor.moveToNext()){
            AudioModel songData = new AudioModel(cursor.getString(1),cursor.getString(0),cursor.getString(2));
            if(new File(songData.getPath()).exists())
                songslist.add(songData);

        }
        if(songslist.size()==0){
            recyclerView.setVisibility(View.VISIBLE);

        }else{
            //recyclerview
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new MusicListAdapter(songslist,getApplicationContext()));
        }

    }



    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    boolean checkPermission() {



        int resultReadStorage = ContextCompat.checkSelfPermission(Homepage.this, Manifest.permission.READ_MEDIA_AUDIO);
        int resultReadAudio = ContextCompat.checkSelfPermission(Homepage.this, Manifest.permission.READ_MEDIA_AUDIO);

        if (resultReadStorage == PackageManager.PERMISSION_GRANTED && resultReadAudio == PackageManager.PERMISSION_GRANTED) {
            return true; // Both permissions granted
        } else if (resultReadStorage == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "READ_MEDIA_AUDIO Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (resultReadAudio == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "READ_EXTERNAL_STORAGE Permission Denied", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permissions Denied", Toast.LENGTH_SHORT).show();
        }
        return false; // Permission(s) denied
    }

    public void requestPermission(){


        if(ActivityCompat.shouldShowRequestPermissionRationale(Homepage.this,Manifest.permission.READ_MEDIA_AUDIO)){
            Toast.makeText(Homepage.this,"READ PERMISSION IS REQUIRED,PLEASE ALLOW FROM SETTINGS",Toast.LENGTH_SHORT).show();
        }else
            ActivityCompat.requestPermissions(Homepage.this,new String[]{Manifest.permission.READ_MEDIA_AUDIO},123);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(recyclerView!=null){
            recyclerView.setAdapter(new MusicListAdapter(songslist,getApplicationContext()));
        }
    }
    @SuppressLint("InlinedApi")
    public void otherequestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(Homepage.this,Manifest.permission.READ_MEDIA_AUDIO)){
            Toast.makeText(Homepage.this,"READ PERMISSION IS REQUIRED,PLEASE ALLOW FROM SETTINGS",Toast.LENGTH_SHORT).show();
        }else
            ActivityCompat.requestPermissions(Homepage.this,new String[]{Manifest.permission.READ_MEDIA_AUDIO},13);
    }

}