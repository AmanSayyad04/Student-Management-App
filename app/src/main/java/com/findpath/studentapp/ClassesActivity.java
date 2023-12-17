package com.findpath.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ClassesActivity extends AppCompatActivity {

    private List<String> classList;
    private ArrayAdapter<String> adapter;
    private EditText editTextClassName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        classList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, classList);

// Set up ListView with multiple item selection
        ListView listViewClasses = findViewById(R.id.listViewClasses);
        listViewClasses.setAdapter(adapter);

// Set item click listener for ListView
        listViewClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click, if needed
                Toast.makeText(ClassesActivity.this, "Item clicked: " + classList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        // Find EditText for class name
        editTextClassName = findViewById(R.id.editTextClassName);

        // Button to add a new class
        Button btnAddClass = findViewById(R.id.btnAddClass);
        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddClassClick();
            }
        });

        // Button to delete selected classes
        Button btnDeleteClass = findViewById(R.id.btnDeleteClass);
        btnDeleteClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteSelectedClassesClick();
            }
        });

        // Example: Populate the list with sample classes
        populateClassList();
    }

    private void onAddClassClick() {
        String className = editTextClassName.getText().toString().trim();
        if (!className.isEmpty()) {
            classList.add(className);
            adapter.notifyDataSetChanged();
            editTextClassName.getText().clear();
        } else {
            Toast.makeText(this, "Please enter a class name", Toast.LENGTH_SHORT).show();
        }
    }



    private void onDeleteSelectedClassesClick() {
        // Get the positions of selected items in the ListView
        SparseBooleanArray checkedPositions = ((ListView) findViewById(R.id.listViewClasses)).getCheckedItemPositions();

        if (checkedPositions != null) {
            // Remove selected classes from the list
            for (int i = classList.size() - 1; i >= 0; i--) {
                if (checkedPositions.get(i)) {
                    classList.remove(i);
                }
            }

            adapter.notifyDataSetChanged();
            ((ListView) findViewById(R.id.listViewClasses)).clearChoices();
        } else {
            Toast.makeText(this, "Please select classes to delete", Toast.LENGTH_SHORT).show();
        }
    }

    // Example method to populate the class list
    private void populateClassList() {
        classList.add("Class 1");
        classList.add("Class 2");
        classList.add("Class 3");
        adapter.notifyDataSetChanged();
    }
}