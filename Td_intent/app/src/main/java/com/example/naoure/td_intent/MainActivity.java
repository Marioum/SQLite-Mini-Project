package com.example.naoure.td_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ArrayList<String> list;
    final int ADD_ITEM_ACTIVITY = 48;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);

        final ListView lv = (ListView) findViewById(R.id.lv);
        final Button btn = (Button) findViewById(R.id.btn);
        final Intent intent=new Intent(this,Main2Activity.class);


        list = new ArrayList<String>();
        list.add("Android");
        list.add("iOS");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, ADD_ITEM_ACTIVITY);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                intent.putExtra("info",adapterView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {

        if (requestCode == ADD_ITEM_ACTIVITY)
        {
            if (resultCode == RESULT_OK) {String item = data.getStringExtra("item");
                adapter.add(item);}
        }
    }
}
