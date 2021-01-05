package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.model.Adresse;
import com.example.android.persistence.model.Favoriten;

@Entity(tableName = "favoriten",
        foreignKeys = {
                @ForeignKey(entity = MitarbeiterEntity.class,
                        parentColumns = "mitarbeiterNR",
                        childColumns = "mitarbeiterNR",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = KundenEntity.class,
                        parentColumns = "kundenID",
                        childColumns = "kundenID",
                        onDelete = ForeignKey.CASCADE)})


public class FavoritenEntity implements Favoriten {

    @PrimaryKey(autoGenerate = true)
    private int favID;
    private int mitarbeiterNR;
    private int kundenID;


    public FavoritenEntity() {
    }

    @Ignore
    public FavoritenEntity( int favID, int mitarbeiterNR, int kundenID ) {
        this.favID = favID;
        this.mitarbeiterNR = mitarbeiterNR;
        this.kundenID = kundenID;

    }

    public FavoritenEntity(Favoriten fav) {
        this.favID = fav.getFavID();
        this.mitarbeiterNR = fav.getMitarbeiterNR();
        this.kundenID = fav.getKundenID();

    }

    public int getFavID() {
        return favID;
    }

    public int getMitarbeiterNR() {
        return mitarbeiterNR;
    }

    public int getKundenID() {
        return kundenID;
    }
}



