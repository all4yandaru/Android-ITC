package com.project.githubapi.service;

import com.project.githubapi.ApiListener;
import com.project.githubapi.model.User;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//TODO 6: buat GithubAPI buat inisialisasi API
public class GithubApi {

    //TODO 8: buat codingannya untuk insisialisasi interface nya
    private Retrofit retrofit = null;

    private static final String URL_BASE = "https://api.github.com/";

    public Githubinterface getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Githubinterface.class);
    }

    //TODO 11: buat untuk ngambil usernya
    public void getAllUsers(final ApiListener<ArrayList<User>> listener){
        int random = new Random().nextInt(10000);
        getAPI().getUsers(random).enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                ArrayList<User> listUser = response.body();

                if (listUser != null){
                    listener.onSuccess(listUser);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    //TODO 21: buat void utk ambil detail user
    public void getDetailUser(final ApiListener<User> listener, String username){
        getAPI().getDetailUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null){
                    listener.onSuccess(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
