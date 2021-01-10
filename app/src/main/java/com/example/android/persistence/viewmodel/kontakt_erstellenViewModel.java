package com.example.android.persistence.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;

public class kontakt_erstellenViewModel extends AndroidViewModel {
    public kontakt_erstellenViewModel(@NonNull Application application) {
        super(application);
    }
    public static void createInteressent(PersonEntity pe, InteressentEntity ie, AdressEntity ae){

    }
}
