package com.project.itccafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTambahMakanan, btnTambahMinuman, btnKurangMakanan, btnKurangMinuman, btnBuy, btnReset;
    TextView tvJumlahMakanan, tvJumlahMinuman, tvHarga, tvPurchased;

    int jumlahMakanan = 0;
    int jumlahMinuman = 0;
    int totalHarga = 0;

    final int hargaMakanan = 10000;
    final int hargaMinuman = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambahMakanan = findViewById(R.id.btn_tambahmakanan);
        btnKurangMakanan = findViewById(R.id.btn_kurangmakanan);

        btnTambahMinuman = findViewById(R.id.btn_tambahminuman);
        btnKurangMinuman = findViewById(R.id.btn_kurangminuman);

        btnBuy = findViewById(R.id.btn_buy);
        btnReset = findViewById(R.id.btn_reset);

        tvJumlahMakanan = findViewById(R.id.tv_jumlahmakanan);
        tvJumlahMinuman = findViewById(R.id.tv_jumlahminuman);

        tvHarga = findViewById(R.id.tv_harga);
        tvPurchased = findViewById(R.id.tv_purchased);

        btnTambahMakanan.setOnClickListener(this);
        btnKurangMakanan.setOnClickListener(this);

        btnTambahMinuman.setOnClickListener(this);
        btnKurangMinuman.setOnClickListener(this);

        btnBuy.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tambahmakanan:
                Pesanan(R.id.btn_tambahmakanan);
                break;

            case R.id.btn_kurangmakanan:
                Pesanan(R.id.btn_kurangmakanan);
                break;

            case R.id.btn_tambahminuman:
                Pesanan(R.id.btn_tambahminuman);
                break;

            case R.id.btn_kurangminuman:
                Pesanan(R.id.btn_kurangminuman);
                break;

            case R.id.btn_buy:
                BuyReset(R.id.btn_buy);
                break;

            case R.id.btn_reset:
                BuyReset(R.id.btn_reset);
                break;
        }
    }

    void Pesanan(int id) {
        if (id == R.id.btn_tambahmakanan) {
            if (jumlahMakanan < 10) {
                jumlahMakanan++;
                totalHarga = totalHarga + hargaMakanan;

                tvJumlahMakanan.setText("" + jumlahMakanan);
                tvPurchased.setText("");
                tvHarga.setText("Rp. " + totalHarga);
            }
        } else if (id == R.id.btn_kurangmakanan) {
            if (jumlahMakanan > 0) {
                jumlahMakanan--;
                totalHarga = totalHarga - hargaMakanan;

                tvJumlahMakanan.setText("" + jumlahMakanan);
                tvPurchased.setText("");
                tvHarga.setText("Rp. " + totalHarga);
            }
        } else if (id == R.id.btn_tambahminuman) {
            if (jumlahMinuman < 10) {
                jumlahMinuman++;
                totalHarga = totalHarga + hargaMinuman;

                tvJumlahMinuman.setText("" + jumlahMinuman);
                tvPurchased.setText("");
                tvHarga.setText("Rp. " + totalHarga);
            }
        } else if (id == R.id.btn_kurangminuman) {
            if (jumlahMinuman > 0) {
                jumlahMinuman--;
                totalHarga = totalHarga - hargaMinuman;

                tvJumlahMinuman.setText("" + jumlahMinuman);
                tvPurchased.setText("");
                tvHarga.setText("Rp. " + totalHarga);
            }
        }
    }

    void BuyReset(int id) {
        if (id == R.id.btn_buy) {
            tvPurchased.setText("Purchased");
        } else if (id == R.id.btn_reset) {
            jumlahMakanan = 0;
            jumlahMinuman = 0;
            totalHarga = 0;

            tvJumlahMakanan.setText("" + jumlahMakanan);
            tvJumlahMinuman.setText("" + jumlahMinuman);
            tvPurchased.setText("");
            tvHarga.setText("Rp. " + totalHarga);
        }
    }
}
