package com.example.lab03p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText pole1, pole2, poleWynik;
    Button przycisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pole1 = findViewById(R.id.editText01);
        pole2 = findViewById(R.id.editText02);
        poleWynik = findViewById(R.id.editText03);
        przycisk = findViewById(R.id.button01);
        
        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licz();
            }
        });
    }

    private void licz() {
        String s1 = pole1.getText().toString();
        if(s1.length()==0)
        {
            Toast.makeText(this, "Pole 1 nie może być puste", Toast.LENGTH_SHORT).show();
            return;
        }
        String s2 = pole2.getText().toString();
        if(s2.length()==0)
        {
            Toast.makeText(this, "Pole 2 nie może być puste", Toast.LENGTH_SHORT).show();
            return;
        }

        int x1 = Integer.parseInt(s1);
        int x2 = Integer.parseInt(s2);
        int wynik = x1+x2;
        poleWynik.setText(String.valueOf(wynik));
    }
}