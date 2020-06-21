package com.project.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    final static String EXTRA_NIM = "extra_nim";
    final static String EXTRA_PARCEL = "extra_parcel";
    TextView tvTeks;
    ImageView ivCall;
    Mahasiswa mhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvTeks = findViewById(R.id.tv_teks);
        String nim = getIntent().getStringExtra(EXTRA_NIM);
        mhs = getIntent().getParcelableExtra(EXTRA_PARCEL);

        tvTeks.setText("Halo, " + mhs.getNama() + "\nNim " + nim + "\nContact " + mhs.getContact());

        ivCall = findViewById(R.id.iv_call);
        ivCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_call:
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mhs.getContact()));
                startActivity(i);
                break;
        }
    }
}
