package com.example.chooseyourcocktail;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.Call;

public interface CockTailAPI {

    @GET("posts")
    static Call<List> getPosts() {
        return null;
    }

}
