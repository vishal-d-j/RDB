package com.example.rdb;

import android.content.Context;
import android.util.Log;

import com.example.rdb.DataBase.AppDatabase;
import com.example.rdb.DataBase.NoteDAO;
import com.example.rdb.DataBase.NoteEntiity;
import com.example.rdb.utilities.SampleData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    public static final String TAG="Junit";
    private AppDatabase mDb;
    private NoteDAO mDao;

    @Before
    public void createDb()
    {
        Context context= InstrumentationRegistry.getInstrumentation().getTargetContext();
        mDb= Room.inMemoryDatabaseBuilder(context,AppDatabase.class).build();
        mDao=mDb.noteDAO();
        Log.i(TAG, "createDb: created the database");

    }

    @After
    public void closeDb()
    {
        mDb.close();
        Log.i(TAG,"CLosed db");
    }

    @Test
    public void createAndRetrieveNotes()
    {
        mDao.insertAll(SampleData.getnotes());
        int count=mDao.getCount();
        Assert.assertEquals(SampleData.getnotes().size(),count);
    }
    @Test
    public void compareStrings(){
        mDao.insertAll(SampleData.getnotes());
        NoteEntiity original=SampleData.getnotes().get(0);
        NoteEntiity  fromdb=mDao.getNoteBtID(1);
        Assert.assertEquals(original.getText(),fromdb.getText());
        Assert.assertEquals(1,fromdb.getId());
    }


}
