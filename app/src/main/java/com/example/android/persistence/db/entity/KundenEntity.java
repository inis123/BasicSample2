package com.example.android.persistence.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.android.persistence.db.dao.KundenDao;
import com.example.android.persistence.model.Kunde;
import com.example.android.persistence.model.Product;

@Entity(tableName = "kunden")
public class KundenEntity implements Kunde {

       @PrimaryKey(autoGenerate = true)
        private int id;
        private String name;
        private String nachname;
        private int alter;

        @Override
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public KundenEntity() {
        }

        @Ignore
        public KundenEntity(int id, String name, String description, int price) {
            this.id = id;
            this.name = name;
            this.nachname = description;
            this.alter = price;
        }

        public KundenEntity(Product product) {
            this.id = product.getId();
            this.name = product.getName();
            this.nachname = product.getDescription();
            this.alter = product.getPrice();
        }
    }

