package com.example.yatesfitmoji;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class FitmojiViewModel extends AndroidViewModel {

    private FitmojiRepository repository;

    public FitmojiViewModel(Application application) {
        super(application);
        repository = new FitmojiRepository(application);
    }

    void insertUser(User user){
        repository.insertUser(user);
    }

    LiveData<User> getUserByName(String name){
        return repository.getUserByName(name);
    }

}
