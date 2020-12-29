package com.example.android.persistence.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;

import java.util.List;

@Dao
public interface InteressentDao {
    @Query("SELECT * FROM interessent")
    LiveData<List<InteressentEntity>> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<InteressentEntity> interessenten);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(InteressentEntity interessent);
    @Delete
    void delete(InteressentEntity interessent);

    @Query("SELECT * FROM person p  WHERE EXISTS(SELECT * FROM interessent i WHERE p.personID==i.personID) ")
    PersonEntity getPerson(InteressentEntity interessent);
}
