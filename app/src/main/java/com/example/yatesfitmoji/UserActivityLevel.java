package com.example.yatesfitmoji;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivityLevel extends AppCompatActivity {

    RadioButton light, moderate, active, veryActive;
    float activityLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_activity_level);

        light = findViewById(R.id.radioButtonLight);
        moderate = findViewById(R.id.radioButtonModerate);
        active = findViewById(R.id.radioButtonActive);
        veryActive = findViewById(R.id.radioButtonVeryActive);

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityLevel = 1.2f;
                saveUserActivityLevel(activityLevel);
                openUserInfoFinished(v);
            }
        });

        moderate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityLevel = 1.375f;
                saveUserActivityLevel(activityLevel);
                openUserInfoFinished(v);
            }
        });

        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityLevel = 1.55f;
                saveUserActivityLevel(activityLevel);
                openUserInfoFinished(v);
            }
        });

        veryActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityLevel = 1.725f;
                saveUserActivityLevel(activityLevel);
                openUserInfoFinished(v);
            }
        });
    }

    public void saveUserActivityLevel(float activityLevel) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        sharedPreferences.edit().putString("userActivityLevel", String.valueOf(activityLevel)).apply();
    }

    public void openUserInfoFinished(View view){
        Intent intent = new Intent (this, UserDailyCalories.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
