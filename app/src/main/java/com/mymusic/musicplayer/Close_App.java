package com.mymusic.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Close_App extends AppCompatActivity {

    private int minute;
    private int hour;
    private TextView countdownText;
    private Button setTimeButton, startTimerButton;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close_app);
        countdownText = findViewById(R.id.countdown);
        setTimeButton = findViewById(R.id.settime);
        startTimerButton = findViewById(R.id.timer);

        setTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
    }

    private void showTimePickerDialog() {
        final Calendar currentTime = Calendar.getInstance();
        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(Close_App.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Calculate total time in milliseconds
                        long totalTimeInMillis = (hourOfDay * 60 * 60 * 1000) + (minute * 60 * 1000);
                        countdownText.setText("Time set: " + hourOfDay + ":" + minute);
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }

    private void startTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // Retrieve time set by the user
        // For demonstration purposes, let's assume user sets 10 minutes
        long totalTimeInMillis = minute * 60 * 1000; // 10 minutes in milliseconds

        countDownTimer = new CountDownTimer(totalTimeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                long minutes = secondsRemaining / 60;
                long seconds = secondsRemaining % 60;
                countdownText.setText("Time remaining: " + minutes + " minutes " + seconds + " seconds");

            }

            @Override
            public void onFinish() {
                countdownText.setText("Timer Finished");
                // Close the app
                onDestroy();
                Close_App.this.finish();
                System.exit(0);

            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}