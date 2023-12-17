package com.findpath.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        CardView cardClasses = findViewById(R.id.cardClasses);
        CardView cardClasses1 = findViewById(R.id.cardClasses1);
        CardView cardClasses2 = findViewById(R.id.cardClasses2);

        // Set click listeners for each CardView
        cardClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Classes Overview
                startActivity(new Intent(DashboardActivity.this, ClassesActivity.class));
            }
        });

        cardClasses1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Students Overview
                startActivity(new Intent(DashboardActivity.this, StudentsActivity.class));
            }
        });

        cardClasses2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Tasks Overview
                startActivity(new Intent(DashboardActivity.this, TasksActivity.class));
            }
        });
    }
}