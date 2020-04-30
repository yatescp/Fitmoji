package com.example.yatesfitmoji;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class FitmojiRepository {

    private UserDao userDao;
    private WorkoutDao workoutDao;
    private DietDao dietDao;
    //private LiveData<List<User>> mAllUsers;
    private User user;

    private String name;

    FitmojiRepository(Application application) {

        FitmojiDataBase db = FitmojiDataBase.getDatabase(application);
        userDao = db.userDao();
        dietDao = db.dietDao();
        workoutDao = db.workoutDao();
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

    public List<User> findUsersByName(String name){
        return userDao.findUsersByName(name);
    }

    public void insertWorkout(Workout workout){workoutDao.insert(workout);}
    public LiveData<List<Workout>> getAllWorkouts(){
        return workoutDao.getAllWorkouts();
    }
    public LiveData<Workout> getWorkoutByDate(String dateKey) {return workoutDao.getWorkoutByDate(dateKey);}
    public LiveData<Integer> getCrunches(String dateKey) {return workoutDao.getCrunches(dateKey);}
    public LiveData<Integer> getPushups(String dateKey){return workoutDao.getPushups(dateKey);}
    public LiveData<Integer> getPlanks(String dateKey) {return workoutDao.getPlanks(dateKey);}

    public void insertDiet(Diet diet){dietDao.insert(diet);}
    public LiveData<List<Diet>> getAllDiets(){return dietDao.getAllDiets();}
    public LiveData<Diet> getDietByDate(String dateKey){return dietDao.getDietByDate(dateKey);}
    public LiveData<Integer> getCarbs(String dateKey){return dietDao.getCarbs(dateKey);}
    public LiveData<Integer> getProteins(String dateKey){return dietDao.getProtein(dateKey);}
    public LiveData<Integer> getFats(String dateKey){return dietDao.getFat(dateKey);}

}
