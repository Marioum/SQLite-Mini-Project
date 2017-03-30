package edu.dhib.tpintentoperationsystems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OsDescritpionActivity extends AppCompatActivity {

    TextView name,description,nbreU,nbreV,nbreS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_descritpion);
        Bundle extras=getIntent().getExtras();
        name=(TextView)findViewById(R.id.tv_osname);
        description=(TextView)findViewById(R.id.tv_description);
        nbreU=(TextView)findViewById(R.id.tv_nbreU);
        nbreV=(TextView)findViewById(R.id.tv_nbreV);
        nbreS=(TextView)findViewById(R.id.tv_nbreS);
        name.setText(extras.getString("Name"));
        description.setText(extras.getString("Description"));
        nbreU.setText(extras.getString("nbreU"));
        nbreV.setText(extras.getString("nbreV"));
        nbreS.setText(extras.getString("nbreS"));
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_os_descritpion, menu);
        return true;
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
}
