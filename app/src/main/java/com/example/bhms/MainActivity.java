package com.example.bhms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button register =(Button)findViewById(R.id.loginButton);

        register.setOnClickListener(v -> {
            EditText id = findViewById(R.id.email);
            String email = id.getText().toString().trim();

            EditText pass = findViewById(R.id.password);
            String password = pass.getText().toString().trim();
            if(email.isEmpty()||password.isEmpty())
            {
                Toast.makeText(getApplicationContext(), "Enter valid Email and password", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });
    }

    public void signupPage(View view) {
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
    }
}