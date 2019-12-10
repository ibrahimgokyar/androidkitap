package com.opendart.menuornek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Toastshow:
                Toast.makeText(getApplicationContext(), "Toast Göster Seçildi", Toast.LENGTH_LONG).show();
                return true;

            case R.id.progresshow:
                Toast.makeText(getApplicationContext(), "Progress Seçildi", Toast.LENGTH_LONG).show();
                return true;

            case R.id.donothing:
                Toast.makeText(getApplicationContext(), "do nothing seçildi", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
