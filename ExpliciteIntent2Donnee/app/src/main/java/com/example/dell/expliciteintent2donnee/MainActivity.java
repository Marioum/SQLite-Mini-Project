package com.example.dell.expliciteintent2donnee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(EditText) findViewById(R.id.editText3) ;
    }
    public void afficher(View v){
        Intent intent=new Intent(this, Main2Activity.class);
        intent.putExtra("np",t.getText().toString());
        startActivity(intent);
    }
}
