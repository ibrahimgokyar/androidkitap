package com.msb.sqliteornek;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<HashMap<String, String>> kitap_liste;
    String kitap_adlari[];
    int kitap_idler[];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clickButton = (Button) findViewById(R.id.btnEkle);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, KitapEkle.class);
                startActivity(i);
            }
        });
    }
    public void onResume()
    {
        super.onResume();
        Database db = new Database(getApplicationContext());
        kitap_liste = db.kitaplar();
        if(kitap_liste.size()==0){
            Toast.makeText(getApplicationContext(),
                    "Henüz Kitap Eklenmemi˛.\nYukar˝daki + Butonundan Ekleyiniz", Toast.LENGTH_LONG).show();
        }else{
            kitap_adlari = new String[kitap_liste.size()];
            kitap_idler = new int[kitap_liste.size()];
            for(int i=0;i<kitap_liste.size();i++){
                kitap_adlari[i] = kitap_liste.get(i).get("kitap_adi");
                kitap_idler[i] = Integer.parseInt(kitap_liste.get(i).get("id"));

            }
            lv = findViewById(R.id.list_view2);
            adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.kitap_adi, kitap_adlari);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                        long arg3) {
                    Intent intent = new Intent(getApplicationContext(), KitapDetay.class);
                    intent.putExtra("id", (int)kitap_idler[arg2]);
                    startActivity(intent);

                }
            });
        }

    }

}
