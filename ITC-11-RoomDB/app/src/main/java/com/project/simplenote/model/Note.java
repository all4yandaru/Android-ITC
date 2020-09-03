package com.project.simplenote.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//TODO 2 : tambahin anotasi entity

@Entity(tableName = "notes")
public class Note implements Parcelable {
    //TODO 3 : tambahin atribut2 nya
    @PrimaryKey(autoGenerate = true) // auto increment
    @ColumnInfo(name = "Id") // nama kolom
    private int id;

    @ColumnInfo(name = "Title")
    private String title;

    @ColumnInfo(name = "Text")
    private String text;

    @ColumnInfo(name = "updateDate")
    private String date;

    //TODO 4 : buat constructor dan setter getter ada yg pake id, ada yg gapake id

    @Ignore
    public Note(int id, String title, String text, String date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Note(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //TODO 5: implements Parcelable
    protected Note(Parcel in) {
        id = in.readInt();
        title = in.readString();
        text = in.readString();
        date = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(text);
        dest.writeString(date);
    }
}
