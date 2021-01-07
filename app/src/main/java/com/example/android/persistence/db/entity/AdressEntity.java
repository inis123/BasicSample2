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
        private String Strassennummer;
        private String Land;
        private String plz;


        public AdressEntity() {
        }

        @Ignore
        public AdressEntity( int adressID, String Ort, String Strasse,  String Strassennummer, String Land,String plz,int personID) {
            this.adressID = adressID;
            this.Ort = Ort;
            this.Strasse = Strasse;
            this.Strassennummer = Strassennummer;
            this.Land=Land;
            this.plz=plz;
            this.personID=personID;
        }

        public AdressEntity(Adresse adresse) {
            this.adressID = adresse.getAdressId();
            this.Ort= adresse.getOrt();
            this.Strasse=adresse.getStrasse();
            this.Strassennummer = adresse.getStrassennummer();
            this.Land = adresse.getLand();
            this.plz=adresse.getPlz();
            this.personID=adresse.getPersonID();

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
        public String getStrassennummer() {
            return Strassennummer;
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

        public void setStrassennummer(String strassennummer) {
            Strassennummer = strassennummer;
        }

        public void setLand(String land) {
            Land = land;
        }

        public void setPlz(String plz) {
            this.plz = plz;
        }

    }



