package com.example.yatesfitmoji;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import java.util.List;

public class FitmojiRepository {

    private UserDao userDao;
    //private LiveData<List<User>> mAllUsers;
    private User user;

    private String name;

    FitmojiRepository(Application application) {

        FitmojiDataBase db = FitmojiDataBase.getDatabase(application);
        userDao = db.userDao();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    //LiveData<List<Word>> getAllWords() {
    //    return mAllWords;
    //}

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insertUser(User user) {
        FitmojiDataBase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }

    LiveData<User> getUserByName(String name){
        return userDao.getUser(name);
    }
}
