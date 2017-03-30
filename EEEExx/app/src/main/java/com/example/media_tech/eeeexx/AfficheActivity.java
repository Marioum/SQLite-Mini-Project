package com.example.media_tech.eeeexx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AfficheActivity extends AppCompatActivity {
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);
        text=(TextView)findViewById(R.id.textView);
       text.setText(text.getText()+" "+getIntent().getStringExtra("name"));
    }
}
