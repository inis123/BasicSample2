
package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Aktivitaet;


@Entity(tableName = "aktivitaet",
        foreignKeys = {
                @ForeignKey(entity = PersonEntity.class,
                        parentColumns = "personID",
                        childColumns = "personID",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = MitarbeiterEntity.class,
                        parentColumns = "mitarbeiterNr",
                        childColumns = "mitarbeiterNr",
                        onDelete = ForeignKey.CASCADE)})
public class AktivitaetEntity implements Aktivitaet {

    @PrimaryKey(autoGenerate = true)
    private int aktNr;

    private int personID;
    private int mitarbeiterNr;
    private String typ;
    private String notiz;
    private boolean status;         //true =>erledigt
    private long frist;             //Typeconverter auf date


    public AktivitaetEntity() {
    }

    @Ignore
    public AktivitaetEntity(int aktNr, int personID, int MitarbeiterNr, String typ, String notiz, boolean status, long frist) {

        this.aktNr = aktNr;
        this.personID = personID;
        this.mitarbeiterNr = MitarbeiterNr;
        this.typ = typ;
        this.status = status;
        this.frist = frist;
        this.notiz = notiz;
    }

    @Ignore
    public AktivitaetEntity(int personID, int MitarbeiterNr, String typ, String notiz, boolean status, long frist) {

        this.aktNr = aktNr;
        this.personID = personID;
        this.mitarbeiterNr = MitarbeiterNr;
        this.typ = typ;
        this.status = status;
        this.frist = frist;
        this.notiz = notiz;
    }
    @Ignore
    public AktivitaetEntity(Aktivitaet aktivitaet) {

        this.aktNr = aktivitaet.getAktNr();
        this.personID = aktivitaet.getPersonID();
        this.mitarbeiterNr = aktivitaet.getMitarbeiterNr();
        this.typ = aktivitaet.getTyp();
        this.status = aktivitaet.getStatus();
        this.frist = aktivitaet.getFrist();
        this.notiz = getNotiz();

    }


    @Override
    public long getFrist() {
        return frist;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public String getTyp() {
        return typ;
    }

    @Override
    public int getMitarbeiterNr() {
        return mitarbeiterNr;
    }

    @Override
    public int getPersonID() {
        return personID;
    }

    @Override
    public int getAktNr() {
        return aktNr;
    }

    @Override
    public String getNotiz() {
        return notiz;
    }



    public void setAktNr(int aktNr) {
        this.aktNr = aktNr;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setMitarbeiterNr(int mitarbeiterNr) {
        this.mitarbeiterNr = mitarbeiterNr;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setFrist(long frist) {
        this.frist = frist;
    }
}
