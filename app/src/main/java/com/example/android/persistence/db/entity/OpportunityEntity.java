package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Opportunity;
@Entity(tableName = "opportunity",
        foreignKeys = {
                @ForeignKey(entity = InteressentEntity.class,
                        parentColumns = "interessentID",
                        childColumns = "interessentID",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = InteressentEntity.class,
                        parentColumns = "mitarbeiterNr",
                        childColumns = "mitarbeiterNr",
                        onDelete = ForeignKey.CASCADE)})
public class OpportunityEntity implements Opportunity {
    @PrimaryKey(autoGenerate = true)
    private int oppNR;

    private int interessentID;
    private int mitarbeiterNr;
    private int geschaetzterWert;
    private long zeitrahmen;
    private String notiz;
    private String status;

    public OpportunityEntity() {
    }

    public OpportunityEntity(int geschaetzterWert, long zeitrahmen, String notiz, String status,int interessentID) {
        this.geschaetzterWert = geschaetzterWert;
        this.zeitrahmen = zeitrahmen;
        this.notiz = notiz;
        this.status = status;
        this.interessentID = interessentID;
    }

    public OpportunityEntity(int oppNR, int geschaetzterWert, long zeitrahmen, String notiz, String status,int interessentID) {
        this.oppNR = oppNR;
        this.geschaetzterWert = geschaetzterWert;
        this.zeitrahmen = zeitrahmen;
        this.notiz = notiz;
        this.status = status;
    }
    public OpportunityEntity(Opportunity opp) {
        this.oppNR = opp.getOppNR();
        this.geschaetzterWert = opp.getGeschaetzterWert();
        this.zeitrahmen = opp.getZeitrahmen();
        this.notiz = opp.getNotiz();
        this.status = opp.getStatus();
        this.interessentID =opp.getInteressentID();
    }

    @Override
    public int getOppNR() {
        return oppNR;
    }

    @Override
    public int getGeschaetzterWert() {
        return geschaetzterWert;
    }

    @Override
    public long getZeitrahmen() {
        return zeitrahmen;
    }

    @Override
    public String getNotiz() {
        return notiz;
    }

    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public int getInteressentID() {
        return interessentID;
    }
}
