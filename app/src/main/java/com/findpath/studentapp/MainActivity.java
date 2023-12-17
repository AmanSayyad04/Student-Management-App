package com.findpath.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutPassword;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayoutUsername = findViewById(R.id.textInputLayoutUsername);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform login authentication here
                if (validateCredentials()) {
                    // If credentials are valid, navigate to the DashboardActivity
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish(); // Finish LoginActivity to prevent going back to it from the Dashboard
                }
            }
        });
    }

    private boolean validateCredentials() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (username.isEmpty()) {
            textInputLayoutUsername.setError("Username is required");
            return false;
        } else {
            textInputLayoutUsername.setError(null);
        }

        if (password.isEmpty()) {
            textInputLayoutPassword.setError("Password is required");
            return false;
        } else {
            textInputLayoutPassword.setError(null);
        }

        // Perform actual authentication logic here (e.g., check against a stored username and password)

        return true;
    }
}