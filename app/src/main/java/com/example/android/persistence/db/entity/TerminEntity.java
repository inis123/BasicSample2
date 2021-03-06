package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Person;



import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.db.dao.KundenDao;
import com.example.android.persistence.model.Termin;
import com.example.android.persistence.model.Person;
import com.example.android.persistence.model.Product;

    @Entity(tableName = "termin",
            foreignKeys = {
                    @ForeignKey(entity = PersonEntity.class,
                            parentColumns = "personID",
                            childColumns = "personID",
                            onDelete = ForeignKey.CASCADE),
                    @ForeignKey(entity = MitarbeiterEntity.class,
                            parentColumns = "mitarbeiterNr",
                            childColumns = "mitarbeiterNr",
                            onDelete = ForeignKey.CASCADE),

    })
    public class TerminEntity implements Termin {

        @PrimaryKey(autoGenerate = true)
        private int terminNr;

        private int mitarbeiterNr;
        private int personID;
        private long datum; //converter
        private String betreff;
        private String notiz;



        public TerminEntity() {
        }

        @Ignore
        public TerminEntity(int terminNr, int mitarbeiterNr,int personID,long datum,String betreff,String notiz) {
            this.terminNr = terminNr;
            this.mitarbeiterNr = mitarbeiterNr;
            this.personID = personID;
            this.datum = datum;
            this.betreff=betreff;
            this.notiz=notiz;
        }

        public TerminEntity(Termin termin) {
            this.terminNr = termin.terminNr();
            this.mitarbeiterNr = termin.mitarbeiterNr();
            this.personID = termin.personID();
            this.datum = termin.datum();
            this.betreff = termin.betreff();
            this.notiz = termin.notiz();
        }

        @Override
        public String notiz() {
            return notiz;
        }

        @Override
        public String betreff() {
            return betreff;
        }

        @Override
        public long datum() {
            return datum;
        }

        @Override
        public int personID() {
            return personID;
        }

        @Override
        public int mitarbeiterNr() {
            return mitarbeiterNr;
        }

        @Override
        public int terminNr() {
            return terminNr;
        }
    }


