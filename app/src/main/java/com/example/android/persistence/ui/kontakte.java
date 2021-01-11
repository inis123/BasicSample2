package com.example.android.persistence.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.persistence.R;
import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.viewmodel.kontakteListAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class kontakte extends AppCompatActivity implements kontakteListAdapter.OnPersonListener {

    private kontakteListAdapter kListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakte);
        navBar.initNavBar(getApplicationContext(),this);



        Button accept=(Button)findViewById(R.id.kontaktCreateButton);
        accept.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), kontakt_erstellen.class));
            }
        });

        initRecyclerView();
        loadKontakteList();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView =findViewById(R.id.kontakteRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        kListAdapter = new kontakteListAdapter(this);
        recyclerView.setAdapter(kListAdapter);
    }
    private void loadKontakteList(){
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        List<PersonEntity> kontakteList=db.personDao().getAll();
        kListAdapter.setPersonList(kontakteList);


    }

    @Override
    public void onPersonClick(int position) {

    }
}