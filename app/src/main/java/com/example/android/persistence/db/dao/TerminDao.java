package com.example.android.persistence.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.db.entity.TerminEntity;

import java.util.List;

@Dao
public interface TerminDao {
    @Query("SELECT * FROM termin")
    LiveData<List<TerminEntity>> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<TerminEntity> termin);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(TerminEntity termin);
    @Delete
    void delete(TerminEntity termin);

    @Query("SELECT * FROM person p  WHERE EXISTS(SELECT * FROM termin i WHERE p.personID==i.personID) ")
    PersonEntity getPerson(TerminEntity termin);
}
