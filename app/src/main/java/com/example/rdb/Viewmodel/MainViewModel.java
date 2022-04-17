package com.example.rdb.Viewmodel;

import android.app.Application;

import com.example.rdb.DataBase.AppRepository;
import com.example.rdb.DataBase.NoteEntiity;
import com.example.rdb.utilities.SampleData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

public class MainViewModel extends ViewModel {

    public List<NoteEntiity> mnotes;
    private AppRepository mapprepo;

    public MainViewModel(@NonNull Application application) {

        mapprepo=AppRepository.getInstance(application.getApplicationContext());
        mnotes=mapprepo.mnotes;
    }

    public void addSampleData() {
        mapprepo.addSampleData();
    }
}
