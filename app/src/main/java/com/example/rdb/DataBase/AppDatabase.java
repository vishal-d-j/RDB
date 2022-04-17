package com.example.rdb.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {NoteEntiity.class},version = 1)
@TypeConverters(DataConvertor.class)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME="AppDatabase.db";
    private static volatile AppDatabase instance;

    private static final Object LOCK=new Object();

    public static AppDatabase getInstance(Context context) {
        if(instance==null)
        {
            synchronized (LOCK)
            {
                if(instance==null){
                    instance= Room.databaseBuilder(context,AppDatabase.class,DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }

    public abstract NoteDAO noteDAO();
}
