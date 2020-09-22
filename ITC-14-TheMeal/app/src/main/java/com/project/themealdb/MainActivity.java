package com.project.themealdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.project.themealdb.adapter.MealAdapter;
import com.project.themealdb.model.Meal;
import com.project.themealdb.service.TheMealAPI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTheMeal;
    private MealAdapter mealAdapter;
    private ArrayList<Meal> listMeal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealAdapter = new MealAdapter();
        rvTheMeal = findViewById(R.id.rv_themeal);
        rvTheMeal.setLayoutManager(new LinearLayoutManager(this));
        rvTheMeal.setHasFixedSize(true);
        rvTheMeal.setAdapter(mealAdapter);

        TheMealAPI theMealAPI = new TheMealAPI();
        theMealAPI.getAllMeals(apiListener);
    }

    ApiListener<ArrayList<Meal>> apiListener =new ApiListener<ArrayList<Meal>>() {
        @Override
        public void onSuccess(ArrayList<Meal> meals) {
            listMeal.addAll(meals);
            mealAdapter.setMeals(listMeal);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("EROR Api", msg);
        }
    };
}