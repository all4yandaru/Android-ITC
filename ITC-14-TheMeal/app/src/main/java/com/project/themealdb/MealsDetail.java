package com.project.themealdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.themealdb.model.Meal;
import com.project.themealdb.service.TheMealAPI;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MealsDetail extends AppCompatActivity {

    public static final String EXTRA_PARCEL = "extra_parcel";
    private Meal meal;

    ImageView ivImage;
    TextView tvMeal, tvCategory, tvInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_detail);

        if (getIntent() != null){
            meal = getIntent().getParcelableExtra(EXTRA_PARCEL);
        }

        ivImage = findViewById(R.id.iv_image);
        tvMeal = findViewById(R.id.tv_meal);
        tvCategory = findViewById(R.id.tv_category);
        tvInstructions = findViewById(R.id.tv_instructions);


        /*
        Gini doang juga udah bisa, ga perlu pake listener lagi
        Picasso.get().load(meal.getStrMealThumb()).into(ivImage);
        tvInstructions.setText(meal.getStrInstructions());
        tvMeal.setText(meal.getStrMeal());
        tvCategory.setText(meal.getStrCategory());*/

        TheMealAPI theMealAPI = new TheMealAPI();
        theMealAPI.getMealsDetail(detailListener, meal.getStrMeal());
    }

    ApiListener<Meal> detailListener = new ApiListener<Meal>() {
        @Override
        public void onSuccess(Meal meals) {
            Picasso.get().load(meals.getStrMealThumb()).into(ivImage);
            tvInstructions.setText(meals.getStrInstructions());
            tvMeal.setText(meals.getStrMeal());
            tvCategory.setText(meals.getStrCategory());
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ERROR Api", msg);
        }
    };

}