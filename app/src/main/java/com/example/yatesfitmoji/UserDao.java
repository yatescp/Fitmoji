package com.example.yatesfitmoji;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Users")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM Users WHERE name = :nameKey LIMIT 1")
    LiveData<User> getUser(String nameKey);

//    @Query("SELECT * FROM Users WHERE name = :ageKey LIMIT 1")
//    LiveData<User> getAge(String ageKey);
//
//    @Query("SELECT * FROM Users WHERE name = :sexKey LIMIT 1")

    //For populating log in search list
    @Query("SELECT * FROM Users WHERE name LIKE :search")
    List<User> findUsersByName(String search);

    //    LiveData<User> getSex(String sexKey);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("DELETE FROM Users")
    void deleteAll();

    @Delete
    void delete(User Users);
}
