package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
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

    @Entity(tableName = "mitarbeiter",
            foreignKeys = {
                    @ForeignKey(entity = PersonEntity.class,
                            parentColumns = "personID",
                            childColumns = "personID",
                            onDelete = ForeignKey.CASCADE)})
    public class MitarbeiterEntity implements Mitarbeiter {

        @PrimaryKey(autoGenerate = true)
        private int mitarbeiterNr;

        private int personID;
        private String password;


        public MitarbeiterEntity() {
        }

        @Ignore
        public MitarbeiterEntity(int personID, int mitarbeiterNr,String password) {
            this.personID = personID;
            this.mitarbeiterNr = mitarbeiterNr;
            this.password=password;

        }
        @Ignore
        public MitarbeiterEntity(int personID,String password) {
            this.personID = personID;
            this.password=password;

        }

        public MitarbeiterEntity(Mitarbeiter mitarbeiter) {
            this.personID = mitarbeiter.getPersonId();
            this.mitarbeiterNr = mitarbeiter.getMitarbeiterNr();
            this.password=mitarbeiter.getPassword();

        }


        @Override
        public int getPersonId() {
            return personID;
        }
        @Override
        public int getMitarbeiterNr() {
            return mitarbeiterNr;
        }
        @Override
        public String getPassword() {
            return password;
        }
    }



