package com.iotbilisim.veritasima;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etAd, etSoyad = null;
    private String strAd, strSoyad = null;
    private Button btnSubmit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        etAd =  findViewById(R.id.etAd);
        etSoyad =  findViewById(R.id.etSoyad);
        btnSubmit = findViewById(R.id.buttonKaydet);
        btnSubmit.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                clickedSubmit();
            }
        });


    }

    private void clickedSubmit() {
        /** Formdan verileri alalim */
        strAd = etAd.getText().toString().trim();
        strSoyad = etSoyad.getText().toString().trim();
        try
        {
            Bundle extras = new Bundle();
            extras.putString("Ad", strAd);
            extras.putString("Soyad", strSoyad);
            Intent intent = new Intent();
            intent.putExtras(extras);
            intent.setClass(MainActivity.this, IkinciActivity.class);
            startActivity(intent);

            //Intent intent2 = new Intent(MainActivity.this,IkinciActivity.class);
            // startActivity(intent2);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}


