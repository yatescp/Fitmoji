package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoWeight extends AppCompatActivity {

    EditText weight, height;

    com.google.android.material.textfield.TextInputLayout weightLayout, heightLayout;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_weight);

        weightLayout = findViewById(R.id.weightLayout);
        weight = new EditText(getApplicationContext());

        heightLayout = findViewById(R.id.heightLayout);
        height = new EditText(getApplicationContext());

        next = findViewById(R.id.buttonContinue);

        loadWeight();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Reinstated previous ideology with new questions
                weight.setText(weightLayout.getEditText().getText().toString());
                height.setText(heightLayout.getEditText().getText().toString());

                if (height.getText().length() == 0.0f || weight.getText().length() == 0.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your Current Weight and Height", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                float heightFloat = Float.parseFloat(height.getText().toString());
                float weightFloat = Float.parseFloat(weight.getText().toString());

                if (weightFloat < 50.0f || weightFloat > 700.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your real weight", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                if (heightFloat < 50.0f || heightFloat > 84.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your real height", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                if(height.getText().toString().equals("") || weight.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),"Please enter both your height and weight",Toast.LENGTH_SHORT);
                    toast.show();
                }

                else{
                    SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
                    sharedPreferences.edit().putString("userWeight", weight.getText().toString()).apply();
                    sharedPreferences.edit().putString("userHeight", height.getText().toString()).apply();
                    sharedPreferences.edit().putBoolean("setupFinished", true).apply();

                    openUserActivityLevel(v);
                }
            }
        });

    }

    protected void loadWeight() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        //there only needs to be one temp its temporary
        String temp = sharedPreferences.getString("userWeight","");
        if(!temp.equals("")){
            weightLayout.getEditText().setText(temp);
        }
        temp = sharedPreferences.getString("userHeight","");
        if(!temp.equals("")){
            heightLayout.getEditText().setText(temp);
        }
    }

    public void openUserActivityLevel(View view){
        Intent intent = new Intent (this, UserActivityLevel.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    // commenting this out because it needs to calculate before going to the last screen.
//    public void openUserInfoFinished(View view){
//        Intent intent = new Intent (this, MainActivity.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }
}
