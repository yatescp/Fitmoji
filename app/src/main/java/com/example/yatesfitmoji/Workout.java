package com.example.yatesfitmoji;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import com.example.yatesfitmoji.User;

@Entity(tableName = "Workouts")

public class Workout {
    @NonNull
    @PrimaryKey
    private String name;

    @NonNull
    @ColumnInfo(name = "pushups")
    private int pushups;

    @NonNull
    @ColumnInfo(name = "crunches")
    private int crunches;

    @NonNull
    @ColumnInfo(name = "plank")
    private int plank;

    public Workout(@NonNull String name, @NonNull int pushups, @NonNull int crunches, @NonNull int plankTime){
        this.name = name;
        this.crunches = crunches;
        this.pushups = pushups;
        this.plank = plank;
    }

    @NonNull public String getName(){return name;}

    @NonNull public int getPushups(){return pushups;}

    @NonNull public int getCrunches(){return crunches;}

    @NonNull public int getPlank(){return plank;}

    public void setPushups(@NonNull int pushups){this.pushups = pushups;}

    public void setCrunches(@NonNull int crunches){this.crunches = crunches;}

    public void setPlank(@NonNull int plank){this.plank = plank;}


}
