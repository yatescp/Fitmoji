package com.example.yatesfitmoji;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DietDao {

    @Query("SELECT * FROM Diets")
    LiveData<List<Diet>> getAllDiets();

    @Query("SELECT * FROM Diets WHERE date = :dateKey LIMIT 1")
    LiveData<Diet> getDietByDate(String dateKey);

    @Query("SELECT carbs FROM Diets WHERE date = :dateKey LIMIT 1")
    LiveData<Integer> getCarbs(String dateKey);

    @Query("SELECT protein FROM Diets WHERE date = :dateKey LIMIT 1")
    LiveData<Integer> getProtein(String dateKey);

    @Query("SELECT fat FROM Diets WHERE date = :dateKey LIMIT 1")
    LiveData<Integer> getFat(String dateKey);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Diet diet);

    @Query("DELETE FROM Diets")
    void deleteDiet();

    @Delete
    void delete(Diet diet);
}
