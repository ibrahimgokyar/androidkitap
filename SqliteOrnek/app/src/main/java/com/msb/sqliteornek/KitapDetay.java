package com.msb.sqliteornek;

import java.util.HashMap;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KitapDetay extends Activity {
	Button b1,b2;
	TextView t1,t2,t3,t4;
	int id;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kitapdetay);
		b1 = findViewById(R.id.button1);
		b2 = findViewById(R.id.button2);
		t1 = findViewById(R.id.adi);
		t2 = findViewById(R.id.yazari);
		t3 = findViewById(R.id.yili);
		t4 = findViewById(R.id.fiyati);

		Intent intent=getIntent();
		id = intent.getIntExtra("id", 0);
		Database db = new Database(getApplicationContext());
		HashMap<String, String> map = db.kitapDetay(id);
		
		t1.setText(map.get("kitap_adi"));
		t2.setText(map.get("yazar").toString());
		t3.setText(map.get("yil").toString());
		t4.setText(map.get("fiyat").toString());
		b1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				 Intent intent = new Intent(getApplicationContext(), KitapDuzenle.class);
				 intent.putExtra("id", (int)id);
                 startActivity(intent);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(KitapDetay.this);
    	        alertDialog.setTitle("Uyarı");
    	        alertDialog.setMessage("Kitap Silinsin mi?");
    	        alertDialog.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
    	            public void onClick(DialogInterface dialog,int which) {
    	            	Database db = new Database(getApplicationContext());
    	            	db.kitapSil(id);
    	            	Toast.makeText(getApplicationContext(), "Kitap Başarıyla Silindi", Toast.LENGTH_LONG).show();
    	            	Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    	                startActivity(intent);
    	                finish();
    	                
    	            }
    	        });
    	        alertDialog.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
    	            public void onClick(DialogInterface dialog,int which) {
    	            	
    	            }
    	        });
    	        alertDialog.show();     
				
			}
		});
		
		
	}
}
