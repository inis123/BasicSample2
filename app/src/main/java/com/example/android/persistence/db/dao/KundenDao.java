package com.example.android.persistence.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.persistence.db.entity.KundenEntity;
import com.example.android.persistence.db.entity.PersonEntity;


import java.util.List;

@Dao
public interface KundenDao {

        @Query("SELECT * FROM kunde")
        LiveData<List<KundenEntity>> loadAllKunden();

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<KundenEntity> kunden);

        @Delete
        void delete(KundenEntity kunde);

        @Query("SELECT * FROM person p  WHERE EXISTS(SELECT * FROM kunde k WHERE p.personID==k.personID) ")
        PersonEntity getPerson(KundenEntity kunde);

};
