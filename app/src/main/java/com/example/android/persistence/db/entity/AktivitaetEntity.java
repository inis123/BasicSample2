
    package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.model.Aktivitaet;








    @Entity(tableName = "aktivitaet")
    public class AktivitaetEntity implements Aktivitaet {

        @PrimaryKey(autoGenerate = true)
        private int aktNr;
        private int kundenNr;
        private int MitarbeiterNr;
        private String typ;
        private String notiz;
        private boolean status;
        private long frist;             //Typeconverter auf date


        public AktivitaetEntity() {
        }

        @Ignore
        public AktivitaetEntity(  int aktNr,int kundenNr,int MitarbeiterNr,String typ,String notiz, boolean status, long frist ) {
            this.aktNr = aktNr;
            this.kundenNr = kundenNr;
            this.MitarbeiterNr = MitarbeiterNr;
            this.typ = typ;
            this.status=status;
            this.frist=frist;
        }

        public AktivitaetEntity(Aktivitaet aktivitaet) {
            this.aktNr = aktivitaet.aktNr();
            this.kundenNr= aktivitaet.kundenNr();
            this.MitarbeiterNr=aktivitaet.MitarbeiterNr();
            this.typ = aktivitaet.typ();
            this.status = aktivitaet.status();
            this.frist=aktivitaet.frist();

        }


        @Override
        public long frist() {
            return frist;
        }

        @Override
        public boolean status() {
            return status;
        }

        @Override
        public String typ() {
            return typ;
        }

        @Override
        public int MitarbeiterNr() {
            return MitarbeiterNr;
        }

        @Override
        public int kundenNr() {
            return kundenNr;
        }

        @Override
        public int aktNr() {
            return aktNr;
        }
    }
