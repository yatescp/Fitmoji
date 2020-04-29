package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfoWeight extends AppCompatActivity {

    TextView weight, height;



    com.google.android.material.textfield.TextInputEditText weightLayoutInput, heightLayoutInput;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_weight);

        weightLayoutInput = findViewById(R.id.weightInput);
        weight = findViewById(R.id.weightLabel);//new EditText(getApplicationContext());

        heightLayoutInput = findViewById(R.id.heightInput);
        height = findViewById(R.id.heightLabel);//new EditText(getApplicationContext());

        next = findViewById(R.id.buttonContinue);

        loadWeight();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Material design workaround
                //weight.setText(weightLayoutInput.getEditableText().toString());
                //height.setText(heightLayoutInput.getEditableText().toString());

                if (height.getText().length() == 0.0f || weight.getText().length() == 0.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your Current Weight and Height", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                float heightFloat = Float.parseFloat(heightLayoutInput.getText().toString());
                float weightFloat = Float.parseFloat(weightLayoutInput.getText().toString());

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


                SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
                sharedPreferences.edit().putString("userWeight", weightLayoutInput.getText().toString()).apply();
                sharedPreferences.edit().putString("userHeight", heightLayoutInput.getText().toString()).apply();
                sharedPreferences.edit().putBoolean("setupFinished", true).apply();

                openUserActivityLevel(v);
            }
        });

    }

    protected void loadWeight() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref",MODE_PRIVATE);

        String tempWeight = sharedPreferences.getString("userWeight","");
        if(tempWeight != null && !tempWeight.equals("")){
            weightLayoutInput.setText(tempWeight);
        }
        String tempHeight = sharedPreferences.getString("userHeight","");
        if(tempHeight != null && !tempHeight.equals("")){
            heightLayoutInput.setText(tempHeight);
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
