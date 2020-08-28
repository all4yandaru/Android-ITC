package com.project.myanime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";
    private Anime anime;

    TextView tvJudul, tvDesc, tvTglRilis, tvSutradara, tvRating;
    ImageView imgCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_deskripsi);
        tvTglRilis = findViewById(R.id.tv_tanggal);
        tvSutradara = findViewById(R.id.tv_studio);
        imgCover = findViewById(R.id.img_gambar);
        tvRating = findViewById(R.id.tv_rating);

        anime = getIntent().getParcelableExtra(EXTRA_DATA);

        Picasso.get()
                .load(anime.getPhoto())
                .placeholder(R.drawable.ic_baseline_broken_image_24)
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(imgCover);

        tvJudul.setText(anime.getJudul());
        tvDesc.setText(anime.getDesc());
        tvTglRilis.setText(anime.getTanggalRilis());
        tvSutradara.setText(anime.getStudio());
        tvRating.setText(anime.getRating());
    }
}