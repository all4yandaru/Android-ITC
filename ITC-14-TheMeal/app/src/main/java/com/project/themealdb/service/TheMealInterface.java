package com.project.themealdb.service;

import com.project.themealdb.model.Meal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMealInterface {

    @GET("search.php?")
    Call<ArrayList<Meal>> getMeals(@Query("f") String letter);
}
