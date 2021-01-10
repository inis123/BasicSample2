package com.example.android.persistence.ui;
//Heger Stefan
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.android.persistence.R;
import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;

public class kontakt_erstellen extends AppCompatActivity {

    private PersonEntity person;
    private InteressentEntity interessent;
    private AdressEntity adresse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakt_erstellen);

        navBar.initNavBar(getApplicationContext(),this);

        setListener();





    }
    private void setListener(){
        ImageButton abort = (ImageButton) findViewById(R.id.abortButton);
        abort.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), home.class));
            }
        });


        ImageButton accept=(ImageButton)findViewById(R.id.acceptButton);
        accept.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                scanData();
            }
        });
    }
    private void scanData(){
        //PersonEntity
        EditText name = (EditText) findViewById(R.id.editTextFirstName);
        EditText nachname = (EditText) findViewById(R.id.editTextFirstName);
        EditText firma = (EditText) findViewById(R.id.editTextCompany);
        EditText alter = (EditText) findViewById(R.id.editTextAge);
        //InteresentEntity
        EditText stellung = (EditText) findViewById(R.id.editTextStellung);
        //Adress Entity
        EditText mTelNr = (EditText) findViewById(R.id.editTextMobile);
        EditText telNr = (EditText) findViewById(R.id.editTextPhone);
        EditText plz = (EditText) findViewById(R.id.editTextPLZ);
        EditText land = (EditText) findViewById(R.id.editTextLand);
        EditText ort = (EditText) findViewById(R.id.editTextOrt);
        EditText strasse = (EditText) findViewById(R.id.editTextStrasse);
        EditText hausNr = (EditText) findViewById(R.id.editTextHausnummer);
        EditText notiz = (EditText) findViewById(R.id.editTextNotiz);
        int sAlter =Integer.parseInt(alter.getText().toString());

        String sName=name.getText().toString();
        String sNachname=nachname.getText().toString();
        String sFirma=firma.getText().toString();
        String sStellung=stellung.getText().toString();
        String sMTelNr=mTelNr.getText().toString();
        String sTelNr=telNr.getText().toString();
        String sPlz=plz.getText().toString();
        String sLand=land.getText().toString();
        String sOrt=ort.getText().toString();
        String sStrasse=strasse.getText().toString();
        String sHausNr=hausNr.getText().toString();
        String sNotiz=notiz.getText().toString();



        person = new PersonEntity(sName,sNachname,sAlter);
        interessent = new InteressentEntity(sNotiz,sStellung);
        adresse = new AdressEntity(sOrt,sStrasse,sHausNr,sLand,sPlz,sMTelNr,sTelNr);



    }

}