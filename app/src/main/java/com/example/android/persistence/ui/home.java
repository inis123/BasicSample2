package com.example.android.persistence.ui;

import androidx.appcompat.app.AppCompatActivity;


import com.example.android.persistence.R;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navBar.initNavBar(getApplicationContext(), this);


    }

}