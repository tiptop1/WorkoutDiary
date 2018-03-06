package com.tiptop.workoutdiary.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tiptop.workoutdiary.db.entity.Place;

import java.util.List;

/**
 * Created by tiptop on 24.01.18.
 */

@Dao
public interface PlacesDao {

    @Query("SELECT * FROM places")
    LiveData<List<Place>> getAll();

    @Query("SELECT * FROM places WHERE name = :name")
    LiveData<Place> findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPlace(Place place);
}
