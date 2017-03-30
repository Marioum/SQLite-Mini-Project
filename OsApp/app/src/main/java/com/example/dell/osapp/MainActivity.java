package com.example.dell.osapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv=(ListView) findViewById(R.id.lv);
        final Button btn=(Button) findViewById(R.id.btn);
        final Intent intent=new Intent(this,ItemActivity.class);

        //remplir la liste view et création d'adapter

        list = new ArrayList<String>();
        list.add("Android");
        list.add("iOS");
        list.add("Windows");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        //cliquer sur button pour ajouter un os à la liste
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent,ADD_ITEM_ACTIVITY);
            }
        });

        //cliquer sur item pour afficher les informations
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(getApplicationContext(), ItemDetailsActivity.class);
                intent1.putExtra("info", adapterView.getItemAtPosition(i).toString());
                startActivity(intent1);
            }
        });
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
