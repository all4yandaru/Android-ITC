package com.project.githubapi.service;

import com.project.githubapi.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//TODO 7: buat interface untuk pemanggilannya
public interface Githubinterface {

    //TODO 9: buat query nya
    @GET("users?") // users? itu diambil dari https://api.github.com/users?since=30
    Call<ArrayList<User>> getUsers(@Query("since") int random); // tipe data disesuaiin sama model yg dibuat, menit 21:52

    //TODO 20: buat get utk ambil data detailnya
    @GET("users/{username}")
    Call<User> getDetailUser(@Path("username") String username);
}
