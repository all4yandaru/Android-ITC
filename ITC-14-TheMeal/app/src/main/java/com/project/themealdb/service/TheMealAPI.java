package com.project.themealdb.service;

import com.project.themealdb.ApiListener;
import com.project.themealdb.model.Meal;
import com.project.themealdb.model.SearchMealResponse;

import java.util.ArrayList;

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
        getAPI().getMeals().enqueue(new Callback<SearchMealResponse>() {
            @Override
            public void onResponse(Call<SearchMealResponse> call, Response<SearchMealResponse> response) {
                SearchMealResponse listMeal = response.body();
                if (listMeal != null){
                    listener.onSuccess(listMeal.getMeals());
                }
            }

            @Override
            public void onFailure(Call<SearchMealResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getMealsDetail(final ApiListener<Meal> listener, String detail){
        String detailMeal = detail;
        getAPI().getMealsDetail(detailMeal).enqueue(new Callback<SearchMealResponse>() {
            @Override
            public void onResponse(Call<SearchMealResponse> call, Response<SearchMealResponse> response) {
                SearchMealResponse mealDetail = response.body();
                if (mealDetail != null){
                    Meal detail = mealDetail.getMeals().get(0);
                    listener.onSuccess(detail);
                }
            }

            @Override
            public void onFailure(Call<SearchMealResponse> call, Throwable t) {

            }
        });
    }
}
