package com.example.yatesfitmoji;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "Users")

public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;


    @ColumnInfo(name = "startingWeight")
    private float startingWeight;


    @ColumnInfo(name = "goalWeight")
    private float goalWeight;

    //Reason for using the app, using string instead of enum to make things easy
    //Should only be set to "Lose Weight", "Gain Weight", or "Stay in Shape"
    //This field will be used in a switch that will default to "Stay in Shape" in case of invalid Strings
    @NonNull
    @ColumnInfo(name = "reason")
    private String reason;

    //Constructor
    public User(@NonNull String name, float startingWeight,  float goalWeight, @NonNull String reason){
        this.name = name;
        this.startingWeight = startingWeight;
        this.goalWeight = goalWeight;
        this.reason = reason;

    }

    @NonNull
    public String getName(){
        return name;
    }

    public float getStartingWeight(){
        return startingWeight;
    }

    public float getGoalWeight(){
        return goalWeight;
    }

    @NonNull
    public String getReason(){
        return reason;
    }
}
