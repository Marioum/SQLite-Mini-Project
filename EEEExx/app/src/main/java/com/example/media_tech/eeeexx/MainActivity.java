
package com.example.media_tech.eeeexx;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
DatabaseOpenHelper databaseOpenHelper;
//SQLiteDatabase sqlightdatabase= new SQLiteDatabase();
private ArrayAdapter<String> adapter;
    private ListView listView;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
         databaseOpenHelper=new DatabaseOpenHelper(this);
        list = new ArrayList<String>();
        list.add("Android");
        list.add("iOS");
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        AndroidOs os1=new AndroidOs("android",14,56,56);
        AndroidOs  os2=new AndroidOs("iPhone",45,67,78);
        databaseOpenHelper.insert(os1);
        databaseOpenHelper.insert(os2);


        ///item event with sqlite
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AndroidOs androidOs = databaseOpenHelper.getOs(list.get(position));
                if (androidOs == null) {
                    Toast.makeText(getApplicationContext(), " objet null ", Toast.LENGTH_LONG).show();


                } else {
                    Intent intent = new Intent(getApplicationContext(), AfficheActivity.class);
                    intent.putExtra("name", androidOs.getName());
                    startActivity(intent);

                }
            }

        });

    }





}
