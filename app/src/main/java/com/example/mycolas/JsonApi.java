package com.example.mycolas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


//Interfaz de Java para para la API REST
public interface JsonApi {

    @GET("posts") // Especificamos la ruta
    Call<List<Posts>> getPosts();

}
