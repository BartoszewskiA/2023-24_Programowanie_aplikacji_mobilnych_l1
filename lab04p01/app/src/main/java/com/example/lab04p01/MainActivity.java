package com.example.lab04p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    char[] znaki = {'A','B','C','D','a','b','c','d','0','1','2','3','4','5','6','7','8','9','@','#'};

    final int MIN = 5;
    final int MAX = 30;
    Random random;

    EditText et_ile, et_wynik;
    SeekBar sb_ile;
    Button bt_generuj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        et_ile = findViewById(R.id.editText01);
        sb_ile = findViewById(R.id.seekBar01);
        et_wynik = findViewById(R.id.editText02);
        bt_generuj = findViewById(R.id.button01);
        sb_ile.setMin(MIN);
        sb_ile.setMax(MAX);
        sb_ile.setProgress(10);
        et_ile.setText(String.valueOf(sb_ile.getProgress()));
        sluchaczSuwaka();
        sluchaczPrzycisku();
    }

    private void sluchaczPrzycisku() {
        bt_generuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_wynik.setText(losujHaslo(sb_ile.getProgress()));
            }
        });
    }

    private void sluchaczSuwaka() {
        sb_ile.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                et_ile.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    String losujHaslo(int ileZnakow)
    {
        String wynik = "";
        for(int i=0; i<ileZnakow; i++)
            wynik+=znaki[random.nextInt(znaki.length)];
        return wynik;
    }
}