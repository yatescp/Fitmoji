package com.example.yatesfitmoji;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WorkoutDao {
    @Query("SELECT * FROM Workouts")
    LiveData<List<Workout>> getAllWorkouts();

    @Query("SELECT * FROM Workouts WHERE name = :nameKey LIMIT 1")
    LiveData<Workout> getWorkout(String nameKey);

    @Query("SELECT pushups FROM Workouts WHERE name = :nameKey LIMIT 1")
    LiveData<Workout> getPushups(String nameKey);

    @Query("SELECT crunches FROM Workouts WHERE name = :nameKey LIMIT 1")
    LiveData<Workout> getCrunches(String nameKey);

    @Query("SELECT plank FROM Workouts WHERE name = :nameKey LIMIT 1")
    LiveData<Workout> getPlanks(String nameKey);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Workout workout);

    @Query("DELETE FROM Workouts")
    void deleteWorkouts();

    @Delete
    void delete(Workout workout);




}
