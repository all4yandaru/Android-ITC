package com.project.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNim;
    Button btnPencet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNim = findViewById(R.id.et_nim);

        btnPencet = findViewById(R.id.btn_pencet);

        btnPencet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pencet :
                String nim = etNim.getText().toString();
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);

                Mahasiswa mhs = new Mahasiswa("Fulan", nim);
                mhs.setContact("082136564484");

                if (nim.equals("123180054")){
                    mhs = new Mahasiswa("Allya", nim);
                    mhs.setContact("087700049687");
                }
                else if (nim.equals("123180053")){
                    mhs = new Mahasiswa("Pak RW", nim);
                    mhs.setContact("012345678910");
                }
                else {
                    nim = "1231800xx";
                }

                i.putExtra(Main2Activity.EXTRA_NIM, nim);
                i.putExtra(Main2Activity.EXTRA_PARCEL, mhs);
                startActivity(i);

                break;
        }
    }
}
