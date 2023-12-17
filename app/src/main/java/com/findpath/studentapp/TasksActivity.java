package com.findpath.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends AppCompatActivity {
    private List<Task> taskList;
    private ArrayAdapter<Task> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.task_item, taskList);

        // Set up ListView
        ListView listViewTasks = findViewById(R.id.listViewTasks);
        listViewTasks.setAdapter(adapter);

        // Add sample tasks (replace with your actual task data)
        taskList.add(new Task("Task 1"));
        taskList.add(new Task("Task 2"));

        // Notify the adapter that the data set has changed
        adapter.notifyDataSetChanged();

        // Handle task item clicks (optional)
        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task selectedTask = taskList.get(position);
                // Implement your logic for task item click
            }
        });
    }
}