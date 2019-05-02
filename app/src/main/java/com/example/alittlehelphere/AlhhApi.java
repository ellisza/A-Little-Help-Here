package com.example.alittlehelphere;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlhhApi {

    @GET("getHelps")
    Call<List<Help>> getHelps();
}
