package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
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
        private int InteressentID;


        private String notiz;
        private String Stellung;
        private int personID;
        public InteressentEntity(){}


        public InteressentEntity(int InteressentID, String notiz, String Stellung, int personID) {
            this.InteressentID = InteressentID;
            this.notiz = notiz;
            this.Stellung = Stellung;
            this.personID=personID;
        }

        public InteressentEntity(String notiz, String Stellung, int personID) {
            this.notiz = notiz;
            this.Stellung = Stellung;
            this.personID=personID;
        }

        public InteressentEntity(Interessent Interessent) {
            this.InteressentID = Interessent.getInteressentID();
            this.notiz = Interessent.getNotiz();
            this.Stellung = getStellung();
            this.personID=getPersonID();
        }
        @Override
        public int getInteressentID() {
            return InteressentID;
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
    }
