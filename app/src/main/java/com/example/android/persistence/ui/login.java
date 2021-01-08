package com.example.android.persistence.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.android.persistence.BasicApp;
import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.Datahold;
import com.example.android.persistence.db.dao.PersonDao;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.viewmodel.loginViewModel;
import com.example.android.persistence.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class login extends AppCompatActivity {
    public static login lg;
    private Datahold dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lg = this;


        Button login = (Button) findViewById(R.id.loginButton);


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.EnterNameField);
                EditText password = (EditText) findViewById(R.id.enterPasswordField);

                /*try {
                    if (new loginViewModel.checkLogin(name.getText().toString(), password.getText().toString()))
                        startActivity(new Intent(login.this, home.class));


                } catch (Exception ncf) {
                    setDebug(ncf.getMessage());
                }*/
            }
        });

    }
    public void setDebug(String a){
        TextView debug=(TextView) findViewById(R.id.debug) ;
        String tmp= debug.getText().toString();
        debug.setText(tmp+"/n"+a);
    }
    public static void de(String a){
        lg.setDebug(a);

    }



}