package com.example.lab05p01_atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] grafiki = new int[] {
            R.drawable.muchomor,
            R.drawable.borowik,
            R.drawable.maslak
        };

    String[] nazwy;
    String[] opisy;
    int pozycja = 0;
    TextView tv_nazwa, tv_opis;
    ImageView iv_grafika;
    Button bt_next, bt_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        przygotujZasoby();
        odswierzAktywnosc();
        sluchaczeZdarzen();
    }

    private void sluchaczeZdarzen() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id == R.id.button02)
                {
                    if(pozycja<grafiki.length-1)
                        pozycja++;
                    else
                        pozycja=0;
                }
                else
                {
                    if(pozycja>0)
                        pozycja--;
                    else
                        pozycja=grafiki.length-1;
                }
                odswierzAktywnosc();
            }
        };
        bt_next.setOnClickListener(sluchacz);
        bt_back.setOnClickListener(sluchacz);
    }

    private void odswierzAktywnosc() {
        tv_nazwa.setText(nazwy[pozycja]);
        tv_opis.setText(opisy[pozycja]);
        iv_grafika.setImageResource(grafiki[pozycja]);
    }

    private void przygotujZasoby() {
        nazwy = getResources().getStringArray(R.array.names);
        opisy = getResources().getStringArray(R.array.descriptions);
        tv_nazwa = findViewById(R.id.textView02);
        tv_opis = findViewById(R.id.textView03);
        iv_grafika = findViewById(R.id.imageView01);
        bt_back = findViewById(R.id.button01);
        bt_next = findViewById(R.id.button02);
    }
}