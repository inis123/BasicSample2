package com.example.android.persistence.ui;
//Heger Stefan

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.android.persistence.R;
import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.model.Interessent;
import com.example.android.persistence.viewmodel.kontakt_erstellenViewModel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class kontakt_erstellen extends AppCompatActivity {
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    kontakt_erstellenViewModel keVM = new kontakt_erstellenViewModel(getApplication());

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private PersonEntity person;
    private InteressentEntity interessent;
    private AdressEntity adresse;


    private String currentPhotoPath;
    private Uri image_uri;


    //PersonEntity
    private EditText name;
    private EditText nachname;
    private EditText firma;
    private EditText alter;
    //InteresentEntity
    private EditText stellung;
    //Adress Entity
    private EditText mTelNr;
    private EditText telNr;
    private EditText plz;
    private EditText land;
    private EditText ort;
    private EditText strasse;
    private EditText hausNr;
    private EditText notiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakt_erstellen);

        //navBar.initNavBar(getApplicationContext(), this);

        setListener();


    }

    private void setListener() {
        ImageButton abort = (ImageButton) findViewById(R.id.abortButton);
        abort.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), home.class));
            }
        });


        ImageButton accept = (ImageButton) findViewById(R.id.acceptButton);
        accept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scanData();

                keVM.createInteressent(getApplicationContext(), person, interessent, adresse);
                startActivity(new Intent(getApplicationContext(), kontakte.class));
            }
        });

        Button scan = (Button) findViewById(R.id.scanCardButton);
        scan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);
                    } else {//darf schon resourcen benutzen
                        openCamera();
                    }

                } else {
                    //alte VErsion
                    openCamera();
                }

            }
        });


    }

    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "new vcard");
        values.put(MediaStore.Images.Media.DESCRIPTION, "new vcard");

        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);

        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();

            Bitmap imgBitmap = (Bitmap) extras.get("data");
            keVM.getDataByImg(this, imgBitmap);
        }
    }

    private void scanData() {

        int sAlter = Integer.parseInt(alter.getText().toString());

        String sName = name.getText().toString();
        String sNachname = nachname.getText().toString();
        String sFirma = firma.getText().toString();
        String sStellung = stellung.getText().toString();
        String sMTelNr = mTelNr.getText().toString();
        String sTelNr = telNr.getText().toString();
        String sPlz = plz.getText().toString();
        String sLand = land.getText().toString();
        String sOrt = ort.getText().toString();
        String sStrasse = strasse.getText().toString();
        String sHausNr = hausNr.getText().toString();
        String sNotiz = notiz.getText().toString();


        person = new PersonEntity(sName, sNachname, sAlter);
        interessent = new InteressentEntity(sNotiz, sStellung);
        adresse = new AdressEntity(sOrt, sStrasse, sHausNr, sLand, sPlz, sMTelNr, sTelNr);


    }

    public void setData(PersonEntity pe, InteressentEntity ie, AdressEntity ae) {
        this.person = pe;
        this.interessent = ie;
        this.adresse = ae;
        writeDataToView(pe, ie, ae);
    }

    private void writeDataToView(PersonEntity pe, InteressentEntity ie, AdressEntity ae) {
        //PersonEntity
        name.setText(pe.getName());
        nachname.setText(pe.getNachname());
        EditText firma = (EditText) findViewById(R.id.editTextCompany);
        alter.setText(pe.getAlter());
        //InteresentEntity
        stellung.setText(ie.getStellung());
        //Adress Entity
        mTelNr.setText(ae.getmTelNr());
        telNr.setText(ae.getTelNr());
        plz.setText(ae.getPlz());
        land.setText(ae.getLand());
        ort.setText(ae.getOrt());
        strasse.setText(ae.getStrasse());
        hausNr.setText(ae.getHausnummer());
        notiz.setText(ie.getNotiz());
    }

    private void initTextField() {
        name = (EditText) findViewById(R.id.editTextFirstName);
        nachname = (EditText) findViewById(R.id.editTextFirstName);
        firma = (EditText) findViewById(R.id.editTextCompany);
        alter = (EditText) findViewById(R.id.editTextAge);
        //InteresentEntity
        stellung = (EditText) findViewById(R.id.editTextStellung);
        //Adress Entity
        mTelNr = (EditText) findViewById(R.id.editTextMobile);
        telNr = (EditText) findViewById(R.id.editTextPhone);
        plz = (EditText) findViewById(R.id.editTextPLZ);
        land = (EditText) findViewById(R.id.editTextLand);
        ort = (EditText) findViewById(R.id.editTextOrt);
        strasse = (EditText) findViewById(R.id.editTextStrasse);
        hausNr = (EditText) findViewById(R.id.editTextHausnummer);
        notiz = (EditText) findViewById(R.id.editTextNotiz);
    }

}