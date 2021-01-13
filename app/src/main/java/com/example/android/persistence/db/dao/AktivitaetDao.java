package com.example.android.persistence.db.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.AktivitaetEntity;

import java.util.List;

public interface AktivitaetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<AktivitaetEntity> akt);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(AktivitaetEntity akt);
    @Delete
    void delete(AktivitaetEntity akt);
    @Update
    void update(AktivitaetEntity akt);
    @Query("SELECT * FROM aktivitaet ")
    List<AktivitaetEntity> getAllAktivitaet();
}
