package com.example.dell.sqliteex3;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
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
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ListView listView ;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> list;
    final int ADD_ITEM_ACTIVITY=48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = new ArrayList<String>();
        list.add("Android");
        list.add("iOS");
        list.add("Windows");
        listView = (ListView) findViewById(R.id.lv);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id){
        String element=adapter.getItem(pos);
        Intent intent=new Intent(this,DataXml.class);
        intent.putExtra("OS",element);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnAddItemAction(MenuItem menuItem){
        Intent intent=new Intent(this,ItemActivity.class);
        startActivityForResult(intent,ADD_ITEM_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if (requestCode != ADD_ITEM_ACTIVITY) return;
        if (resultCode != RESULT_OK) {
            Toast toast = Toast.makeText(context, "No item is added!", duration);
            toast.show();
            return;
        }
        if ((resultCode == RESULT_OK)) {
            String item = data.getStringExtra("item");
            adapter.add((item));
            Toast toast = Toast.makeText(context, "Item added!", duration);
            toast.show();
        }
    }
}
