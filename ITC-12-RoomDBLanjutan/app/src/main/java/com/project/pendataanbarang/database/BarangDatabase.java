package com.project.pendataanbarang.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.pendataanbarang.model.Barang;

@Database(entities = Barang.class, version = 1)
public abstract class BarangDatabase extends RoomDatabase {
    private static final String DB_NAME = "db_pendataan_barang";
    private static BarangDatabase instance;

    public abstract BarangDao barangDao();

    public static BarangDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), BarangDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
