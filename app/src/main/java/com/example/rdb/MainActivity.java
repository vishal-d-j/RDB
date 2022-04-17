package com.example.rdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rdb.Adapters.Notesadapter;
import com.example.rdb.DataBase.NoteEntiity;
import com.example.rdb.Viewmodel.MainViewModel;
import com.example.rdb.utilities.SampleData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    Button add_new_note;
    private List<NoteEntiity> notesdata=new ArrayList<>();
    Notesadapter notesadapter;
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mrecyclerView=findViewById(R.id.recycler_view_for_data);
        FloatingActionButton fb=findViewById(R.id.fab);
        initViewModel();
        initReccylerView();
        notesdata.addAll(mainViewModel.mnotes);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,Editoractivity.class);
                startActivity(i);
            }
        });
        add_new_note=findViewById(R.id.add_btn);
        add_new_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSampleData();
            }
        });

    }

    private void addSampleData() {
        mainViewModel.addSampleData();
    }

    private void initViewModel() {
        mainViewModel=new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void initReccylerView() {
        mrecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(layoutManager);
        notesadapter =new Notesadapter(notesdata,getApplicationContext());
        mrecyclerView.setAdapter(notesadapter);
    }
}