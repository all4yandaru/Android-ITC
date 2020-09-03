package com.project.pendataanbarang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.pendataanbarang.database.BarangDao;
import com.project.pendataanbarang.database.BarangDatabase;
import com.project.pendataanbarang.model.Barang;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BarangAddActivity extends AppCompatActivity {

    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 110;
    public static final String EXTRA_ADD = "extra_add";

    EditText etJudul, etPrice;
    Button btnAdd;

    private BarangDao barangDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_add);

        barangDao = BarangDatabase.getInstance(this).barangDao();

        etJudul = findViewById(R.id.et_judul);
        etPrice = findViewById(R.id.et_price);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = etJudul.getText().toString();
                String price = etPrice.getText().toString();
                int harga = Integer.parseInt(price);
                String date = getCurrentDate();

                Barang barang = new Barang(judul, harga, date);
                barangDao.insertData(barang);

                Intent intent = new Intent();
                intent.putExtra(EXTRA_ADD, barang);
                setResult(RESULT_ADD);
                finish();
            }
        });
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}