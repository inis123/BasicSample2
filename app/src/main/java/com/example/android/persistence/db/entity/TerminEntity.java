package com.example.android.persistence.db.entity;

import androidx.room.Entity;
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

    @Entity(tableName = "termin")
    public class TerminEntity implements Termin {

        @PrimaryKey(autoGenerate = true)
        private int personID;
        private String name;
        private String nachname;
        private int alter;
        private int adressID;



        public TerminEntity() {
        }

        @Ignore
        public TerminEntity(int id, String name, String nachname, int alter,int adressID) {
            this.personID = id;
            this.name = name;
            this.nachname = nachname;
            this.alter = alter;
            this.adressID=adressID;
        }

        public TerminEntity(Person person) {
            this.personID = person.getPersonId();
            this.name = person.getName();
            this.nachname = person.getNachname();
            this.alter = person.getAlter();
        }
    }


