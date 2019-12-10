package com.iotbilisim.veritasima;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IkinciActivity extends AppCompatActivity {
    private TextView tvAd, tvSoyad = null;
    private String strAd, strSoyad = null;
    private Bundle extras = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);
        init();
    }

    private void init() {

        tvAd =  findViewById(R.id.txtAd);
        tvSoyad  =  findViewById(R.id.txtSoyad);
        extras = getIntent().getExtras();
        strAd = extras.getString("Ad");
        strSoyad   = extras.getString("Soyad");
        tvAd.setText(strAd);
        tvSoyad.setText(strSoyad);
    }
}

