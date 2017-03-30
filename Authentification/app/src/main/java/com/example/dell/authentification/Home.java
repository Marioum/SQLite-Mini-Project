package com.example.dell.authentification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    String email, pwd, Err;
    TextView emailTV, pwdTV, err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        emailTV = (TextView) findViewById(R.id.email);
        pwdTV = (TextView) findViewById(R.id.pwd);
        err = (TextView) findViewById(R.id.err);

        email = getIntent().getStringExtra("email");
        pwd = getIntent().getStringExtra("pwd");
        Err = getIntent().getStringExtra("err");

        emailTV.setText("Welcome! Your email is "+email);
        pwdTV.setText("Your password is "+pwd);
        err.setText(Err);
    }
}