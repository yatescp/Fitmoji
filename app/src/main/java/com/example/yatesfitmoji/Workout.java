package com.example.yatesfitmoji;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Workouts")

public class Workout {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "date")
    private String date;

    @NonNull
    @ColumnInfo(name = "pushups")
    private int pushups;

    @NonNull
    @ColumnInfo(name = "crunches")
    private int crunches;

    @NonNull
    @ColumnInfo(name = "plank")
    private int plank;

    public Workout(@NonNull String name, @NonNull int pushups, @NonNull int crunches, @NonNull int plank, @NonNull String date){
        this.name = name;
        this.date = date;
        this.crunches = crunches;
        this.pushups = pushups;
        this.plank = plank;
    }

    @NonNull public String getName(){return name;}

    @NonNull public int getPushups(){return pushups;}

    @NonNull public int getCrunches(){return crunches;}

    @NonNull public int getPlank(){return plank;}

    @NonNull public String getDate(){return date;}

    public void setName(@NonNull String name){this.name = name;}

    public void setPushups(@NonNull int pushups){this.pushups = pushups;}

    public void setCrunches(@NonNull int crunches){this.crunches = crunches;}

    public void setPlank(@NonNull int plank){this.plank = plank;}

    public void setDate(@NonNull String date){this.date = date;}


}
