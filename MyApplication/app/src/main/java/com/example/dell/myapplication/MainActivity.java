package com.example.dell.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=(EditText)findViewById(R.id.phone);
    }
    protected void cliquer(View v){
       switch (v.getId()){
           case R.id.AppelerDial:
               Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+number.getText()));
               startActivity(intent);
               break;
           case R.id.OuvrirGoogle:
               Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
               startActivity(intent1);
               break;
           case R.id.OuvrirGoogleMap:
               Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.googleMAP.com"));
               startActivity(intent2);
               break;
           case R.id.EditerContact:
               Intent intent3=new Intent(Intent.ACTION_EDIT);
               startActivity(intent3);
               break;
           case R.id.PrendrePhoto:
               Intent intent4=new Intent(Intent.ACTION_CAMERA_BUTTON);
               startActivity(intent4);
               break;
           case R.id.OuvrirListeContacts:
               Intent intent5=new Intent(Intent.ACTION_GET_CONTENT);
               startActivity(intent5);
               break;
           case R.id.ParamWIFI:
               Intent intent6=new Intent(Intent.ACTION_POWER_CONNECTED);
               startActivity(intent6);
               break;
       }
    }
}
