package com.example.dell.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boutonCalculer = null;
    Button boutonRemiseaZero = null;
    EditText poids;
    TextView resultat;
    EditText taille;


    private View.OnClickListener clickListenerBouton = new View.OnClickListener() {
        @Override
        public void onClick(View vue) {

            double nombrePoids;
            double nombreTaille;
            double nombreImc ;
            switch (vue.getId()) {
                case R.id.calcul:
                    try {
                        nombrePoids = Double.parseDouble(poids.getText().toString());
                        nombreTaille = Double.parseDouble(taille.getText().toString());
                        RadioButton radioButton1=(RadioButton)findViewById(R.id.radioButtonCentimetre);

                        if ((nombrePoids > 0) && (nombreTaille > 0)) {
                            if (radioButton1.isChecked()) {
                                nombreTaille = nombreTaille / 100;
                            }

                            nombreImc = nombrePoids / (Math.pow(nombreTaille, 2));
                            resultat.setText("IMC = " + nombreImc);
                        }
                        else {
                            messsageErreur("erreur");
                        }
                    } catch (Exception e) {
                        messsageErreur("erreur champ vide");
                    }
                    break;

                case R.id.effacer:
                    poids.setText("");
                    taille.setText("");
                    resultat.setText(R.string.app_name);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonCalculer = (Button) findViewById(R.id.calcul);
        boutonRemiseaZero = (Button) findViewById(R.id.effacer);

        resultat = (TextView) findViewById(R.id.resultat);
        poids = (EditText) findViewById(R.id.poids);
        taille = (EditText) findViewById(R.id.taille);
        boutonCalculer.setOnClickListener(clickListenerBouton);
        boutonRemiseaZero.setOnClickListener(clickListenerBouton);

        poids.addTextChangedListener(observateur);
        taille.addTextChangedListener(observateur);
    }
    TextWatcher observateur = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            resultat.setText(R.string.app_name);
        }
    };



    public void messsageErreur(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
