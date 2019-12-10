package com.iotbilisim.listviewornek;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
public class CustomActivity extends Activity {

    final List<Kisi> kisiler=new ArrayList<Kisi>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        kisiler.add(new Kisi("Ahmet Yılmaz", false));
        kisiler.add(new Kisi("Ayşe Küçük", true));
        kisiler.add(new Kisi("Fatma Bulgurcu", true));
        kisiler.add(new Kisi("İzzet Altınmeşe", false));
        kisiler.add(new Kisi("Melek Subaşı", true));
        kisiler.add(new Kisi("Selim Serdilli",false));
        kisiler.add(new Kisi("Halil İbrahim",false));

        final ListView listemiz = findViewById(R.id.listView1);
        OzelAdapter adaptorumuz=new OzelAdapter(CustomActivity.this, kisiler);
        listemiz.setAdapter(adaptorumuz);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                kisiler.get(position);

                String adsoyad= kisiler.get(position).getIsim();
                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(CustomActivity.this);

                diyalogOlusturucu.setMessage(adsoyad)
                        .setCancelable(false)
                        .setPositiveButton("Tamam",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        dialog.dismiss();
                                    }
                                });
                diyalogOlusturucu.create().show();
            }
        });

    }
}

