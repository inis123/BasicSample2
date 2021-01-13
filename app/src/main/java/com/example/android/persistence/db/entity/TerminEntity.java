package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


import com.example.android.persistence.model.Termin;

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
        private long zeit;



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
    @Ignore
        public TerminEntity(Termin termin) {
            this.terminNr = termin.getTerminNr();
            this.mitarbeiterNr = termin.getMitarbeiterNr();
            this.personID = termin.getPersonID();
            this.datum = termin.getDatum();
            this.betreff = termin.getBetreff();
            this.notiz = termin.getNotiz();
            this.zeit = termin.getZeit();
        }

        @Override
        public String getNotiz() {
            return notiz;
        }

        @Override
        public String getBetreff() {
            return betreff;
        }

        @Override
        public long getDatum() {
            return datum;
        }

        @Override
        public int getPersonID() {
            return personID;
        }

        @Override
        public int getMitarbeiterNr() {
            return mitarbeiterNr;
        }

        @Override
        public int getTerminNr() {
            return terminNr;
        }

        @Override
        public long getZeit() {
         return zeit;
         }

    public void setTerminNr(int terminNr) {
            this.terminNr = terminNr;
        }

        public void setMitarbeiterNr(int mitarbeiterNr) {
            this.mitarbeiterNr = mitarbeiterNr;
        }

        public void setPersonID(int personID) {
            this.personID = personID;
        }

        public void setDatum(long datum) {
            this.datum = datum;
        }

        public void setBetreff(String betreff) {
            this.betreff = betreff;
        }

        public void setNotiz(String notiz) {
            this.notiz = notiz;
        }

        public void setZeit(long zeit) {this.zeit = zeit; }
    }



