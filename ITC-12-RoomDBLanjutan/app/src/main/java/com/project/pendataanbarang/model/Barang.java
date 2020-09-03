package com.project.pendataanbarang.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Barang")
public class Barang implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Price")
    private int price;

    @ColumnInfo(name = "UpdateDate")
    private String date;

    @Ignore
    public Barang(int id, String name, int price, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public Barang(String name, int price, String date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    protected Barang(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readInt();
        date = in.readString();
    }

    public static final Creator<Barang> CREATOR = new Creator<Barang>() {
        @Override
        public Barang createFromParcel(Parcel in) {
            return new Barang(in);
        }

        @Override
        public Barang[] newArray(int size) {
            return new Barang[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeString(date);
    }
}
