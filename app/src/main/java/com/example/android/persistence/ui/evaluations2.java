package com.example.android.persistence.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.android.persistence.R;
public class evaluations2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluations2);
        navBar.initNavBar(getApplicationContext(),this);
    }
}