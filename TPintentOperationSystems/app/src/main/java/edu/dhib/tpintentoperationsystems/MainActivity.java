package edu.dhib.tpintentoperationsystems;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> list;
    final int ADD_ITEM_ACTIVITY=48;
    OperatingSystem androidOs,blackBerry,ios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chargeOperatingSystems();
        list = new ArrayList<>();
        list.add("Android");
        list.add("iOS");
        list.add("BlackBerry");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

    }


    protected void chargeOperatingSystems(){
        androidOs=new OperatingSystem();
        blackBerry=new OperatingSystem();
        ios=new OperatingSystem();
        String str="";

        try{
            InputStream is=getAssets().open("internStorage.txt");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                if(is!=null){
                    //start reading file
                    androidOs.setName(bufferedReader.readLine());
                    androidOs.setDescription(bufferedReader.readLine());
                    androidOs.setNombreSmartphones(bufferedReader.readLine());
                    androidOs.setNombreUtilisateurs(bufferedReader.readLine());
                    androidOs.setNombreVersions(bufferedReader.readLine());

                    ios.setName(bufferedReader.readLine());
                    ios.setDescription(bufferedReader.readLine());
                    ios.setNombreSmartphones(bufferedReader.readLine());
                    ios.setNombreUtilisateurs(bufferedReader.readLine());
                    ios.setNombreVersions(bufferedReader.readLine());

                    blackBerry.setName(bufferedReader.readLine());
                    blackBerry.setDescription(bufferedReader.readLine());
                    blackBerry.setNombreSmartphones(bufferedReader.readLine());
                    blackBerry.setNombreUtilisateurs(bufferedReader.readLine());
                    blackBerry.setNombreVersions(bufferedReader.readLine());


                }
            }finally {
                try{is.close();}catch (Throwable ignore){}
            }
        }catch(IOException exc){
            exc.printStackTrace();
        }

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent=new Intent(this,OsDescritpionActivity.class);
        if (position==0){

            intent.putExtra("Name",androidOs.getName());
            intent.putExtra("Description",androidOs.getDescription());
            intent.putExtra("nbreU",androidOs.getNombreUtilisateurs());
            intent.putExtra("nbreV",androidOs.getNombreVersions());
            intent.putExtra("nbreS",androidOs.getNombreSmartphones());
            startActivity(intent);


        }else if(position==1){
            intent.putExtra("Name", blackBerry.getName());
            intent.putExtra("Description",blackBerry.getDescription());
            intent.putExtra("nbreU",blackBerry.getNombreUtilisateurs());
            intent.putExtra("nbreV",blackBerry.getNombreVersions());
            intent.putExtra("nbreS",blackBerry.getNombreSmartphones());
            startActivity(intent);
        }else if(position==2){
            intent.putExtra("Name", ios.getName());
            intent.putExtra("Description",ios.getDescription());
            intent.putExtra("nbreU",ios.getNombreUtilisateurs());
            intent.putExtra("nbreV",ios.getNombreVersions());
            intent.putExtra("nbreS",ios.getNombreSmartphones());
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onAddItemAction(MenuItem menuItem){
        Intent intent=new Intent(this,AddOSActivity.class);
        startActivityForResult(intent, ADD_ITEM_ACTIVITY);
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==ADD_ITEM_ACTIVITY){
            String item=data.getStringExtra("item");
            adapter.add(item);
        }
        if(resultCode==RESULT_OK){
            Toast.makeText(this,"Fermeture",Toast.LENGTH_SHORT);
        }
    }

}
