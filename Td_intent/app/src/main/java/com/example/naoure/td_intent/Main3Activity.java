package com.example.naoure.td_intent;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    ImageView imageView;
    Bundle extra;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        extra = getIntent().getExtras();
        textView=(TextView)findViewById(R.id.txt);
        textView2=(TextView)findViewById(R.id.info);
        imageView=(ImageView)findViewById(R.id.image);
        fichierxml();
      //  baseD(extra.getString("info"));



    }
    void fichierxml(){
        List<Os> oss = null;
        try {
            InputStream inputstream = this.getAssets().open("information");
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myparser = xmlFactoryObject.newPullParser();
            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            myparser.setInput(inputstream, null);
            XMLHandler h=new XMLHandler();
            oss=h.parse(myparser);
            for(int i=0;i<oss.size();i++)
                if(oss.get(i).name.toLowerCase().equals(extra.getString("info").toLowerCase())){
                    textView.setText(oss.get(i).name);
                    textView2.setText(oss.get(i).info);
                    int drawableId = getResources().getIdentifier(oss.get(i).img, "drawable", getPackageName());
                    imageView.setImageResource(drawableId);
                }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
    void baseD(String x){
        mydb =new DBHelper(this);
        mydb.insertOs("android","blablabla","android");
        mydb.insertOs("ios","blablabla","ios");
        mydb.insertOs("windows 8","blablabla","windowsphone");
        Cursor rs=mydb.getData(x.toLowerCase());
        rs.moveToFirst();
        String name=rs.getString(rs.getColumnIndex(DBHelper.OS_COLUMN_NAME));
        String info = rs.getString(rs.getColumnIndex(DBHelper.OS_COLUMN_INFO));
        String img = rs.getString(rs.getColumnIndex(DBHelper.OS_COLUMN_IMG));
        textView.setText(name);
        textView2.setText(info);
        int drawableId = getResources().getIdentifier(img, "drawable", getPackageName());
        imageView.setImageResource(drawableId);


    }
}
