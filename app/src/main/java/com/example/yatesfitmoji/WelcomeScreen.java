package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WelcomeScreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button ok;
    TextView welcomeMsg;
    TextView welcomeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        ok = findViewById(R.id.buttonContinue);
        welcomeInfo = findViewById(R.id.welcomeInfo);
        welcomeMsg = findViewById(R.id.textWelcome);

        if (sharedPreferences.getBoolean("setupFinished", false)){
            welcomeMsg.setText("Welcome back to Fitmoji " + sharedPreferences.getString("userName", ""));
            welcomeInfo.setText(R.string.textReturningUser);
        }
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bypasses user setup if the account has already been setup
                if (sharedPreferences.getBoolean("setupFinished", false)) openMainActivity(v);
                else openUserInfoName(v);
            }
        });
    }

    public void openUserInfoName(View view){
        Intent intent = new Intent (this, UserInfoName.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openMainActivity(View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed(){
        //disable back button
    }

}
