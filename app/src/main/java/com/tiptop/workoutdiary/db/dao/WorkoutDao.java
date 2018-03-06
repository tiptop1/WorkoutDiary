package com.tiptop.workoutdiary.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.tiptop.workoutdiary.db.entity.Workout;

import java.util.List;

/**
 * Created by tiptop on 06.03.18.
 */

@Dao
public interface WorkoutDao {

    @Query("SELECT * FROM workouts")
    LiveData<List<Workout>> getAll();

}
