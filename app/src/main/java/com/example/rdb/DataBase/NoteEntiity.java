package com.example.rdb.DataBase;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class NoteEntiity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private Date date;
    private String text;

    @Override
    public String toString() {
        return "NoteEntiity{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }

    //when note to be created empty
    @Ignore
    public NoteEntiity() {
    }

  // when u want to edit already present note
    public NoteEntiity(int id, Date date, String text) {
        this.id = id;
        this.date = date;
        this.text = text;
    }

  //when u want to crreate note with auto generated
    @Ignore
    public NoteEntiity(Date date, String text) {
        this.date = date;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
