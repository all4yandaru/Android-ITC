package com.project.githubapi;

import com.project.githubapi.model.User;

import java.util.ArrayList;

//TODO 10: buat Listener utk callback kalo sukses ambil api atau gagal
public interface ApiListener<T> {

    void onSuccess(T users); // T itu biar bisa dimasukin banyak tipe data, ga cuman utk satu jenis tipe data aja
    void onFailed(String msg);
}
