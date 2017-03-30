package com.example.dell.authentification;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText email,pwd;
    String Email,Pwd;
    Context ctx=this;
    String EMAIL=null, PWD=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText) findViewById(R.id.editText2);
        pwd=(EditText) findViewById(R.id.editText3);
    }

   public void main_login(View v){
       Email= email.getText().toString();
       Pwd=pwd.getText().toString();
       BackGround b = new BackGround();
       b.execute(Email, Pwd);
   }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String email = params[0];
            String pwd = params[1];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://127.0.0.1:90/my%20portable%20files/login.php");
                String urlParams = "email="+email+"&pwd="+pwd;

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
                EMAIL = user_data.getString("email");
                PWD = user_data.getString("pwd");
            } catch (JSONException e) {
                e.printStackTrace();
                err = "Exception: "+e.getMessage();
            }

            Intent i = new Intent(ctx, Home.class);
            i.putExtra("email", EMAIL);
            i.putExtra("pwd", PWD);
            i.putExtra("err", err);
            startActivity(i);

        }
    }
}