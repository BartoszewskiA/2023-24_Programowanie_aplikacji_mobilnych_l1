package com.example.lab03p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dana1, dana2, dana3, wynik;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dana1 = findViewById(R.id.editText01);
        dana2 = findViewById(R.id.editText02);
        dana3 = findViewById(R.id.editText03);
        wynik = findViewById(R.id.editText04);
        button = findViewById(R.id.button01);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licz();
            }
        });
        
    }

    private void licz() {
        String s1 = dana1.getText().toString();
        if(s1.length()==0)
        {
            Toast.makeText(this, "Pole 1 nie może być puste\"", Toast.LENGTH_LONG).show();
            return;
        }
        String s2 = dana2.getText().toString();
        if(s2.length()==0)
        {
            Toast.makeText(this, "Pole 2 nie może być puste\"", Toast.LENGTH_LONG).show();
            return;
        }
        String s3 = dana3.getText().toString();
        if(s3.length()==0)
        {
            Toast.makeText(this, "Pole 3 nie może być puste\"", Toast.LENGTH_LONG).show();
            return;
        }

        int x1 = Integer.parseInt(s1);
        int x2 = Integer.parseInt(s2);
        int x3 = Integer.parseInt(s3);
        int suma = x1 + x2 + x3;
        wynik.setText(String.valueOf(suma));
    }
}