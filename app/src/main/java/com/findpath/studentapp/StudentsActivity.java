package com.findpath.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity {
    private List<Student> studentList;
    private ArrayAdapter<Student> adapter;
    private EditText editTextStudentName;
    private EditText editTextStudentRollCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.custom_student_item, studentList);


        // Set up ListView with multiple item selection
        ListView listViewStudents = findViewById(R.id.listViewStudents);
        listViewStudents.setAdapter(adapter);

        // Find EditTexts for student name and roll call
        editTextStudentName = findViewById(R.id.editTextStudentName);
        editTextStudentRollCall = findViewById(R.id.editTextStudentRollCall);

        // Button to add a new student
        Button btnAddStudent = findViewById(R.id.btnAddStudent);
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddStudentClick();
            }
        });

        // Button to delete selected students
        Button btnDeleteStudent = findViewById(R.id.btnDeleteStudent);
        btnDeleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteSelectedStudentsClick();
            }
        });

        // Example: Populate the list with sample students
        populateStudentList();
    }

    private void onAddStudentClick() {
        String studentName = editTextStudentName.getText().toString().trim();
        String rollCall = editTextStudentRollCall.getText().toString().trim();

        if (!studentName.isEmpty() && !rollCall.isEmpty()) {
            Student newStudent = new Student(studentName, rollCall);
            studentList.add(newStudent);
            adapter.notifyDataSetChanged();
            editTextStudentName.getText().clear();
            editTextStudentRollCall.getText().clear();
        } else {
            Toast.makeText(this, "Please enter both name and roll call", Toast.LENGTH_SHORT).show();
        }
    }

    private void onDeleteSelectedStudentsClick() {
        // Get the positions of selected items in the ListView
        SparseBooleanArray checkedPositions = ((ListView) findViewById(R.id.listViewStudents)).getCheckedItemPositions();

        if (checkedPositions != null) {
            // Remove selected students from the list
            for (int i = studentList.size() - 1; i >= 0; i--) {
                if (checkedPositions.get(i)) {
                    studentList.remove(i);
                }
            }

            adapter.notifyDataSetChanged();
            ((ListView) findViewById(R.id.listViewStudents)).clearChoices();
        } else {
            Toast.makeText(this, "Please select students to delete", Toast.LENGTH_SHORT).show();
        }
    }

    // Example method to populate the student list
    private void populateStudentList() {
        studentList.add(new Student("John Doe", "1"));
        studentList.add(new Student("Jane Doe", "2"));
        studentList.add(new Student("Alice Johnson", "3"));
        adapter.notifyDataSetChanged();
    }

    // Inner class representing a Student
    private static class Student {
        private String name;
        private String rollCall;

        public Student(String name, String rollCall) {
            this.name = name;
            this.rollCall = rollCall;
        }

        @Override
        public String toString() {
            return "Name: " + name + " | Roll Call: " + rollCall;
        }
    }
}
