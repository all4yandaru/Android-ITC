package com.project.pendataanbarang;

import androidx.appcompat.app.AppCompatActivity;

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

public class BarangUpdateActivity extends AppCompatActivity {

    public static final String EXTRA_BARANG = "extra_barang";
    public static final int REQUEST_EDIT = 200;
    public static final int RESULT_EDIT = 210;

    private Barang barang;
    private BarangDao barangDao;

    EditText etJudul, etPrice;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_update);

        if (getActionBar() != null){
            getActionBar().setTitle("Edit");
        }

        barang = getIntent().getParcelableExtra(EXTRA_BARANG);
        barangDao = BarangDatabase.getInstance(this).barangDao();

        etJudul = findViewById(R.id.et_judul);
        etPrice = findViewById(R.id.et_price);
        btnSave = findViewById(R.id.btn_save);

        etJudul.setText(barang.getName());

        int harga = barang.getPrice();
        String pricee = String.valueOf(harga);
        etPrice.setText(pricee);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = etJudul.getText().toString();
                String price = etPrice.getText().toString();
                int harga = Integer.parseInt(price);
                String date = getCurrentDate();

                Barang updateBarang = new Barang(barang.getId(), judul, harga, date);
                barangDao.updateData(updateBarang);

                setResult(RESULT_EDIT);
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