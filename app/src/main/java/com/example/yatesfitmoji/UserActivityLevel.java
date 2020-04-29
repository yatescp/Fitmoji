package com.example.yatesfitmoji;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivityLevel extends AppCompatActivity {

    RadioButton light, moderate, active, veryActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_activity_level);

        light = findViewById(R.id.radioButtonLight);
        moderate = findViewById(R.id.radioButtonModerate);
        active = findViewById(R.id.radioButtonActive);
        veryActive = findViewById(R.id.radioButtonVeryActive);


        // TODO: Need to add logic to calculate the macros based on the activity level.

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserInfoFinished(v);
            }
        });

        moderate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserInfoFinished(v);
            }
        });

        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserInfoFinished(v);
            }
        });

        veryActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserInfoFinished(v);
            }
        });




    }


    public void openUserInfoFinished(View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
