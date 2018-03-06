package com.tiptop.workoutdiary.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by tiptop on 06.03.18.
 */

@Entity(tableName = "workouts",
        foreignKeys = @ForeignKey(entity = Place.class, parentColumns = "id",
                childColumns = "placeId", onDelete = CASCADE))
public class Workout {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public Date startDate;

    @ColumnInfo
    public Date endDate;

    @ColumnInfo
    public long placeId;
}
