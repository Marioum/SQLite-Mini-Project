package com.example.dell.implicteintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=(EditText)findViewById(R.id.number);
    }

    public void call(View v){
        Uri uri= Uri.parse("tel: "+number.getText());
        Intent callIntent=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(callIntent);
    }

    public void site(View v){
        Uri uri= Uri.parse("http://www.ensit.tn");
        Intent siteIntent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(siteIntent);
    }
}
