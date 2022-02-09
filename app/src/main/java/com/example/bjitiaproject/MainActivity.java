package com.example.bjitiaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText eTUserName, eTEmail, eTPassword, eTPhone, eTCGPA;
    Button btnCancel, btnSave, btnClear;

    String userName, password, phone, cgpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTUserName = findViewById(R.id.eTUserName);
        eTEmail = findViewById(R.id.eTEmail);
        eTPassword = findViewById(R.id.eTPassword);
        eTPhone = findViewById(R.id.eTPhoneNo);
        eTCGPA = findViewById(R.id.eTCGPA);

        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eTUserName.setText("");
                eTEmail.setText("");
                eTPassword.setText("");
                eTPhone.setText("");
                eTCGPA.setText("");
            }
        });
    }
}