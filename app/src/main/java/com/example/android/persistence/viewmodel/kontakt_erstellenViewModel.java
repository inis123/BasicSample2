package com.example.android.persistence.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.lifecycle.AndroidViewModel;

import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.ui.kontakt_erstellen;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class kontakt_erstellenViewModel extends AndroidViewModel {
    PersonEntity pe; InteressentEntity ie; AdressEntity ae;
    AppDatabase db;


    public kontakt_erstellenViewModel(@NonNull Application application) {
        super(application);
    }
    public void createInteressent(Context context,PersonEntity pe, InteressentEntity ie, AdressEntity ae){
        this.pe=pe;
        this.ie=ie;
        this.ae=ae;
        db=AppDatabase.getInstance(context);
        int adressId=db.adressDao().insert(ae);
        pe.setAdressID(adressId);
        int personID=db.personDao().insert(pe);
        ie.setPersonID(personID);
        db.interessentDao().insert(ie);

    }
    public void getDataByImg(kontakt_erstellen ke, Bitmap imgBitmap){


    }



}

