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

    @NonNull
    @ColumnInfo(name = "age")
    private int age;

    @NonNull
    @ColumnInfo(name = "sex")
    private int sex;


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

    @NonNull
    public int getAge() {
        return age;
    }

    @NonNull
    public int getSex() {
        return sex;
    }

    public void setAge(@NonNull int age) {
        this.age = age;
    }

    public void setSex(@NonNull int sex) {
        this.sex = sex;
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
