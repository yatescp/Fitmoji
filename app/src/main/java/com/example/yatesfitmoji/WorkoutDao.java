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

    @Query("SELECT * FROM Workouts WHERE date = :dateKey LIMIT 1")
    LiveData<Workout> getWorkoutByDate(String dateKey);

    @Query("SELECT pushups FROM Workouts WHERE date = :dateKey LIMIT 1")
    LiveData<Integer> getPushups(String dateKey);

    @Query("SELECT crunches FROM Workouts WHERE date = :dateKey LIMIT 1")
    LiveData<Integer> getCrunches(String dateKey);

    @Query("SELECT plank FROM Workouts WHERE date = :dateKey LIMIT 1")
    LiveData<Integer> getPlanks(String dateKey);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Workout workout);

    @Query("DELETE FROM Workouts")
    void deleteWorkouts();

    @Delete
    void delete(Workout workout);




}
