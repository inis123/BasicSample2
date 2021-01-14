package com.example.android.persistence.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;


import androidx.annotation.NonNull;

import androidx.lifecycle.AndroidViewModel;

import com.example.android.persistence.connection.vcard;
import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.ui.kontakt_erstellen;



public class kontakt_erstellenViewModel extends AndroidViewModel {
    PersonEntity pe;
    InteressentEntity ie;
    AdressEntity ae;
    AppDatabase db;


    public kontakt_erstellenViewModel(@NonNull Application application) {
        super(application);
    }

    public void createInteressent(Context context, PersonEntity pe, InteressentEntity ie, AdressEntity ae) {

        this.pe = pe;
        this.ie = ie;
        this.ae = ae;

        db = AppDatabase.getInstance(context);

        long adressId = db.adressDao().insert(ae);

        pe.setAdressID((int) adressId);
        long personId = db.personDao().insert(pe);

        ie.setPersonID((int) personId);
        db.interessentDao().insert(ie);

    }

    public void getDataByImg(kontakt_erstellen ke, Bitmap imgBitmap) {

        vcard v = new vcard(ke, imgBitmap);


    }

    public boolean getDataByPersonId(kontakt_erstellen ke, int personId) {

        db = AppDatabase.getInstance(ke.getApplicationContext());

        pe = db.personDao().getById(personId);
        ae = db.adressDao().getById(pe.getAdressID());
        ie = db.interessentDao().getByPersonId(personId);

        ke.setData(pe, ie, ae);

        return true;
    }

}

