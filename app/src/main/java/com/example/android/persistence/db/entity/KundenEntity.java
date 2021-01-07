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
        private String nachname;
        private int alter;
        private int personID;



        public KundenEntity() {
        }

        @Ignore
        public KundenEntity(int kundenID, String name, String nachname, int price,int personID) {
            this.kundenID = kundenID;
            this.name = name;
            this.nachname = nachname;
            this.alter = price;
            this.personID=personID;
        }
        @Ignore
         public KundenEntity( String name, String nachname, int price,int personID) {
          this.name = name;
          this.nachname = nachname;
          this.alter = price;
          this.personID=personID;
        }

        public KundenEntity(Kunde kunde) {
            this.kundenID = kunde.getPersonID();
            this.name = kunde.getName();
            this.nachname = kunde.getNachname();
            this.alter = kunde.getAlter();
            this.personID=kunde.getPersonID();
        }
    @Override
    public int getKundenID() {
        return kundenID;
    }
    @Override
    public int getPersonID() {
        return personID;
    }

    public void setKundenID(int kundenID) {
        this.kundenID = kundenID;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }


    public void setPersonID(int personID) {
        this.personID = personID;
    }
}

