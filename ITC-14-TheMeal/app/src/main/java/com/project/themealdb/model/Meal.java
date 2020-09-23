package com.project.themealdb.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Meal implements Parcelable {
    private String strMeal;
    private String strCategory;
    private  String strMealThumb;

    private String strInstructions;

    protected Meal(Parcel in) {
        strMeal = in.readString();
        strCategory = in.readString();
        strMealThumb = in.readString();
        strInstructions = in.readString();
    }

    public static final Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel in) {
            return new Meal(in);
        }

        @Override
        public Meal[] newArray(int size) {
            return new Meal[size];
        }
    };

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(strMeal);
        dest.writeString(strCategory);
        dest.writeString(strMealThumb);
        dest.writeString(strInstructions);
    }
}
