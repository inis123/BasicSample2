package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Adresse;








    @Entity(tableName = "adresse",
            foreignKeys = {
            @ForeignKey(entity = PersonEntity.class,
                    parentColumns = "personID",
                    childColumns = "personID",
                    onDelete = ForeignKey.CASCADE)})


    public class AdressEntity implements Adresse {

        @PrimaryKey(autoGenerate = true)
        private int adressID;
        private int personID;
        private String Ort;
        private String Strasse;
        private String Hausnummer;
        private String Land;
        private String plz;
        private String mTelNr;
        private String telNr;

        public AdressEntity() {
        }

        @Ignore
            public AdressEntity(int adressID, int personID, String ort, String strasse, String hausnummer, String land, String plz, String mTelNr, String telNr) {
            this.adressID = adressID;
            this.personID = personID;
            Ort = ort;
            Strasse = strasse;
            Hausnummer = hausnummer;
            Land = land;
            this.plz = plz;
            this.mTelNr = mTelNr;
            this.telNr = telNr;
        }
        @Ignore
        public AdressEntity(int personID, String ort, String strasse, String hausnummer, String land, String plz, String mTelNr, String telNr) {
            this.personID = personID;
            Ort = ort;
            Strasse = strasse;
            Hausnummer = hausnummer;
            Land = land;
            this.plz = plz;
            this.mTelNr = mTelNr;
            this.telNr = telNr;
        }
        @Ignore
        public AdressEntity( String ort, String strasse, String hausnummer, String land, String plz, String mTelNr, String telNr) {

            Ort = ort;
            Strasse = strasse;
            Hausnummer = hausnummer;
            Land = land;
            this.plz = plz;
            this.mTelNr = mTelNr;
            this.telNr = telNr;
        }



        @Ignore
        public AdressEntity(Adresse adresse) {
            this.adressID = adresse.getAdressId();
            this.Ort= adresse.getOrt();
            this.Strasse=adresse.getStrasse();
            this.Hausnummer = adresse.getHausnummer();
            this.Land = adresse.getLand();
            this.plz=adresse.getPlz();
            this.personID=adresse.getPersonID();

        }
        @Override
        public String getmTelNr() {
            return mTelNr;
        }
        @Override
        public String getTelNr() {
            return telNr;
        }

        @Override
        public int getAdressId() {
            return adressID;
        }

        @Override
        public String getPlz() {
            return plz;
        }

        @Override
        public String getLand() {
            return Land;
        }
        @Override
        public int getPersonID() {
            return personID;
        }

        @Override
        public String getHausnummer() {
            return Hausnummer;
        }

        @Override
        public String getStrasse() {
            return Strasse;
        }

        @Override
        public String getOrt() {
            return Ort;
        }

        @Override
        public int getAdressID() {
            return adressID;
        }

        public void setAdressID(int adressID) {
            this.adressID = adressID;
        }

        public void setPersonID(int personID) {
            this.personID = personID;
        }

        public void setOrt(String ort) {
            Ort = ort;
        }

        public void setStrasse(String strasse) {
            Strasse = strasse;
        }

        public void setHausnummer(String hausnummer) {
            Hausnummer = hausnummer;
        }

        public void setLand(String land) {
            Land = land;
        }

        public void setPlz(String plz) {
            this.plz = plz;
        }

        public void setmTelNr(String mTelNr) {
            this.mTelNr = mTelNr;
        }

        public void setTelNr(String telNr) {
            this.telNr = telNr;
        }
    }



