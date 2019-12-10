package com.opendart.retrofitsinemaornek;



import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;



public class MovieResponse {

    @SerializedName("data")
    private Movies data;

    public Movies getData() {
        return data;
    }

    public void setData(Movies data) {
        this.data = data;
    }
}