package com.example.yatesfitmoji;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Diets")

public class Diet {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    @NonNull
    @ColumnInfo(name = "carbs")
    private int carbs;

    @NonNull
    @ColumnInfo(name = "protein")
    private int protein;

    @NonNull
    @ColumnInfo(name = "fat")
    private int fat;

    public Diet(@NonNull String date, @NonNull int carbs, @NonNull int protein, @NonNull int fat){
        this.date = date;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
    }

    @NonNull public String getDate(){return date;}

    @NonNull public int getCarbs(){return carbs;}

    @NonNull public int getProtein(){return protein;}

    @NonNull public int getFat(){return fat;}

    public void setCarbs(@NonNull int carbs){this.carbs = carbs;}

    public void setProtein(@NonNull int protein){this.protein = protein;}

    public void setFat(@NonNull int fat){this.fat = fat;}

    public void setDate(@NonNull String date){this.date = date;}
}
