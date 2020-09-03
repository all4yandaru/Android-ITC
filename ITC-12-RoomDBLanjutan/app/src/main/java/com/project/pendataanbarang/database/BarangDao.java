package com.project.pendataanbarang.database;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.pendataanbarang.model.Barang;

import java.util.List;

@Dao
public interface BarangDao {
    @Query("SELECT * FROM Barang")
    List<Barang> getAllData();

    @Insert
    void insertData(Barang barang);

    @Update
    void updateData(Barang barang);

    @Delete
    void deleteData(Barang barang);
}
