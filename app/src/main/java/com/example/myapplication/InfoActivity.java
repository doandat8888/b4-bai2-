package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    TextView fullName;
    TextView phoneNumber;
    TextView gender;
    TextView level;
    TextView age;
    TextView sport;
    TextView music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        fullName = findViewById(R.id.fullNameValue);
        phoneNumber = findViewById(R.id.phoneNumberValue);
        gender = findViewById(R.id.genderValue);
        age = findViewById(R.id.ageValue);
        level = findViewById(R.id.levelValue);
        sport = findViewById(R.id.sportValue);
        music = findViewById(R.id.musicValue);


        fullName.setText(extras.getString("fullName"));
        phoneNumber.setText(extras.getString("phoneNumber"));
        age.setText(extras.getString("age"));
        gender.setText(extras.getString("gender"));
        level.setText(extras.getString("level"));
        sport.setText(extras.getString("playSport"));
        music.setText(extras.getString("music"));
    }
}