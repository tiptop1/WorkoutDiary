package com.tiptop.workoutdiary.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tiptop.workoutdiary.db.dao.PlacesDao;
import com.tiptop.workoutdiary.db.entity.Place;

/**
 * Created by tiptop on 24.01.18.
 */

@Database(version = 1, entities = {Place.class})
public abstract class WorkoutDiaryDb extends RoomDatabase {
    public abstract PlacesDao placesDao();
}
