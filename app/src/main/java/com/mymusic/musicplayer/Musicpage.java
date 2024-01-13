package com.mymusic.musicplayer;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.VectorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spanned;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class Musicpage extends AppCompatActivity {

    androidx.constraintlayout.widget.ConstraintLayout next;

    Toolbar toolbar;

    ImageView icon;

    int[] imagelist={R.drawable.mbac1,R.drawable.mbac2,R.drawable.tur1,R.drawable.tur2,R.drawable.tur3,R.drawable.tur4,R.drawable.tur5,};
    SwipeListener swipeListener;
    int imagecount;

    TextView edbutton,title, titleTv,currentTimeTv,totalTimeTv;

    ArrayList<AudioModel>songslist;

    AudioModel currentsong;
    MediaPlayer mediaPlayer = MyMediaPlayer.getInstance();

    int x=0;

    SeekBar seekBar;
    ImageView pausePlay , nextBtn , profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicpage);
        edbutton =findViewById(R.id.pedto);
        title =findViewById(R.id.text2);
        titleTv =findViewById(R.id.text1);
        next=findViewById(R.id.swip1);
        swipeListener = new SwipeListener(next);
        currentTimeTv = findViewById(R.id.current_time);
        totalTimeTv = findViewById(R.id.total_time);
        seekBar = findViewById(R.id.seek_bar);
        pausePlay = findViewById(R.id.pause_play);
        profile = findViewById(R.id.btn3);
        nextBtn = findViewById(R.id.btn2);
        icon =findViewById(R.id.proicon);


        Avtar();
        initMediaPlayer();

        edbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Musicpage.this,Eoption.class);
                startActivity(intent);
            }
        });


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Musicpage.this,Profile.class);
                startActivity(intent);
            }
        });




        titleTv.setSelected(true);
        title.setSelected(true);
        songslist =(ArrayList<AudioModel>) getIntent().getSerializableExtra("LIST");

        setResourcesWithMusic();

        Musicpage.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer!=null){
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    currentTimeTv.setText(convertToMMSS(mediaPlayer.getCurrentPosition()+""));
                    if(mediaPlayer.isPlaying()){
                        pausePlay.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);

                    }else{
                        pausePlay.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);

                    }

                }
                new Handler().postDelayed(this,100);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mediaPlayer!=null && fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }

    public void setResourcesWithMusic(){
        currentsong =songslist.get(MyMediaPlayer.currentIndex);
        titleTv.setText(currentsong.getTitle());
        title.setText(currentsong.getTitle());
        totalTimeTv.setText(convertToMMSS(currentsong.getDuration()));
        pausePlay.setOnClickListener(v-> pausePlay());
        playMusic();
        SharedPreferences preferences =getSharedPreferences("Play_Song", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=preferences.edit();;
        ed.putString("Music_Name",currentsong.getTitle());
        ed.putBoolean("is_Final",true);
        ed.apply();
    }
    private void playMusic(){  mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(currentsong.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            seekBar.setProgress(0);
            seekBar.setMax(mediaPlayer.getDuration());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void initMediaPlayer() {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                try {
                    imagecount++;
                    imagecount=imagecount % imagelist.length;
                    next.setBackground(ContextCompat.getDrawable(getApplicationContext(),imagelist[imagecount]));
                    SharedPreferences preferences =getSharedPreferences("Play_Song", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed=preferences.edit();
                    ed.putInt("Music_Image",imagecount);
                    ed.putBoolean("is_Final",true);
                    ed.apply();
                    playNextSong();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            imagecount++;
            imagecount=imagecount % imagelist.length;
            next.setBackground(ContextCompat.getDrawable(getApplicationContext(),imagelist[imagecount]));
            SharedPreferences preferences =getSharedPreferences("Play_Song", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed=preferences.edit();
            ed.putInt("Music_Image",imagecount);
            ed.putBoolean("is_Final",true);
            ed.apply();
            playNextSong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playNextSong(){

        if(MyMediaPlayer.currentIndex== songslist.size()-1)
            return;
        MyMediaPlayer.currentIndex +=1;
        mediaPlayer.reset();
        setResourcesWithMusic();

    }

    private void playPreviousSong(){
        if(MyMediaPlayer.currentIndex== 0)
            return;
        MyMediaPlayer.currentIndex -=1;
        mediaPlayer.reset();
        setResourcesWithMusic();
    }

    private void pausePlay(){
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }

    public static String convertToMMSS(String duration){
        Long millis = Long.parseLong(duration);
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
    }

    private  class SwipeListener implements View.OnTouchListener{
        GestureDetector gestureDetector;

        SwipeListener(View view){
            int THRESHOLD = 100;
            int VELOCITY_THRESHOLD = 100;

            GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onDown(MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//                    return super.onFling(e1, e2, velocityX, velocityY);
                    float xdiff = e2.getX() - e1.getX();
                    float ydiff = e2.getY() - e1.getY();

                    try {
                        //check condition
                        if(Math.abs(xdiff)> Math.abs(ydiff)){

                            if (Math.abs(xdiff) > THRESHOLD
                                    &&Math.abs(velocityX) >VELOCITY_THRESHOLD){

                                if (xdiff > 0){

                                    //swipe left
//                                    Toast.makeText(Musicpage.this, "left swip", Toast.LENGTH_SHORT).show();

                                }else {

                                    //swipe right
//                                    Toast.makeText(Musicpage.this, "right swip", Toast.LENGTH_SHORT).show();
                                }
                                return true;
                            }
                        }
                        else {
                            if (Math.abs(ydiff) > THRESHOLD
                                    &&Math.abs(velocityY) >VELOCITY_THRESHOLD){
                                if (ydiff > 0){
                                    imagecount--;
                                    imagecount=imagecount % imagelist.length;

                                    next.setBackground(ContextCompat.getDrawable(getApplicationContext(),imagelist[imagecount]));
                                    //Swipe up
                                    playPreviousSong();
                                    SharedPreferences preferences =getSharedPreferences("Play_Song", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor ed=preferences.edit();
                                    ed.putInt("Music_Image",imagecount);
                                    ed.putBoolean("is_Final",true);
                                    ed.apply();


                                }else {
                                    imagecount++;
                                    imagecount=imagecount % imagelist.length;
                                    next.setBackground(ContextCompat.getDrawable(getApplicationContext(),imagelist[imagecount]));
                                    //Swipe down
                                    playNextSong();
                                    SharedPreferences preferences =getSharedPreferences("Play_Song", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor ed=preferences.edit();
                                    ed.putInt("Music_Image",imagecount);
                                    ed.putBoolean("is_Final",true);
                                    ed.apply();
                                }
                                return true;

                            }

                        }

                    }catch (Exception e){
                        e.printStackTrace();

                    }
                    return false;
                }
            };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);

        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu1,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id =item.getItemId();
//
//        if (id==R.id.nav_account){
//            Intent intent =new Intent(Musicpage.this ,Homepage.class);
//            startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }


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
            icon.setImageResource(iitems.get(Integer.parseInt(UIMG)).image);

    }



}