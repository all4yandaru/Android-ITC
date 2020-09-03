package com.project.pendataanbarang;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.project.pendataanbarang.adapter.BarangAdapter;
import com.project.pendataanbarang.database.BarangDao;
import com.project.pendataanbarang.database.BarangDatabase;
import com.project.pendataanbarang.model.Barang;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;

    private RecyclerView rvBarang;
    private BarangAdapter barangAdapter;
    private ArrayList<Barang> listBarang = new ArrayList<>();
    private BarangDao barangDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBarang = findViewById(R.id.rv_barang);
        barangDao = BarangDatabase.getInstance(this).barangDao();

        barangAdapter = new BarangAdapter(this);

        rvBarang.setHasFixedSize(true);
        rvBarang.setLayoutManager(new LinearLayoutManager(this));
        rvBarang.setAdapter(barangAdapter);
        loadData();

        fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarangAddActivity.class);
                startActivityForResult(intent, BarangAddActivity.REQUEST_ADD);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BarangAddActivity.REQUEST_ADD){
            if (resultCode == BarangAddActivity.RESULT_ADD){
                loadData();
                showSnackbar("Data berhasil ditambahkan!");
            }
        }
        else if (requestCode == BarangUpdateActivity.REQUEST_EDIT){
            if (resultCode == BarangUpdateActivity.RESULT_EDIT){
                loadData();
                showSnackbar("Data berhasil diupdate!");
            }
        }
    }

    void loadData(){
        List<Barang> data =  barangDao.getAllData();
        if (listBarang.size() >= 0){
            listBarang.clear();
        }
        listBarang.addAll(data);
        barangAdapter.setListBarang(listBarang);

        if (data.size() == 0){
            showSnackbar("Tidak ada data!");
        }

    }

    private void showSnackbar(String message){
        Snackbar.make(rvBarang, message, Snackbar.LENGTH_SHORT).show();
    }
}