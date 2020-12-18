package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Kunde;
import com.example.android.persistence.model.Mitarbeiter;



import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.db.dao.KundenDao;
import com.example.android.persistence.model.Kunde;
import com.example.android.persistence.model.Product;

    @Entity(tableName = "mitarbeiter")
    public class MitarbeiterEntity implements Mitarbeiter {

        @PrimaryKey(autoGenerate = true)
        private int personID;
        private int mitarbeiterNr;



        public MitarbeiterEntity() {
        }

        @Ignore
        public MitarbeiterEntity(int personID, int mitarbeiterNr) {
            this.personID = personID;
            this.mitarbeiterNr = mitarbeiterNr;

        }

        public MitarbeiterEntity(Mitarbeiter mitarbeiter) {
            this.personID = mitarbeiter.getPersonId();
            this.mitarbeiterNr = mitarbeiter.getMitarbeiterNr();

        }

        @Override
        public int getPersonId() {
            return personID;
        }

        @Override
        public int getMitarbeiterNr() {
            return mitarbeiterNr;
        }
    }



