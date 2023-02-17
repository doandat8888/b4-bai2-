package com.example.myapplication;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Spinner levelSelect;
    EditText fullNameInput;
    EditText phoneNumberInput;
    Switch genderSwitch;
    Spinner levelSpinner;
    SeekBar ageRange;
    CheckBox sportChxbx;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnRegister;
    Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        levelSelect = findViewById(R.id.levelSelect);
        fullNameInput = findViewById(R.id.fullNameInput);
        phoneNumberInput = findViewById(R.id.phoneInput);
        genderSwitch = findViewById(R.id.genderSwitch);
        levelSpinner = findViewById(R.id.levelSelect);
        ageRange = findViewById(R.id.ageRange);
        sportChxbx = findViewById(R.id.sportChbx);
        radioGroup = findViewById(R.id.musicGroup);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);
        String[] arraySpinner = new String[] {
                "Cao đẳng", "Đại học", "Cao học"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSelect.setAdapter(adapter);




        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullNameInput.setText("");
                phoneNumberInput.setText("");
                genderSwitch.setChecked(false);
                levelSpinner.setSelection(0);
                ageRange.setProgress(0);
                sportChxbx.setChecked(false);
                radioGroup.clearCheck();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String fullName = fullNameInput.getText().toString().trim().equals("") ? "" : fullNameInput.getText().toString();
                String phoneNumber = phoneNumberInput.getText().toString().trim().equals("") ? "" : phoneNumberInput.getText().toString();
                String gender = genderSwitch.isChecked() == true ? "Nam" : "Nữ";
                String levelSelect = levelSpinner.getSelectedItem().toString();
                Integer age = ageRange.getProgress();
                String playSport = sportChxbx.isChecked() == true ? "Có" : "Không";
                Integer selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedId);
                String musicSelect = radioButton != null ? radioButton.getText().toString() : "";
                int count = 0;
                String[] infoArr = {fullName, phoneNumber, gender, levelSelect, age.toString(), playSport, musicSelect};
                for(int i = 0; i < infoArr.length; i++) {
                    if(infoArr[i] == "") {
                        count++;
                    }
                }
                if(count > 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Vui lòng nhập đủ thông tin")
                            .setTitle("Thông báo");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                    Bundle extras = new Bundle();
                    extras.putString("fullName", fullName);
                    extras.putString("gender", gender);
                    extras.putString("phoneNumber", phoneNumber);
                    extras.putString("level", levelSelect);
                    extras.putString("age", age.toString());
                    extras.putString("playSport", playSport);
                    extras.putString("music", musicSelect);
                    intent.putExtras(extras);
                    startActivity(intent);
                }

            }
        });

    }
}