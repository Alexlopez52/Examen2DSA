package com.example.examen2dsa;

import com.example.examen2dsa.models.Museums;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseumsAPI {

    //GET the list of Museums
    @GET("dataset/museus/format/json/pag-ini/1/pag-fi/5")
    Call<Museums> getMuseums();
    //GET the list of Museums
    @GET("dataset/museus/format/json/pag-ini/1/pag-fi/5")
    Call<Museums> getDescripcion();
}
