package com.example.android.persistence.db.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.persistence.db.entity.VertragEntity;

import java.util.List;
@Dao
public interface VertragDao {

    @Query("SELECT * FROM vertrag")
    List<VertragEntity> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<VertragEntity> vertrag);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(VertragEntity vertrag);

    @Delete
    void delete(VertragEntity vertrag);


}

