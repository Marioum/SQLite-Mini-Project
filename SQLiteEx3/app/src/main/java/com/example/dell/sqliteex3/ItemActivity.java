package com.example.dell.sqliteex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }

    public void addItem(View v){
        Intent intent=new Intent();
        EditText editText=(EditText)findViewById(R.id.editText);
        intent.putExtra("item", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View v){
        setResult(RESULT_CANCELED);
        finish();
    }


}
