package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Mitarbeiter;
import com.example.android.persistence.model.Vertrag;

@Entity(tableName = "vertrag",
        foreignKeys = {
                @ForeignKey(entity = MitarbeiterEntity.class,
                        parentColumns = "mitarbeiterNR",
                        childColumns = "mitarbeiterNR",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = KundenEntity.class,
                        parentColumns = "kundenID",
                        childColumns = "kundenID",
                        onDelete = ForeignKey.CASCADE)})
public class VertragEntity implements Vertrag {
    @PrimaryKey
    private int vertragsNR;

    private int mitarbeiterNR;
    private int kundenID;
    private long abschlussdatum;
    private String vertragsinhalt;
    private int preis; // in cent
    private String erfuellungsdatum;
    private String status;

    public VertragEntity() {
    }

    public VertragEntity(int mitarbeiterNR, int kundenID, long abschlussdatum, String vertragsinhalt,
                         int preis, String erfuellungsdatum, String status) {
        this.mitarbeiterNR = mitarbeiterNR;
        this.kundenID = kundenID;
        this.abschlussdatum = abschlussdatum;
        this.vertragsinhalt = vertragsinhalt;
        this.preis = preis;
        this.erfuellungsdatum = erfuellungsdatum;
        this.status = status;
    }

    public VertragEntity(int vertragsNR, int mitarbeiterNR, int kundenID, long abschlussdatum,
                         String vertragsinhalt, int preis, String erfuellungsdatum, String status) {
        this.vertragsNR = vertragsNR;
        this.mitarbeiterNR = mitarbeiterNR;
        this.kundenID = kundenID;
        this.abschlussdatum = abschlussdatum;
        this.vertragsinhalt = vertragsinhalt;
        this.preis = preis;
        this.erfuellungsdatum = erfuellungsdatum;
        this.status = status;
    }
    public VertragEntity(VertragEntity vertrag) {
        this.vertragsNR = vertrag.getVertragsNR();
        this.mitarbeiterNR = vertrag.getMitarbeiterNR();
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
    public int getMitarbeiterNR() {
        return mitarbeiterNR;
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
}
