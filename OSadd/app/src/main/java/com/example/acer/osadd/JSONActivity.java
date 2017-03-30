package com.example.acer.osadd;

import android.net.ParseException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class JSONActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //setContentView(R.layout.main);
        String result = null;
        InputStream is = null;
        JSONObject json_data=null;
        ArrayList<Fichier_info> nameValuePairs = new ArrayList<Fichier_info>();
        ArrayList<String> donnees = new ArrayList<String>();

        try{
            //commandes httpClient
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://10.0.2.2/connexion_mysql/connexion_mysql.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        }
        catch(Exception e){
            Log.i("taghttppost",""+e.toString());
            Toast.makeText(getBaseContext(),e.toString() ,Toast.LENGTH_LONG).show();
        }


        //conversion de la réponse en chaine de caractère
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            StringBuilder sb  = new StringBuilder();

            String line = null;

            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }

            is.close();

            result = sb.toString();
        }
        catch(Exception e)
        {
            Log.i("tagconvertstr",""+e.toString());
        }
        //recuperation des donnees json
        try{
            JSONArray jArray = new JSONArray(result);

            for(int i=0;i<jArray.length();i++)
            {

                json_data = jArray.getJSONObject(i);
                donnees.add(json_data.getString("nom"));
                //r.add(json_data.getString("categorie"));

            }
            setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, donnees));
        }
        catch(JSONException e){
            Log.i("tagjsonexp",""+e.toString());
        } catch (ParseException e) {
            Log.i("tagjsonpars",""+e.toString());
        }

    }


}
