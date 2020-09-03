package com.project.simplenote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.simplenote.database.NoteDao;
import com.project.simplenote.database.NoteDatabase;
import com.project.simplenote.model.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteActivity extends AppCompatActivity {

    //TODO 23: jangan lupa buat key untuk kirim data
    public static final String EXTRA_NOTE = "extra_note";
    public static final int REQUEST_EDIT = 200;
    public static final int RESULT_EDIT = 210;
    public static final int RESULT_DELETE = 220;

    EditText etTitle, etText;
    Button btnSave;

    //TODO 24: terima data intent & inisialisasi NoteDao biar bisa update data
    private Note note;
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //TODO 19: buat class utk update data, memulai Update & Delete (UD)

        if (getActionBar() != null){
            getActionBar().setTitle("Edit");
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //TODO 24: diterima pake parcelable & koneksiin NoteDao ke database
        note = getIntent().getParcelableExtra(EXTRA_NOTE);
        noteDao = NoteDatabase.getInstance(this).noteDao();

        //TODO 25: koneksiin id nya
        etTitle = findViewById(R.id.et_title);
        etText = findViewById(R.id.et_text);
        btnSave = findViewById(R.id.btn_save);

        etTitle.setText(note.getTitle());
        etText.setText(note.getText());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String text = etText.getText().toString();
                String date = getCurrentDate();

                Note updateNote = new Note(note.getId(), title, text, date);

                noteDao.updateData(updateNote);

                setResult(RESULT_EDIT);
                finish();
            }
        });
    }

    private String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    //TODO 28: buat untuk deletenya
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_delete){
            noteDao.deleteData(note);

            setResult(RESULT_DELETE);
            finish();
        } else if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}