package com.example.naoure.td_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button=(Button)findViewById(R.id.btn_save);
        Button button2=(Button)findViewById(R.id.btn_back);
        final EditText editText=(EditText)findViewById(R.id.os);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("item", editText.getText().toString());
                setResult(RESULT_OK, intent);
                Toast.makeText(getApplicationContext(),"SAVE",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED); finish();
            }
        });

    }
}
