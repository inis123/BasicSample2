package com.example.android.persistence.ui;

import androidx.appcompat.app.AppCompatActivity;


import com.example.android.persistence.viewmodel.loginViewModel;
import com.example.android.persistence.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button login = (Button) findViewById(R.id.loginButton);


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView status = findViewById(R.id.statusField);

                EditText name = (EditText) findViewById(R.id.EnterNameField);
                EditText password = (EditText) findViewById(R.id.enterPasswordField);

                switch (loginViewModel.checkLogin(getApplicationContext(), name.getText().toString(), password.getText().toString())) {
                    case 0:
                        status.setText("Username incorrect");
                        break;
                    case 1:
                        status.setText("permission required");
                        break;
                    case 2:
                        status.setText("success");
                        startActivity(new Intent(getApplicationContext(), home.class));
                        break;
                    case 3:
                        status.setText("password incorrect");
                        break;
                }

            }
        });



    }




}