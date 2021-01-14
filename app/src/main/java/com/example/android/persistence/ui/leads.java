package com.example.android.persistence.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android.persistence.R;

public class leads extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads);
        navBar.initNavBar(getApplicationContext(), this);
    }
}