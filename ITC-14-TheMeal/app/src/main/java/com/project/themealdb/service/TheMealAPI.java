package com.project.themealdb.service;

import com.project.themealdb.ApiListener;
import com.project.themealdb.model.Meal;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TheMealAPI {

    private Retrofit retrofit = null;
    private static final String URL_BASE = "https://www.themealdb.com/api/json/v1/1/";

    public TheMealInterface getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TheMealInterface.class);
    }

    public void getAllMeals(final ApiListener<ArrayList<Meal>> listener){
        String letter = "b";
        getAPI().getMeals(letter).enqueue(new Callback<ArrayList<Meal>>() {
            @Override
            public void onResponse(Call<ArrayList<Meal>> call, Response<ArrayList<Meal>> response) {
                ArrayList<Meal> listMeal = response.body();
                if (listMeal != null){
                    listener.onSuccess(listMeal);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Meal>> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
