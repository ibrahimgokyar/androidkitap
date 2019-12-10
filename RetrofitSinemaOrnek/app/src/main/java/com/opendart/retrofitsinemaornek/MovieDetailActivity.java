package com.opendart.retrofitsinemaornek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {


    private Bundle extras = null;
    private TextView detailText= null;
    private ImageView detailImage= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        detailText =  findViewById(R.id.detailText);
        detailImage =  findViewById(R.id.detailImage);

        extras = getIntent().getExtras();
        detailText.setText(extras.getString("description"));

        Picasso.with(getApplicationContext()).load(extras.getString("background_image_original")).into(detailImage);

    }
}
