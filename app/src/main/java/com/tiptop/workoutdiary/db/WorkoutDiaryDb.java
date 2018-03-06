package com.tiptop.workoutdiary.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tiptop.workoutdiary.db.dao.PlacesDao;
import com.tiptop.workoutdiary.db.dao.WorkoutDao;
import com.tiptop.workoutdiary.db.entity.Place;
import com.tiptop.workoutdiary.db.entity.Workout;

/**
 * Created by tiptop on 24.01.18.
 */

@Database(entities = {Place.class, Workout.class}, exportSchema = false, version = 1)
public abstract class WorkoutDiaryDb extends RoomDatabase {
    public abstract PlacesDao placesDao();
    public abstract WorkoutDao workoutDao();
}
