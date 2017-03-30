package com.example.dell.expliciteintent2donnee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
private EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t=(EditText) findViewById(R.id.editText) ;

        Bundle extra=getIntent().getExtras();
        t.setText(extra.getString("np"));

    }
}
