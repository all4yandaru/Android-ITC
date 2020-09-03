package com.project.simplenote.database;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.simplenote.model.Note;

import java.util.List;

//TODO 6: buat interface Dao & tambahin anotasinya
@Dao
public interface NoteDao {

    //TODO 7: tambahin query2 nya
    @Query("SELECT * FROM notes")
    List<Note> getAllData();

    @Insert
    void insertData(Note note);

    @Update
    void updateData(Note note);

    @Delete
    void deleteData(Note note);

}
