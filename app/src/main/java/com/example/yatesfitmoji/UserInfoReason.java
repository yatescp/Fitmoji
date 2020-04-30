package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class UserInfoReason extends AppCompatActivity {

    RadioButton gain, lose, stay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_reason);

        gain = findViewById(R.id.radioButtonWeightGain);
        lose = findViewById(R.id.radioButtonWeightLoss);
        stay = findViewById(R.id.radioButtonWeightStayInShape);

        gain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReason("gain weight");
                openUserWeight(v);
            }
        });
        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReason("lose weight");
                openUserWeight(v);
            }
        });
        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReason("stay in shape");
                openUserWeight(v);
            }
        });
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    protected void saveReason(String reason) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        sharedPreferences.edit().putString("userReason", reason).apply();
    }

    public void openUserWeight(View view){
        Intent intent = new Intent (this, UserInfoWeight.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
