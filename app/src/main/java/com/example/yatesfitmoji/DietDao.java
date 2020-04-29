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

    @Query("SELECT * FROM Diets WHERE name = :nameKey LIMIT 1")
    LiveData<Diet> getDiet(String nameKey);

    @Query("SELECT carbs FROM Diets WHERE name = :nameKey LIMIT 1")
    LiveData<Diet> getCarbs(String nameKey);

    @Query("SELECT protein FROM Diets WHERE name = :nameKey LIMIT 1")
    LiveData<Diet> getPrptein(String nameKey);

    @Query("SELECT fat FROM Diets WHERE name = :nameKey LIMIT 1")
    LiveData<Diet> getFat(String nameKey);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Diet diet);

    @Query("DELETE FROM Diets")
    void deleteDiet();

    @Delete
    void delete(Diet diet);
}
