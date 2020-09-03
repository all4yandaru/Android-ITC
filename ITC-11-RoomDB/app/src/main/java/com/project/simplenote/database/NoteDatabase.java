package com.project.simplenote.database;

//TODO 8: buat abstract Databasenya, tambahin anotasi @Database & extends RoomDatabase

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.simplenote.model.Note;

@Database(entities = Note.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    private static final String DB_NAME = "db_notes";
    private static NoteDatabase instance;
    public abstract NoteDao noteDao();

    public static NoteDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
