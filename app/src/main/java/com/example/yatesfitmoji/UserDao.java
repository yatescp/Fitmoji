package com.example.yatesfitmoji;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * from Users")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM Users WHERE name = :nameKey LIMIT 1")
    LiveData<User> getUser(String nameKey);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("DELETE FROM Users")
    void deleteAll();

    @Delete
    void delete(User Users);
}
