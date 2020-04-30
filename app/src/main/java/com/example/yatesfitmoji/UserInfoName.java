package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class UserInfoName extends AppCompatActivity {

    EditText nameInput, ageInput;
    Button next;
    RadioButton maleBtn, femaleBtn;

    com.google.android.material.textfield.TextInputLayout nameLayout;
    com.google.android.material.textfield.TextInputLayout ageLayout;

    String name;
    int age, sex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_name);

        next = findViewById(R.id.buttonContinue);
        maleBtn = findViewById(R.id.maleButton1);
        femaleBtn = findViewById(R.id.femaleButton2);


        //material design update workaround
        nameLayout=findViewById(R.id.nameLayout);
        nameInput = new EditText(getApplicationContext());

        ageInput = new EditText(getApplicationContext());
        ageLayout=findViewById(R.id.ageLayout);


        loadName();
        updateName();

        maleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = 1;
            }
        });

        femaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = 0;
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //makes sure the entry fields are not empty
                if(nameLayout.getEditText().getText().toString().length( )== 0 || ageLayout.getEditText().getText().toString().length()==0){
                    Toast toast = Toast.makeText(getApplicationContext(), "please fill out all information", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    //workaround to not have to rewrite multiple lines of code while keeping new material design
                    nameInput.setText(nameLayout.getEditText().getText().toString());
                    ageInput.setText(ageLayout.getEditText().getText().toString());

                    //saves data and prepares for the next screen
                    name = nameInput.getText().toString();
                    age = Integer.parseInt(ageInput.getText().toString());
                    if(age<13) {
                        Toast toast = Toast.makeText(getApplicationContext(), "You must be 13 years or older", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {
                        saveName();
                        openUserReason(v);
                    }
                }
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

        nameLayout.getEditText().setText(name);
        if(age!= 0){
            ageLayout.getEditText().setText(String.valueOf(age));
            if(sex == 1) {
                femaleBtn.setChecked(false);
                maleBtn.setChecked(true);
            } else {
                maleBtn.setChecked(false);
                femaleBtn.setChecked(true);
            }
        }


    }

    public void openUserReason(View view){
        Intent intent = new Intent (this, UserInfoReason.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
