package com.example.bhms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(v -> {

            EditText id = findViewById(R.id.email);
            String email = id.getText().toString().trim();
            EditText pass = findViewById(R.id.password);
            String password = pass.getText().toString().trim();
            EditText confirm = findViewById(R.id.confirmPassword);
            String confirm_pass = confirm.getText().toString().trim();
            if(email.isEmpty()||password.isEmpty())
            {
                Toast.makeText(getApplicationContext(), "please fill all inputs", Toast.LENGTH_SHORT).show();
            }
            else if(!password.equals(confirm_pass)){
                Toast.makeText(getApplicationContext(), "passwrd not match", Toast.LENGTH_SHORT).show();

            }
            else {
                SignUp();
            }

        });
    }
    private void SignUp() {
        EditText id = findViewById(R.id.email);
        String email = id.getText().toString().trim();
        EditText pass = findViewById(R.id.password);
        String password = pass.getText().toString().trim();

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.100.9:5000/user/api/signup",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("anyText", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            String status = jsonObject.getString("status");
                            if (status.equals("200")) {
                                Toast.makeText(getApplicationContext(), "Successfully created account", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(signup.this, HomeScreen.class);
                                startActivity(intent);


                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Registration Error !1" + e, Toast.LENGTH_LONG).show();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error while creating account", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("username",email );
                params.put("password", password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }







    public void loginPage(View view) {
        Intent intent = new Intent(signup.this, MainActivity.class);
        startActivity(intent);
    }
}