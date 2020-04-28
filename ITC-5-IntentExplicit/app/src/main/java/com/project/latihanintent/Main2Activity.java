package com.project.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    final static String EXTRA_NIM = "extra_nim";
    final static String EXTRA_PARCEL = "extra_parcel";
    TextView tvTeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvTeks = findViewById(R.id.tv_teks);
        String nim = getIntent().getStringExtra(EXTRA_NIM);
        Mahasiswa mhs = getIntent().getParcelableExtra(EXTRA_PARCEL);

        tvTeks.setText("Halo, " + mhs.getNama() + "\nNim " + nim);
    }
}
