package com.example.android.persistence.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.example.android.persistence.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class kontakte extends AppCompatActivity {

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
    }
}