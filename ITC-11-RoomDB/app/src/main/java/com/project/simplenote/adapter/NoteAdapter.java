package com.project.simplenote.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.simplenote.NoteActivity;
import com.project.simplenote.R;
import com.project.simplenote.model.Note;

import java.util.ArrayList;

//TODO 12: buat adapter buat Recycler View

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private ArrayList<Note> listNotes = new ArrayList<>();
    private Activity activity;

    public void setListNotes(ArrayList<Note> listNotes) {
        if (listNotes.size() >= 0){
            this.listNotes.clear();
        }
        this.listNotes.addAll(listNotes);
        notifyDataSetChanged();
    }

    public NoteAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvText, tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvText = itemView.findViewById(R.id.tv_text);
            tvDate = itemView.findViewById(R.id.tv_date);
        }

        void bind(final Note data){
            tvTitle.setText(data.getTitle());
            tvText.setText(data.getText());
            tvDate.setText(data.getDate());

            //TODO 22: buat intent nya dulu
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, NoteActivity.class);
                    intent.putExtra(NoteActivity.EXTRA_NOTE, data);
                    activity.startActivityForResult(intent, NoteActivity.REQUEST_EDIT);
                }
            });
        }
    }
}
