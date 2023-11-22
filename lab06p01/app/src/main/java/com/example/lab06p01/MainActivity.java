package com.example.lab06p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_opis, tv_wynik;
    Button bt_licz;
    EditText et_dana;
    RadioGroup rg_dana;
    RadioButton rb_srednica, rb_promien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_opis = findViewById(R.id.tv_opis);
        tv_wynik = findViewById(R.id.tv_wynik);
        bt_licz = findViewById(R.id.bt_licz);
        rg_dana = findViewById(R.id.rg_dana);
        et_dana = findViewById(R.id.et_dana);
        rb_srednica = findViewById(R.id.rb_srednica);
        rb_promien = findViewById(R.id.rb_promien);
        sluchaczPrzycisku();
        sluchaczRadioGroup();
    }

    private void sluchaczRadioGroup() {
        rg_dana.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_promien)
                    tv_opis.setText("r:");
                else
                    tv_opis.setText("d:");
            }
        });
    }


    private void sluchaczPrzycisku() {
        bt_licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et_dana.getText().toString();
                if(s.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Brak danych", Toast.LENGTH_SHORT).show();
                    return;
                }
                double r = Double.parseDouble(s);
                double obwod, pole;
                if(rb_promien.isChecked()) {
                    obwod = 2 * Math.PI * r;
                    pole = Math.PI * r * r;
                }
                else
                {
                    obwod = Math.PI * r;
                    pole = Math.PI * Math.pow((r/2),2);
                }

                pole *= 1000;
                pole = Math.round(pole);
                pole /= 1000;
                obwod *=1000;
                obwod = Math.round(obwod);
                obwod /= 1000;

                String w = "";
                w+="Obwód=";
                w+=String.valueOf(obwod);
                w+="\n";
                w+="Pole=";
                w+=String.valueOf(pole);

                tv_wynik.setText(w);

            }
        });
    }
}