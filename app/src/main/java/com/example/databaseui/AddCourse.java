package com.example.databaseui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class AddCourse extends AppCompatActivity {
    EditText mEdit;
    EditText nEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        Button sBtn = (Button) findViewById(R.id.btn_course_submit);

        sBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEdit = (EditText) findViewById(R.id.et_course_title);
                nEdit = (EditText) findViewById(R.id.et_course_prof);

                //USE THESE TO ACCESS THE DATA FROM INPUT
                mEdit.getText().toString();
                mEdit.getText().toString();
            }
        });
    }
}