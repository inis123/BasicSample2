package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Interessent;


    @Entity(tableName = "interessent",
            foreignKeys = {
                    @ForeignKey(entity = PersonEntity.class,
                            parentColumns = "personID",
                            childColumns = "personID",
                            onDelete = ForeignKey.CASCADE)})
    public class InteressentEntity implements Interessent {

        @PrimaryKey(autoGenerate = true)
        private int interessentID;


        private String notiz;
        private String Stellung;
        private int personID;
        public InteressentEntity(){}


        public InteressentEntity(int interessentID, String notiz, String Stellung, int personID) {
            this.interessentID = interessentID;
            this.notiz = notiz;
            this.Stellung = Stellung;
            this.personID=personID;
        }

        public InteressentEntity(String notiz, String Stellung, int personID) {
            this.notiz = notiz;
            this.Stellung = Stellung;
            this.personID=personID;
        }

        public InteressentEntity(Interessent interessent) {
            this.interessentID = interessent.getInteressentID();
            this.notiz = interessent.getNotiz();
            this.Stellung = interessent.getStellung();
            this.personID=interessent.getPersonID();
        }
        @Override
        public int getInteressentID() {
            return interessentID;
        }
        @Override
        public String getNotiz() {
            return notiz;
        }
        @Override
        public String getStellung() {
            return Stellung;
        }
        @Override
        public int getPersonID() {
            return personID;
        }

        public void setInteressentID(int interessentID) {
            this.interessentID = interessentID;
        }

        public void setNotiz(String notiz) {
            this.notiz = notiz;
        }

        public void setStellung(String stellung) {
            Stellung = stellung;
        }

        public void setPersonID(int personID) {
            this.personID = personID;
        }
    }
