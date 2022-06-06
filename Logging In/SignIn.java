package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText usr,pasd;
    Button login;
    TextView txt;
    int counter=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        usr=(EditText)findViewById(R.id.user);
        pasd=(EditText) findViewById(R.id.pass);
        login=(Button) findViewById(R.id.button2);
        txt=(TextView) findViewById(R.id.textView7);

        String reuser=getIntent().getStringExtra("Username");
        String repass=getIntent().getStringExtra("Password");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usr.getText().toString();
                String password=pasd.getText().toString();

                if(reuser.equals(username) && repass.equals(password)){
                    Intent intent=new Intent(SignIn.this,Success.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(SignIn.this,"Invalid Credentials",Toast.LENGTH_LONG).show();

                }
                txt.setVisibility(View.VISIBLE);
                txt.setBackgroundColor(Color.RED);
                counter--;
                txt.setText(Integer.toString(counter));
                if(counter==0)
                {
                    Toast.makeText(SignIn.this,"Failed Login Attempts",Toast.LENGTH_LONG).show();
                    login.setEnabled(false);
                }
            }
        });
    }
}



