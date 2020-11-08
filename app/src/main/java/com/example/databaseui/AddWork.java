package com.example.databaseui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class AddWork extends AppCompatActivity {
    boolean workType;
    int d3year, d3month, d3date;

    TextView showDate;
    Spinner courseSelect;
    Spinner workTypeSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);
        //initialize course selection spinner
        courseSelect = (Spinner) findViewById(R.id.sp_work_courseChoice);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.courses, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSelect.setAdapter(adapter1);
        //initialize work type selection spinner
        workTypeSelect = (Spinner) findViewById(R.id.sp_homeworkSelect);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.yesNo, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workTypeSelect.setAdapter(adapter2);

        showDate = findViewById(R.id.tv_work_date);
        Button pickDate = findViewById(R.id.btn_work_date);
        pickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatePickerDialog dPD = new DatePickerDialog(
                        AddWork.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                d3year = year;
                                d3month = month;
                                d3date = dayOfMonth;

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(d3year, d3month, d3date, 0, 0);

                                showDate.setText(DateFormat.format("yyyy-MM-dd", calendar));
                            }
                        }, 2020, 1, 1
                );
                dPD.updateDate(d3year, d3month, d3date);
                dPD.show();
            }
        });

        //Submit Button Functionality
        Button sBtn = (Button) findViewById(R.id.btn_work_date);
        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText description = (EditText) findViewById(R.id.et_work_description);
                //get the selection from the spinner and store as a boolean
                String wT = workTypeSelect.getSelectedItem().toString();
                switch (wT) {
                    case "Yes":
                        workType = true;
                    case "No":
                        workType = false;
                }

                //USE THESE VARIABLES TO STORE DATA
                description.getText().toString();
                courseSelect.getSelectedItem().toString();
                workType = workType;
                showDate.getText().toString();
            }
        });
    }
}