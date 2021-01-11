package com.example.android.persistence.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android.persistence.db.entity.KundenEntity;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;


import java.util.List;

@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<PersonEntity> persons);
    @Insert(onConflict = OnConflictStrategy.ABORT)
    int insert(PersonEntity person);
    @Delete
    void Delete(PersonEntity persons);
    @Insert
    void deleteAll(List<PersonEntity> persons);
    @Update
    void update(PersonEntity person);
    @Update
    void updateAll(List<PersonEntity> person);
    @Query("SELECT m.password,m.personID,m.mitarbeiterNr FROM person p, mitarbeiter m WHERE (p.personID==m.personID AND p.name == :name) ")
    List<MitarbeiterEntity> getMitarbeiterbyName(String name);
    @Query("SELECT * FROM person p WHERE p.name=:name")
    List<PersonEntity> getByName(String name);
    @Query("SELECT * FROM person")
    List<PersonEntity> getAll();


};
