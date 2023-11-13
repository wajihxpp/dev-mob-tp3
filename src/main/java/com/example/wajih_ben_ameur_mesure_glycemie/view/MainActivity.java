package com.example.wajih_ben_ameur_mesure_glycemie.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wajih_ben_ameur_mesure_glycemie.R;
import com.example.wajih_ben_ameur_mesure_glycemie.model.Patient;
import com.example.wajih_ben_ameur_mesure_glycemie.controller.Controller;

public class MainActivity extends AppCompatActivity {

    private EditText etValeur;
    private SeekBar sbAge;
    private RadioButton rbtOui;
    private RadioButton rbtNon;
    private Button btnConsulter;
    private TextView resultTextView;
    private TextView tvAge;
    private Patient patient;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAge.setText("Votre âge : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Handle the start of SeekBar tracking (if needed)
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Handle the end of SeekBar tracking (if needed)
            }
        });

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int age = sbAge.getProgress();
                EditText etValeur = findViewById(R.id.etValeur);
                float valeur = Float.parseFloat(etValeur.getText().toString());
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                boolean isFasting = radioGroup.getCheckedRadioButtonId() == R.id.rbtOui;
                if (radioGroup.getCheckedRadioButtonId() == R.id.rbtNon) {
                    isFasting = false;
                }
                controller.handleUserInput(age, valeur, isFasting);
            }
        });
    }

    private void init() {
        etValeur = findViewById(R.id.etValeur);
        sbAge = findViewById(R.id.sbAge);
        rbtOui = findViewById(R.id.rbtOui);
        rbtNon = findViewById(R.id.rbtNon);
        btnConsulter = findViewById(R.id.btnConsulter);
        resultTextView = findViewById(R.id.resultTextView);
        tvAge = findViewById(R.id.tvAge);
        controller = new Controller(this);
    }

    public void updateUI(String result) {
        resultTextView.setText(result);
    }
}
