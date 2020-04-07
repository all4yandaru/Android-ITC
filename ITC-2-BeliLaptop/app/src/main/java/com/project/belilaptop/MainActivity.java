package com.project.belilaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvtgl;
    Calendar c;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvtgl = findViewById(R.id.tv_tanggal);
        tvtgl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                tvtgl.setText(mDay + "/" + (mMonth+1) + "/" + mYear);
            }
        }, day, month, year);
        dpd.show();
    }
}
