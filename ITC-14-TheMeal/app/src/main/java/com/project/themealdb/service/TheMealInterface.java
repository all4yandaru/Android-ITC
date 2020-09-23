package com.project.themealdb.service;

import com.project.themealdb.model.Meal;
import com.project.themealdb.model.SearchMealResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMealInterface {

    @GET("search.php?s=")
    Call<SearchMealResponse> getMeals();

    @GET("search.php?")
    Call<SearchMealResponse> getMealsDetail(@Query("s") String search);
}
