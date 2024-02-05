package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   private Chronometer chronometer;
   private long pauseoffset;
   private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer=findViewById(R.id.chronometer);
    }
    public void OnStart(View view){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime()-pauseoffset);
        chronometer.start();
        running=true;
    }
    }
    public  void OnStop(View view) {
        if (running) {
            chronometer.stop();
            pauseoffset=SystemClock.elapsedRealtime()-chronometer.getBase();
            running = false;
        }
    }
    public void OnReset(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset=0;

    }
}