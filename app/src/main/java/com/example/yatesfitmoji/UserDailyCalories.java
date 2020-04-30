package com.example.yatesfitmoji;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDailyCalories extends AppCompatActivity {

    TextView dailyCalorieText;

    String userHeight, userWeight, userAge, userSex, userActivityLevel, userReason;

    double resultCalories = 0;

    String calorieMsg;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);

        userInformation();

        dailyCalorieText = findViewById(R.id.caloriesId);
        next = findViewById(R.id.buttonContinue);

        if(userSex.equals("1")) {
            maleCalculations();
        } else if (userSex.equals("0")) {
            femaleCalculations();
        }
        calorieMsg = "To " + userReason + " eat " + resultCalories + " calories per day!";
        dailyCalorieText.setText(calorieMsg);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity(v);
            }
        });
    }

    public void maleCalculations() {
        if(userReason.equals("stay in shape")) {
            resultCalories = ((Double.parseDouble(userWeight) * 6.23)
                    + (Double.parseDouble(userHeight) * 12.7)
                    - (Double.parseDouble(userAge) * 6.8) + 66) * (Double.parseDouble(userActivityLevel));

        } else if(userReason.equals("lose weight")) {
            resultCalories = ((Double.parseDouble(userWeight) * 6.23)
                    + (Double.parseDouble(userHeight) * 12.7)
                    - (Double.parseDouble(userAge) * 6.8) + 66) * ((Double.parseDouble(userActivityLevel))) - 500;

        } else if(userReason.equals("gain weight")) {
            resultCalories = ((Double.parseDouble(userWeight) * 6.23)
                    + (Double.parseDouble(userHeight) * 12.7)
                    - (Double.parseDouble(userAge) * 6.8) + 66) * ((Double.parseDouble(userActivityLevel))) + 500;
        }
    }

    public void femaleCalculations() {
        if(userReason.equals("stay in shape")){
            resultCalories = ((Double.parseDouble(userWeight) * 4.35)
                    + (Double.parseDouble(userHeight) * 4.7)
                    - (Double.parseDouble(userAge) * 4.7) + 655) * (Double.parseDouble(userActivityLevel));

        } else if(userReason.equals("lose weight")) {
            resultCalories = ((Double.parseDouble(userWeight) * 4.35)
                    + (Double.parseDouble(userHeight) * 4.7)
                    - (Double.parseDouble(userAge) * 4.7) + 655) * ((Double.parseDouble(userActivityLevel))) - 500;

        } else if(userReason.equals("gain weight")) {
            resultCalories = ((Double.parseDouble(userWeight) * 4.35)
                    + (Double.parseDouble(userHeight) * 4.7)
                    - (Double.parseDouble(userAge) * 4.7 ) + 655) * ((Double.parseDouble(userActivityLevel))) + 500;
        }
    }

    protected void userInformation() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        //there only needs to be one temp its temporary
        userHeight = sharedPreferences.getString("userHeight","");
        userWeight = sharedPreferences.getString("userWeight","");
        userAge = sharedPreferences.getString("userAge","");
        userSex = sharedPreferences.getString("userSex","");
        userActivityLevel = sharedPreferences.getString("userActivityLevel","");
        userReason = sharedPreferences.getString("userReason","");
    }

    public void openMainActivity(View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
