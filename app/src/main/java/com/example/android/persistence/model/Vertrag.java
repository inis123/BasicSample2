package com.example.android.persistence.model;

public interface Vertrag {

    public int getVertragsNR();

    public int getMitarbeiterNr();

    public int getKundenID();

    public long getAbschlussdatum();

    public String getVertragsinhalt();

    public int getPreis(); // in cent

    public String getErfuellungsdatum();

    public String getStatus();
}
