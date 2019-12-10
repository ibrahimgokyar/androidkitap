package com.msb.fragmentornek;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
/*implements Transfering  eki ile Transfering isimli arayüzü uygulamış olduk.
Bu işlemden sonra sistem dataTransfer isimli metodu eklemenizi ister.*/
public class MainActivity extends Activity implements Transfering {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Öncelikle Fragment2 bileşenine erişim sağladık. Bu bileşen içinde bulunan
    //setTextView metodu ile TextView etiketine ekleyeceğimiz veriyi iletmiş olduk.
    @Override
    public void dataTransfer(String text) {
        FragmentManager manager = getFragmentManager();
        Fragment2 fragment2 =  (Fragment2) manager.findFragmentById(R.id.fragment2);
        fragment2.setTextView(text);
    }
}
