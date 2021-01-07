package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Vertrag;

@Entity(tableName = "vertrag",
        foreignKeys = {
                @ForeignKey(entity = MitarbeiterEntity.class,
                        parentColumns = "mitarbeiterNr",
                        childColumns = "mitarbeiterNr",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = KundenEntity.class,
                        parentColumns = "kundenID",
                        childColumns = "kundenID",
                        onDelete = ForeignKey.CASCADE)})
public class VertragEntity implements Vertrag {
    @PrimaryKey
    private int vertragsNR;

    private int mitarbeiterNr;
    private int kundenID;
    private long abschlussdatum;
    private String vertragsinhalt;
    private int preis; // in cent
    private String erfuellungsdatum;
    private String status;

    public VertragEntity() {
    }

    public VertragEntity(int mitarbeiterNr, int kundenID, long abschlussdatum, String vertragsinhalt,
                         int preis, String erfuellungsdatum, String status) {
        this.mitarbeiterNr = mitarbeiterNr;
        this.kundenID = kundenID;
        this.abschlussdatum = abschlussdatum;
        this.vertragsinhalt = vertragsinhalt;
        this.preis = preis;
        this.erfuellungsdatum = erfuellungsdatum;
        this.status = status;
    }

    public VertragEntity(int vertragsNR, int mitarbeiterNr, int kundenID, long abschlussdatum,
                         String vertragsinhalt, int preis, String erfuellungsdatum, String status) {
        this.vertragsNR = vertragsNR;
        this.mitarbeiterNr = mitarbeiterNr;
        this.kundenID = kundenID;
        this.abschlussdatum = abschlussdatum;
        this.vertragsinhalt = vertragsinhalt;
        this.preis = preis;
        this.erfuellungsdatum = erfuellungsdatum;
        this.status = status;
    }
    public VertragEntity(VertragEntity vertrag) {
        this.vertragsNR = vertrag.getVertragsNR();
        this.mitarbeiterNr = vertrag.getMitarbeiterNr();
        this.kundenID = vertrag.getKundenID();
        this.abschlussdatum = vertrag.getAbschlussdatum();
        this.vertragsinhalt = vertrag.getVertragsinhalt();
        this.preis = vertrag.getPreis();
        this.erfuellungsdatum = vertrag.getErfuellungsdatum();
        this.status = vertrag.getStatus();
    }

    public int getVertragsNR() {
        return vertragsNR;
    }

    @Override
    public int getMitarbeiterNr() {
        return mitarbeiterNr;
    }

    @Override
    public int getKundenID() {
        return kundenID;
    }

    @Override
    public long getAbschlussdatum() {
        return abschlussdatum;
    }

    @Override
    public String getVertragsinhalt() {
        return vertragsinhalt;
    }

    @Override
    public int getPreis() {
        return preis;
    }

    @Override
    public String getErfuellungsdatum() {
        return erfuellungsdatum;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setVertragsNR(int vertragsNR) {
        this.vertragsNR = vertragsNR;
    }

    public void setMitarbeiterNr(int mitarbeiterNr) {
        this.mitarbeiterNr = mitarbeiterNr;
    }

    public void setKundenID(int kundenID) {
        this.kundenID = kundenID;
    }

    public void setAbschlussdatum(long abschlussdatum) {
        this.abschlussdatum = abschlussdatum;
    }

    public void setVertragsinhalt(String vertragsinhalt) {
        this.vertragsinhalt = vertragsinhalt;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setErfuellungsdatum(String erfuellungsdatum) {
        this.erfuellungsdatum = erfuellungsdatum;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
