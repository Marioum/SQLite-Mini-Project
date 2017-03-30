package com.example.dell.numlist;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<String> list=new ArrayList<String>();
        for(int i=0; i<100; i++) list.add(""+i);
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int pos, long id){
        String element=adapter.getItem((pos));
        Intent intent=new Intent(this,ItemActivity.class);
        intent.putExtra("item",element);
        startActivity(intent);
    }

}

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        BackGround b = new BackGround();
        b.execute(adapter.getItem(position));

    }
class BackGround extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        String name = params[0];
        String data="";
        int tmp;

        try {
            URL url = new URL("http://myfirstphpapp-mansouri.rhcloud.com/");
            String urlParams = "name="+name;
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(urlParams.getBytes());
            os.flush();
            os.close();
            InputStream is = httpURLConnection.getInputStream();
            while((tmp=is.read())!=-1){
                data+= (char)tmp;
            }
            is.close();
            httpURLConnection.disconnect();
            return data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Exception: "+e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "Exception: "+e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        String err=null;
        try {
            JSONObject root = new JSONObject(s);
            JSONObject user_data = root.getJSONObject("user_data");
            nom = user_data.getString("nom");
            nbusers = user_data.getString("nbusers");
            nbversion = user_data.getString("nbversion");
            nbsmart = user_data.getString("nbsmart");
        } catch (JSONException e) {
            e.printStackTrace();
            err= "Exception: "+e.getMessage();
        }
        Intent i = new Intent(getApplicationContext() , AffichageActivity.class);
        i.putExtra("name", nom);
        i.putExtra("nbusers", nbusers);
        i.putExtra("nbversion", nbversion);
        i.putExtra("nbsmart", nbsmart);
        startActivity(i);
    }
}