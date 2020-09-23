package com.project.themealdb.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.themealdb.MealsDetail;
import com.project.themealdb.R;
import com.project.themealdb.model.Meal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder> {
    private ArrayList<Meal> listMeal = new ArrayList<>();
    public void setMeals(ArrayList<Meal> listMeal){
        this.listMeal.clear();
        this.listMeal.addAll(listMeal);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listMeal.get(position));
    }

    @Override
    public int getItemCount() {
        return listMeal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvMeal, tvCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvMeal = itemView.findViewById(R.id.tv_meal);
            tvCategory = itemView.findViewById(R.id.tv_category);

        }

        public void bind(Meal meal){
            tvMeal.setText(meal.getStrMeal());
            tvCategory.setText(meal.getStrCategory());
            Picasso.get().load(meal.getStrMealThumb()).into(ivImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(itemView.getContext(), MealsDetail.class);
                    i.putExtra(MealsDetail.EXTRA_PARCEL, meal);
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }
}
