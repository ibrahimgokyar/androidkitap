package com.msb.sesiyaziyacevirme;

import android.os.Bundle;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends Activity {

    public ImageButton voice_button;
    public EditText multiline_txt;
    public Button send_bttn;
    public Intent intent;
    public static final int request_code_voice = 1;
    public SpeechRecognizer recognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voice_button = findViewById(R.id.voice_button);
        multiline_txt = findViewById(R.id.voice_txt);
        send_bttn = findViewById(R.id.bttn_send);

        multiline_txt.setEnabled(false);

        voice_button.setOnClickListener(new OnClickListener() { // image button a tıklama olayı
            @Override
            public void onClick(View v) {

                intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                // intent i oluşturduk sesi tanıyabilmesi için
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

                try{
                    startActivityForResult(intent, request_code_voice);
                    // activityi başlattık belirlediğimiz sabit değer ile birlikte
                }catch(ActivityNotFoundException e)
                {
                    // activity bulunamadı zaman hatayı göstermek için alert dialog kullandım
                    e.printStackTrace();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Telefonunuz bu sistemi desteklemiyor!!!")
                            .setTitle("Milli Savunma Bakanlığı")
                            .setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }


            }
        });

        send_bttn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Paylas();

            }
        });
    }
    protected void Paylas() {
        String txt = multiline_txt.getText().toString();

        if(txt.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Boş paylaşım yapılamaz!! Lütfen Speech to " +
                    "Text kullanın", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent share_intent = new Intent(android.content.Intent.ACTION_SEND); // intenti
            // oluşturuyoruz
            share_intent.setType("text/plain");
            share_intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Ses Örnek");        //
            // mesaj konusu olarak, Mobilhanem ÷rnek yazd˝k
            share_intent.putExtra(android.content.Intent.EXTRA_TEXT, multiline_txt.getText().toString()); // mesaj iÁerii olarak, sˆylediimiz sˆz gˆnderilecek
            startActivity(Intent.createChooser(share_intent, "Paylaşmak için birini seçiniz"));
            // paylaşmak istediğimiz platformu seçiyoruz
        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case request_code_voice: {

                if (resultCode == RESULT_OK && data != null)
                {
                    // intent boş olmadığında ve sonuç tamam olduğu anda konu˛may˝ al˝p listenin
                    // iÁine att˝k
                    ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    multiline_txt.setText(speech.get(0));
                }
                break;
            }

        }
    }

}
