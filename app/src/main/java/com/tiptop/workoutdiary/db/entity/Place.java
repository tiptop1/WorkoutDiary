package com.tiptop.workoutdiary.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by tiptop on 24.01.18.
 */

@Entity(tableName = "places", indices={@Index(value="name", unique=true)})
public class Place {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    @NonNull
    public String name;

    @ColumnInfo
    public String description;
}
