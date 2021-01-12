package com.example.android.persistence.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;

import java.util.List;
@Dao
public interface AdressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<AdressEntity> adress);
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(AdressEntity adress);
    @Delete
    void delete(AdressEntity adress);
    @Update
    void update(AdressEntity adress);
    @Query("SELECT * FROM adresse ")
    List<AdressEntity> getAllAdress();
}
