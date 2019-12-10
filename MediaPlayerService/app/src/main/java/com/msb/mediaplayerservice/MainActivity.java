package com.msb.mediaplayerservice;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnPlay;
    Button btnStop;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControlView();
        setClickForView();
    }
    private void getControlView() {
        btnPlay = findViewById(R.id.btnPlay);
        btnStop =  findViewById(R.id.btnStop);
    }
    private void setClickForView() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MediaService.class isimli servisimizi seçtik.
                intent = new Intent(MainActivity.this,MediaService.class);
                //bu metot servisin onStartCommand() metodunu başlatır.
                startService(intent);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,MediaService.class);
                //bu metot servisin onDestroy() metodunu başlatır.
                stopService(intent);
            }
        });
    }
}
