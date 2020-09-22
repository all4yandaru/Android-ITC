package com.project.themealdb;

public interface ApiListener<T> {
    void onSuccess(T meals);
    void onFailed(String msg);
}
