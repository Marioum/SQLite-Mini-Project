package com.example.dell.numlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        TextView textView=(TextView)findViewById(R.id.textView2);
        String item=getIntent().getStringExtra("item");
        textView.setText(item);
    }
}
