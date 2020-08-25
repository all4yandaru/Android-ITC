package com.project.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameGridAdapter extends RecyclerView.Adapter<GameGridAdapter.ViewHolder> {
    ArrayList<Game> listGame = new ArrayList<>();

    public GameGridAdapter(ArrayList<Game> listGame) {
        this.listGame = listGame;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listGame.get(position));
    }

    @Override
    public int getItemCount() {
        return listGame.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGame;
        Context context = itemView.getContext();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGame = itemView.findViewById(R.id.iv_game);

        }

        void bind(final Game data){
            Picasso.get()
                    .load(data.getImage())
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .error(R.drawable.ic_baseline_image_24)
                    .into(ivGame);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Saya memilih " + data.getTitle(), Toast.LENGTH_LONG).show();
                    /*Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_GAME, data);
                    context.startActivity(intent);*/
                }
            });
        }
    }
}
