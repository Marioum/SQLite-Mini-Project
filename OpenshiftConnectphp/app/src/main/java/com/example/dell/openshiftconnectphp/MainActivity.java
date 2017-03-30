package com.example.dell.openshiftconnectphp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    //URL to get os JSON
    private static String url="http://myfirstphpapp-mansouri.rhcloud.com/";

    ArrayList<HashMap<String, String>> osList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        osList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetOs().execute();
    }

    private class GetOs extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            //progress dialog
            pDialog= new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            //request to url and get response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    //get json array node
                    JSONArray os = jsonObj.getJSONArray("OSS");

                    // looping through All Os
                    for (int i = 0; i < os.length(); i++) {
                        JSONObject c = os.getJSONObject(i);


                        String nom = c.getString("nom");
                        String nbusers = c.getString("nbusers");
                        String nbversion = c.getString("nbversion");
                        String nbsmart = c.getString("nbsmart");


                        // tmp hash map for single contact
                        HashMap<String, String> oss = new HashMap<>();

                        // adding each child node to HashMap key => value

                        oss.put("name", nom);
                        oss.put("nbusers", nbusers);
                        oss.put("nbversion", nbversion);
                        oss.put("nbsmart", nbsmart);

                        // adding contact to contact list
                        osList.add(oss);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, osList,
                    R.layout.list_item, new String[]{"name", "nbusers",
                    "nbversion", "nbsmart"}, new int[]{R.id.name,
                    R.id.nbusers, R.id.nbversion, R.id.nbsmart});

            lv.setAdapter(adapter);
            /*String valeur="android";
            Iterator myVeryOwnIterator = osList.iterator();
            while(myVeryOwnIterator.hasNext()) {
                String key=(String)myVeryOwnIterator.next();

            }*/

        }


    }

}