package com.example.android.persistence.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.persistence.DataRepository;
import com.example.android.persistence.R;
import com.example.android.persistence.db.AppDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);








        ImageButton yourButton = (ImageButton) findViewById(R.id.homeButton);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(home.this, login.class));
            }
        });
    }
}