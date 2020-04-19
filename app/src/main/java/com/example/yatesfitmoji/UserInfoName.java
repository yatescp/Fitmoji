package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserInfoName extends AppCompatActivity {

    EditText nameInput;
    Button next;

    String name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_name);

        next = findViewById(R.id.buttonContinue);
        nameInput = findViewById(R.id.goalInput);

        loadName();
        updateName();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
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
    }

    protected void loadName() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        name = sharedPreferences.getString("userName", "");
    }

    protected void updateName() {
        nameInput.setText(name);
    }

    public void openUserReason(View view){
        Intent intent = new Intent (this, UserInfoReason.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
