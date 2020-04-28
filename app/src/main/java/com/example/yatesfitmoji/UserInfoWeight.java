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

    EditText weight, goal;
    com.google.android.material.textfield.TextInputLayout weightLayout, goalLayout;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_weight);

        weightLayout =findViewById(R.id.weightLayout);
        weight = new EditText(getApplicationContext());

        goalLayout = findViewById(R.id.goalLayout);
        goal = new EditText(getApplicationContext());

        next = findViewById(R.id.buttonContinue);

        loadWeight();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Material design workaround
                weight.setText(weightLayout.getEditText().getText().toString());
                goal.setText(goalLayout.getEditText().getText().toString());

                if (goal.getText().length() == 0.0f || weight.getText().length() == 0.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your Current Weight and Goal Weight", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                float goalFloat = Float.parseFloat(goal.getText().toString());
                float weightFloat = Float.parseFloat(weight.getText().toString());

                if (weightFloat < 50.0f || weightFloat > 700.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your real weight", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                if (goalFloat < 50.0f || goalFloat > 700.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your real goal weight", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }


                SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
                sharedPreferences.edit().putString("userWeight", weight.getText().toString()).apply();
                sharedPreferences.edit().putString("userGoal", goal.getText().toString()).apply();

                openUserInfoFinished(v);
            }
        });

    }

    protected void loadWeight(){
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref",MODE_PRIVATE);

        String temp = sharedPreferences.getString("userWeight","");
        if(!temp.equals("")){
            weightLayout.getEditText().setText(String.valueOf(temp));
        }
        temp = sharedPreferences.getString("userGoal","");
        if(!temp.equals("")){
            goalLayout.getEditText().setText(String.valueOf(temp));
        }

    }



    public void openUserInfoFinished(View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
