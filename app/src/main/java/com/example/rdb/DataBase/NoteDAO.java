package com.example.rdb.DataBase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteEntiity noteEntiity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NoteEntiity> notes);

    @Delete
    void deleteNote(NoteEntiity noteEntiity);

    @Query("DELETE FROM notes")
    int deleteAll();

    @Query("SELECT * FROM notes WHERE id= :id")
    NoteEntiity getNoteBtID(int id);

    @Query("SELECT * FROM notes ORDER BY date DESC")
    LiveData<List<NoteEntiity>> getAll();

    @Query("SELECT COUNT(*) FROM notes")
    int getCount();



}
