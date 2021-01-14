package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Kunde;

@Entity(tableName = "kunde",
        foreignKeys = {
                @ForeignKey(entity = PersonEntity.class,
                        parentColumns = "personID",
                        childColumns = "personID",
                        onDelete = ForeignKey.CASCADE)})
public class KundenEntity implements Kunde {

    @PrimaryKey(autoGenerate = true)
    private int kundenID;

    private String name;
    private String typ;
    private int personID;


    public KundenEntity() {
    }

    @Ignore
    public KundenEntity(int kundenID, String name, String typ, int personID) {

        this.kundenID = kundenID;
        this.name = name;
        this.typ = typ;
        this.personID = personID;
    }

    @Ignore
    public KundenEntity(String name, String typ, int personID) {

        this.name = name;
        this.typ = typ;
        this.personID = personID;
    }

    @Ignore
    public KundenEntity(Kunde kunde) {

        this.kundenID = kunde.getPersonID();
        this.name = kunde.getName();
        this.typ = kunde.getTyp();
        this.personID = kunde.getPersonID();
    }



    @Override
    public int getKundenID() {
        return kundenID;
    }

    @Override
    public int getPersonID() {
        return personID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTyp() {
        return typ;
    }




    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKundenID(int kundenID) {
        this.kundenID = kundenID;
    }
}

