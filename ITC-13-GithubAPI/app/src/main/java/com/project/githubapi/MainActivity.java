package com.project.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.project.githubapi.adapter.UserAdapter;
import com.project.githubapi.model.User;
import com.project.githubapi.service.GithubApi;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //TODO 13: balik ke main buat recyclerview

    private RecyclerView rvGithub;
    private UserAdapter userAdapter;
    private ArrayList<User> listUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 14: konekin dulu adapter sama tampilan recyclerview nya
        userAdapter = new UserAdapter();
        rvGithub = findViewById(R.id.rv_github);
        rvGithub.setLayoutManager(new LinearLayoutManager(this));
        rvGithub.setHasFixedSize(true);
        rvGithub.setAdapter(userAdapter);

        //TODO 16: panggil GithubApi dan ApiListener
        GithubApi githubApi = new GithubApi();
        githubApi.getAllUsers(apiListener);
    }

    //TODO 15: buat inisialisasi ApiListener
    ApiListener<ArrayList<User>> apiListener = new ApiListener<ArrayList<User>>() {
        @Override
        public void onSuccess(ArrayList<User> users) {
            listUser.addAll(users);
            userAdapter.setUsers(listUser);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("EROR Api", msg);
        }
    };
}