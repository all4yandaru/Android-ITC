package com.project.githubapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.project.githubapi.model.User;
import com.project.githubapi.service.GithubApi;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    //TODO 23: buat key utk nangkep parcelable
    public static final String EXTRA_PARCEL = "extra_parcel";

    private User user;

    private CircleImageView ivAvatar;
    private TextView tvLogin, tvName, tvFollowers, tvFollowing, tvRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //TODO 24: proses tangkap data
        if (getIntent() != null) {
            user = getIntent().getParcelableExtra(EXTRA_PARCEL);
        }

        ivAvatar = findViewById(R.id.iv_avatar);
        tvLogin = findViewById(R.id.tv_login);
        tvName = findViewById(R.id.tv_name);
        tvFollowers = findViewById(R.id.tv_followers);
        tvFollowing = findViewById(R.id.tv_following);
        tvRepos = findViewById(R.id.tv_repos);

        GithubApi githubApi = new GithubApi();
        githubApi.getDetailUser(userListener, user.getLogin());
    }

    //TODO 25: buat listenernya
    ApiListener<User> userListener = new ApiListener<User>() {
        @Override
        public void onSuccess(User user) {
            Picasso.get()
                    .load(user.getAvatar_url())
                    .into(ivAvatar);
            tvLogin.setText(user.getLogin());
            tvName.setText(user.getName());
            tvFollowers.setText("Followers : " + user.getFollowers());
            tvFollowing.setText("Following : " + user.getFollowing());
            tvRepos.setText("Repositories : " + user.getPublic_repos());
        }

        @Override
        public void onFailed(String msg) {
            Log.d("EROR API", msg);
        }
    };
}