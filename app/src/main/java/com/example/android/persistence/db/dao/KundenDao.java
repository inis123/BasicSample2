package com.example.android.persistence.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.persistence.db.entity.KundenEntity;


import java.util.List;

@Dao
public interface KundenDao {

        @Query("SELECT * FROM kunden")
        LiveData<List<KundenEntity>> loadAllKunden();

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<KundenEntity> kunden);


};
