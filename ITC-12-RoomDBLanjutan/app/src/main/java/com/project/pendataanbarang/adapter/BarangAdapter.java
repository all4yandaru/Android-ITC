package com.project.pendataanbarang.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendataanbarang.BarangUpdateActivity;
import com.project.pendataanbarang.MainActivity;
import com.project.pendataanbarang.R;
import com.project.pendataanbarang.database.BarangDao;
import com.project.pendataanbarang.database.BarangDatabase;
import com.project.pendataanbarang.model.Barang;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {
    private ArrayList<Barang> listBarang = new ArrayList<>();
    private Activity activity;

    public void setListBarang(ArrayList<Barang> listBarang) {
        if (this.listBarang.size() >= 0){
            this.listBarang.clear();
        }
        this.listBarang.addAll(listBarang);
        notifyDataSetChanged();
    }

    public BarangAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.barang_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listBarang.get(position));
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPrice, tvDate;
        ImageView ivDelete;

        Barang barang;
        BarangDao barangDao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvDate = itemView.findViewById(R.id.tv_date);
            ivDelete = itemView.findViewById(R.id.iv_delete);
        }

        void bind(final Barang data){
            NumberFormat format = NumberFormat.getInstance();
            String price = format.format(data.getPrice());
            String harga = "Rp " + price;

            tvJudul.setText(data.getName());
            tvPrice.setText(harga);
            tvDate.setText(data.getDate());

            barangDao = BarangDatabase.getInstance(activity).barangDao();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, BarangUpdateActivity.class);
                    intent.putExtra(BarangUpdateActivity.EXTRA_BARANG, data);
                    activity.startActivityForResult(intent, BarangUpdateActivity.REQUEST_EDIT);
                }
            });

            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity.getApplicationContext(), "Ini delete", Toast.LENGTH_SHORT).show();
                    barangDao.deleteData(data);
                    Intent i = new Intent(activity, MainActivity.class);
                    activity.startActivity(i);
                    activity.finish();
                }
            });

        }
    }
}
