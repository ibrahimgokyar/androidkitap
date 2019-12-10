package com.msb.sqliteornek;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class KitapEkle extends Activity {
	Button b1;
	EditText e1,e2,e3,e4;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kitapekle);
		b1 = findViewById(R.id.button1);
		e1 = findViewById(R.id.editText1);
		e2 = findViewById(R.id.editText2);
		e3 = findViewById(R.id.editText3);
		e4 = findViewById(R.id.editText4);

		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String adi,yazari,yili,fiyati;
				adi = e1.getText().toString();
				yazari = e2.getText().toString();
				yili = e3.getText().toString();
				fiyati = e4.getText().toString();
				if(adi.matches("") || yazari.matches("") || yili.matches("")
						|| fiyati.matches("")  ){
				    Toast.makeText(getApplicationContext(), "Tüm Bilgileri Eksiksiz Doldurunuz", Toast.LENGTH_LONG).show();
				}else{
					Database db = new Database(getApplicationContext());
					db.kitapEkle(adi, yazari, yili, fiyati);//kitap ekledik
					db.close();
				    Toast.makeText(getApplicationContext(), "Kitabınız Başarıyla Eklendi.", Toast.LENGTH_LONG).show();
				    e1.setText("");
				    e2.setText("");
				    e3.setText("");
				    e4.setText("");
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}
			}
		});
	}



}
