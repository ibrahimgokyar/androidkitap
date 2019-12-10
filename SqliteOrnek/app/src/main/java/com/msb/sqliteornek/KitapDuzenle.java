package com.msb.sqliteornek;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class KitapDuzenle extends Activity {
	Button b1;
	EditText e1,e2,e3,e4;
	int id;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kitapduzenle);
		b1 = findViewById(R.id.button1);
		e1 = findViewById(R.id.editText1);
		e2 = findViewById(R.id.editText2);
		e3 = findViewById(R.id.editText3);
		e4 = findViewById(R.id.editText4);
		Intent intent=getIntent();
		id = intent.getIntExtra("id", 0);
		Database db = new Database(getApplicationContext());
		HashMap<String, String> map = db.kitapDetay(id);
		
		e1.setText(map.get("kitap_adi"));
		e2.setText(map.get("yazar").toString());
		e3.setText(map.get("yil").toString());
		e4.setText(map.get("fiyat").toString());
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String adi,yazari,yili,fiyati;
				adi = e1.getText().toString();
				yazari = e2.getText().toString();
				yili = e3.getText().toString();
				fiyati = e4.getText().toString();
				if(adi.matches("") || yazari.matches("") || yili.matches("") ||
						fiyati.matches("")  ){
				    Toast.makeText(getApplicationContext(), "Tüm Bilgileri Eksiksiz Doldurunuz", Toast.LENGTH_LONG).show();
				}else{
					Database db = new Database(getApplicationContext());
					db.kitapDuzenle(adi, yazari, yili, fiyati,id);
					db.close();
				    Toast.makeText(getApplicationContext(), "Kitabınız başarışla Düzenlendi.", Toast.LENGTH_LONG).show();
				    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
	                startActivity(intent);
	                finish();
				}
				
				
			}
		});
		
		
	}



}
