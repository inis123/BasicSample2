package com.example.android.persistence.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Person;

@Entity(tableName = "person")
public class PersonEntity implements Person {

    @PrimaryKey(autoGenerate = true)
    private int personID;
    @ColumnInfo(name="name")
    private String name;
    @ColumnInfo(name="nachname")
    private String nachname;
    @ColumnInfo(name="alter")
    private int alter;
    @ColumnInfo(name="adressID")
    private int adressID;





    public PersonEntity() {
    }

    @Ignore
    public PersonEntity(int id, String name, String nachname, int alter,int adressID) {
        this.personID = id;
        this.name = name;
        this.nachname = nachname;
        this.alter = alter;
        this.adressID=adressID;
    }
    @Ignore
    public PersonEntity( String name, String nachname, int alter,int adressID) {

        this.name = name;
        this.nachname = nachname;
        this.alter = alter;
        this.adressID=adressID;
    }
    @Ignore
    public PersonEntity(Person person) {
        this.personID = person.getPersonId();
        this.name = person.getName();
        this.nachname = person.getNachname();
        this.alter = person.getAlter();
    }




    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getPersonId() {
        return personID;
    }
    @Override
    public String getNachname() {
        return nachname;
    }
    @Override
    public int getAlter() {
        return alter;
    }
    @Override
    public int getPersonID() {
        return personID;
    }
    @Override
    public int getAdressID() {
        return adressID;
    }

    public void setId(int id) {
        this.personID = id;
    }
    public void setAlter(int alter) {
        this.alter = alter;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }
}
