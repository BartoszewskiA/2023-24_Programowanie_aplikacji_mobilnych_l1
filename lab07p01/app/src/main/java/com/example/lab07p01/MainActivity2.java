package com.example.lab07p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView zalogowany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        zalogowany = findViewById(R.id.a2_tv_zalogowany);
        String s = getIntent().getExtras().getString("login");
        zalogowany.setText("Zalogowany: "+s );
    }
}