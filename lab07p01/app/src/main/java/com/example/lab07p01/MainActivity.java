package com.example.lab07p01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et_login, et_pass;
    Button bt_zaloguj, bt_zarejestruj;

    ArrayList<Osoba> uzytkownicy = new ArrayList<Osoba>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_login = findViewById(R.id.et_login);
        et_pass = findViewById(R.id.et_pass);
        bt_zaloguj = findViewById(R.id.bt_zaloguj);
        bt_zarejestruj = findViewById(R.id.bt_zarejestruj);
        dodajUzytkownikow();
        sluchacz();
    }

    private void dodajUzytkownikow() {
        uzytkownicy.add(new Osoba("Aaaa","a1"));
        uzytkownicy.add(new Osoba("Bbbb","b1"));
        uzytkownicy.add(new Osoba("Cccc","c1"));
    }

    private void sluchacz() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id==R.id.bt_zaloguj)
                    zaloguj();
                else
                    zarejestruj();
            }
        };
        bt_zarejestruj.setOnClickListener(sluchacz);
        bt_zaloguj.setOnClickListener(sluchacz);
    }

    private void zarejestruj() {
    }

    private void zaloguj() {
        String l = et_login.getText().toString();
        String p = et_pass.getText().toString();
        if(sprawdz(l,p))
        {
            Intent intencja = new Intent(getApplicationContext(), MainActivity2.class);
            intencja.putExtra("login", l);
            startActivity(intencja);
        }
        else
            Toast.makeText(this, "Błędny login lub hasło", Toast.LENGTH_SHORT).show();

    }

    private boolean sprawdz(String l, String p) {
        for(int i=0; i<uzytkownicy.size(); i++)
            if(uzytkownicy.get(i).sprawdz(l,p))
                return true;
        return false;
    }
}