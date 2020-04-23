package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class UserInfoName extends AppCompatActivity {

    EditText nameInput, ageInput;
    Button next;
    RadioButton maleBtn, femaleBtn;

    String name;
    int age, sex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_name);

        next = findViewById(R.id.buttonContinue);
        nameInput = findViewById(R.id.goalInput);
        ageInput= findViewById(R.id.ageInputId);
        maleBtn = findViewById(R.id.maleButton1);
        femaleBtn = findViewById(R.id.femaleButton2);

        loadName();
        updateName();

        maleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex =1;
            }
        });

        femaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex =0;
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                age = Integer.parseInt(ageInput.getText().toString());
                saveName();
                openUserReason(v);
            }
        });
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    protected void saveName() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        sharedPreferences.edit().putString("userName", nameInput.getText().toString()).apply();
        sharedPreferences.edit().putString("userAge", ageInput.getText().toString()).apply();
        sharedPreferences.edit().putString("userSex", String.valueOf(sex)).apply();
    }

    protected void loadName() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        name = sharedPreferences.getString("userName", "");

        String ageTemp = sharedPreferences.getString("userAge", "");
        if(!ageTemp.equals("")) {
            age = Integer.parseInt(ageTemp);
        }

        String sexTemp = sharedPreferences.getString("userSex", "");
        if(!sexTemp.equals("")) {
            sex = Integer.parseInt(sexTemp);
        }
    }

    protected void updateName() {
        nameInput.setText(name);
        ageInput.setText(String.valueOf(age));

        if(sex == 1) {
            femaleBtn.setChecked(false);
            maleBtn.setChecked(true);
        } else {
            maleBtn.setChecked(false);
            femaleBtn.setChecked(true);
        }
    }

    public void openUserReason(View view){
        Intent intent = new Intent (this, UserInfoReason.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
