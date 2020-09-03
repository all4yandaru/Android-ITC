package com.project.simplenote;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.project.simplenote.adapter.NoteAdapter;
import com.project.simplenote.database.NoteDao;
import com.project.simplenote.database.NoteDatabase;
import com.project.simplenote.model.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;

    //TODO 16: buat RecyclerView dari database
    private RecyclerView rvNotes;
    private NoteAdapter noteAdapter;
    private ArrayList<Note> listNotes = new ArrayList<>();
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 16: lanjutan
        rvNotes = findViewById(R.id.rv_notes);
        noteDao = NoteDatabase.getInstance(this).noteDao();

        noteAdapter = new NoteAdapter(this);

        rvNotes.setHasFixedSize(true);
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
        rvNotes.setAdapter(noteAdapter);
        loadData();

        //TODO 14: buat intent pake startActivityForResult, biar ada nilai pengembaliannya, dan ditambah REQUEST_ADD
        fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoteAddActivity.class);
                startActivityForResult(intent, NoteAddActivity.REQUEST_ADD);
            }
        });
    }

    //TODO 18: buat beginian, gapaham aing :'3, intinya buat nerima result dan refresh kalo data udah di add atau update
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NoteAddActivity.REQUEST_ADD){
            if (resultCode == NoteAddActivity.RESULT_ADD){
                loadData();
                showSnackbar("Data berhasil ditambahkan!");
            }
        }
        //TODO 26: tambahin ini biar habis update datanya di load ulang
        else if (requestCode == NoteActivity.REQUEST_EDIT){
            if (resultCode == NoteActivity.RESULT_EDIT){
                loadData();
                showSnackbar("Data berhasil diedit!");
            }
            else if (resultCode == NoteActivity.RESULT_DELETE){
                loadData();
                showSnackbar("Data berhasil dihapus!");
            }
        }
    }

    //TODO 17: buat void Load Data
    void loadData(){
        List<Note> data =  noteDao.getAllData();
        if (listNotes.size() >= 0){
            listNotes.clear();
        }
        listNotes.addAll(data);
        noteAdapter.setListNotes(listNotes);

        if (data.size() == 0){
            showSnackbar("Tidak ada data!");
        }

    }

    //TODO 27: tambahan untuk munculin snackbar aja sih
    private void showSnackbar(String message){
        Snackbar.make(rvNotes, message, Snackbar.LENGTH_LONG).show();
    }
}