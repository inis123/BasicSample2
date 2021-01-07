package com.example.android.persistence.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;

import java.util.List;

@Dao
public interface MitarbeiterDao {
    @Query("SELECT * FROM mitarbeiter")
    LiveData<List<MitarbeiterEntity>> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MitarbeiterEntity> mitarbeiter);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(MitarbeiterEntity mitarbeiter);
    @Delete
    void delete(MitarbeiterEntity mitarbeiter);

    @Query("SELECT * FROM person p  WHERE EXISTS(SELECT * FROM mitarbeiter m WHERE p.personID==m.personID) AND p.personID == :mitarbeiterPersonID ")
    LiveData<List<PersonEntity>> getPerson(int mitarbeiterPersonID);
}
