package com.example.android.persistence.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.persistence.db.entity.FavoritenEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.db.entity.VertragEntity;

import java.util.List;

public interface FavoritenDao {
    @Query("SELECT * FROM favoriten")
    LiveData<List<FavoritenEntity>> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<FavoritenEntity> favoriten);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(FavoritenEntity favoriten);
    @Delete
    void delete(FavoritenEntity favoriten);


}
