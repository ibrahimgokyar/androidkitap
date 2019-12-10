package com.iotbilisim.listviewornek;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private String[] ulkeler = {"Türkiye","Almanya","İsviçre","Fransa","İspanya","Suriye", "Venezuela"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listemiz= findViewById(R.id.liste);
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>(MainActivity.this, android.R
                .layout.simple_list_item_1,
                android.R.id.text1, ulkeler);
        listemiz.setAdapter(veriAdaptoru);


        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position,
                                    long id) {

                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(MainActivity.this);

                diyalogOlusturucu.setMessage(ulkeler[position])
                        .setCancelable(false)

                        .setPositiveButton("Tamam",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        dialog.dismiss();
                                    }
                                });

                diyalogOlusturucu.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                diyalogOlusturucu.create().show();


            }
        });


    }

}
