package com.example.android.persistence.db;
//Heger Stefan

import android.content.Context;

import com.example.android.persistence.db.dao.*;
import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.AktivitaetEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.KundenEntity;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.OpportunityEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.db.entity.TerminEntity;
import com.example.android.persistence.db.entity.VertragEntity;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {KundenEntity.class, AdressEntity.class, AktivitaetEntity.class,
        InteressentEntity.class, MitarbeiterEntity.class, OpportunityEntity.class, PersonEntity.class, TerminEntity.class, VertragEntity.class,}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


    public abstract KundenDao kundenDao();
    public abstract AdressDao adressDao();
    public abstract InteressentDao interessentDao();
    public abstract MitarbeiterDao mitarbeiterDao();
    public abstract OpportiunityDao opportiunityDao();
    public abstract PersonDao personDao();
    public abstract TerminDao terminDao();
    public abstract VertragDao vertragDao();
    private static AppDatabase db;


    public static AppDatabase getInstance(Context context) {

        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "roomdb6")
                    .allowMainThreadQueries()
                    .build();

            db.personDao().insertAll(DataGenerator.genPerson());
            db.mitarbeiterDao().insertAll(DataGenerator.genMitarbeiter());
            db.interessentDao().insertAll(DataGenerator.genInteressent());
            db.adressDao().insertAll(DataGenerator.genAdress());
        }

        return db;
    }

}
