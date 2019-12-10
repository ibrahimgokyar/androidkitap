package com.opendart.retrofitsinemaornek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    MoviesAdapter mAdapter;
    Movies movies;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Movie movie = movies.getMovies().get(position);
            Intent i = new Intent(getApplicationContext(),MovieDetailActivity.class);
            i.putExtra("description", movie.getDescription());
            i.putExtra("background_image_original", movie.getImage());
            startActivity(i);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView =  findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface =
                ApiClient.getRetrofitInstance().create(ApiInterface.class);

        Call<MovieResponse> call = apiInterface.getLastMovies();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movies = response.body().getData();
                mAdapter = new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext());
                recyclerView.setAdapter(mAdapter);
                mAdapter.setOnItemClickListener(onItemClickListener);


            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }



}
