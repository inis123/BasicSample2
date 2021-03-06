package com.example.android.persistence.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android.persistence.db.entity.KundenEntity;
import com.example.android.persistence.db.entity.PersonEntity;


import java.util.List;

@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<PersonEntity> persons);
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(PersonEntity person);
    @Delete
    void Delete(PersonEntity persons);
    @Insert
    void deleteAll(List<PersonEntity> persons);
    @Update
    void update(PersonEntity person);
    @Update
    void updateAll(List<PersonEntity> person);



};
