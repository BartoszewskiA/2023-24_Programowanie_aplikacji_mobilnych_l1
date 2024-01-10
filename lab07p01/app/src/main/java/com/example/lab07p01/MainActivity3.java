package com.example.lab07p01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {


    EditText et_login, et_pass1, et_pass2;
    Button bt_dodaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        et_login = findViewById(R.id.a3_et_login);
        et_pass1 = findViewById(R.id.a3_et_pass1);
        et_pass2 = findViewById(R.id.a3_et_pass2);
        bt_dodaj = findViewById(R.id.a3_bt_dodaj);
        bt_dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odpowiedz();
            }
        });
    }

    private void odpowiedz() {
        if(walidacja())
        {
            Intent odp = new Intent();
            odp.putExtra("l", et_login.getText().toString());
            odp.putExtra("p", et_pass1.getText().toString());
            setResult(RESULT_OK,odp);
            finish();
        }
    }

    private boolean walidacja()
    {
        String login = et_login.getText().toString();
        String pass1 = et_pass1.getText().toString();
        String pass2 = et_pass2.getText().toString();
        if(login.isEmpty())
        {
            Toast.makeText(this, "Pole Login musi być wypełnione", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pass1.isEmpty())
        {
            Toast.makeText(this, "Pole Hasło musi być wypełnione", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pass1.equals(pass2)==false)
        {
            Toast.makeText(this, "Hasła nie są zgodne", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}