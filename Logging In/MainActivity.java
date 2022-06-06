package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText un, pwd;
        Button signup;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un = (EditText) findViewById(R.id.user);
        pwd = (EditText) findViewById(R.id.pass);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = un.getText().toString();
                String pass = pwd.getText().toString();
                if (user.length() == 0) {
                    un.setError("Email is Empty");
                    un.requestFocus();
                } else if (pass.length() == 0) {
                    pwd.setError("Password is Empty");
                    pwd.requestFocus();
                } else {
                    if (!isValidpassword(pass)) {
                        Toast.makeText(MainActivity.this, "Password dosent match with pattern", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, SignIn.class);
                        intent.putExtra("Username", user);
                        intent.putExtra("password", pass);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    Pattern lowercase = Pattern.compile("^.*[a-z]*.$");
    Pattern uppercase = Pattern.compile("^.*[A-Z]*.$");
    Pattern number = Pattern.compile("^.*[0-9]*.$");
    Pattern special = Pattern.compile("^.*[a-zA-Z0-9]*.$");

    private boolean isValidpassword(String pass) {
        if (pass.length() < 8) {
            return false;
        }
        if (!lowercase.matcher(pass).matches()) {
            return false;
        }
        if (!uppercase.matcher(pass).matches()) {
            return false;
        }
        if (!number.matcher(pass).matches()) {
            return false;
        }
        if (!special.matcher(pass).matches()) {
            return false;
        }
        return  true;
    }
}