package com.example.rdb.DataBase;

import android.content.Context;

import com.example.rdb.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    public static  AppRepository outInstance;
    private AppDatabase mdb;
    private Executor executor= Executors.newSingleThreadExecutor();

    public  static AppRepository getInstance(Context context) {
        if (outInstance == null) {
            outInstance = new AppRepository(context);
        }
        return outInstance;
    }

    public List<NoteEntiity> mnotes;

    private AppRepository(Context context){
        mnotes=SampleData.getnotes();
        mdb=AppDatabase.getInstance(context);
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mdb.noteDAO().insertAll(SampleData.getnotes());
            }
        });
    }
}
