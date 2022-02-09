package com.example.bjitiaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bjitiaproject.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText eTUserName, eTEmail, eTPassword, eTPhone, eTCGPA;
    Button btnCancel, btnSave, btnClear;
    ArrayList<Student> studentArrayList;
    ArrayAdapter<Student> studentArrayAdapter;
    ListView listView;
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

        listView = (ListView) findViewById(R.id.listview);
        studentArrayList = new ArrayList<Student>();
        studentArrayAdapter = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1, studentArrayList);
        listView.setAdapter(studentArrayAdapter);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eTUserName.setText("");
                eTEmail.setText("");
                eTPassword.setText("");
                eTPhone.setText("");
                eTCGPA.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean error = false;
                Student std = new Student();
                String userName, email, password, phone, cgpa;
                userName = eTUserName.getText().toString().trim();
                email = eTEmail.getText().toString();
                password = eTPassword.getText().toString();
                phone = eTPhone.getText().toString();
                cgpa = eTCGPA.getText().toString();

                // data validation
                if (userName.isEmpty()){
                    error = true;
                    eTUserName.setError("Username is missing!!");
                } else{
                    if(userName.length() < 6){
                        error = true;
                        eTUserName.setError("Username is too short!!");
                    } else{
                        std.setUserName(userName);
                    }
                }
                if (email.isEmpty()){
                    error = true;
                    eTEmail.setError("Email is missing!!");
                } else{
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        error = true;
                        eTEmail.setError("Please provide a valid email address!!");
                    } else{
                        std.setEmail(email);
                    }
                }
                if (password.isEmpty()){
                    error = true;
                    eTPassword.setError("Password required!!");
                } else{
                    if(password.length() < 8 || password.length() > 20){
                        error = true;
                        eTPassword.setError("Password must contain 8 to 20 characters!!");
                    } else{
                        std.setPassword(password);
                    }
                }
                if (phone.isEmpty()){
                    error = true;
                    eTPhone.setError("Phone number missing!!");
                } else if (phone.length()==11){
                    if (phone.startsWith("017") || phone.startsWith("013") || phone.startsWith("019") ||
                        phone.startsWith("016") || phone.startsWith("018") || phone.startsWith("015")){
                        std.setPhoneNo(phone);
                    } else{
                        error = true;
                        eTPhone.setError("Invalid phone number");
                    }
                } else{
                    error = true;
                    eTPhone.setError("Phone number should be 11 digits!!");
                }
                if (cgpa.isEmpty()){
                    error = true;
                    eTCGPA.setError("CGPA missing!!");
                } else{
                    if(Float.parseFloat(cgpa) < 0 || Float.parseFloat(cgpa) > 4){
                        error = true;
                        eTCGPA.setError("Invalid CGPA!!");
                    } else{
                        std.setCgpa(Float.parseFloat(cgpa));
                    }
                }
                if(error){
                    Toast.makeText(MainActivity.this, "Data is not saved!!", Toast.LENGTH_SHORT).show();
                } else{
                    studentArrayList.add(std);
                    studentArrayAdapter.notifyDataSetChanged();
                    //Toast.makeText(MainActivity.this, std.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}