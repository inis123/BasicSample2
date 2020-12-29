package com.example.android.persistence.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.example.android.persistence.db.entity.OpportunityEntity;
import com.example.android.persistence.db.entity.PersonEntity;

import java.util.List;

@Dao
public interface OpportiunityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<OpportunityEntity> opportunity);
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(OpportunityEntity opportunity);
    @Delete
    void delete(OpportunityEntity opportunity);
    @Update
    void update(OpportunityEntity opportunity);
    @Query("SELECT * FROM person p  WHERE EXISTS(SELECT * FROM opportunity o WHERE p.personID==o.interessentID) ")
    PersonEntity getPerson(OpportunityEntity opp);
}
