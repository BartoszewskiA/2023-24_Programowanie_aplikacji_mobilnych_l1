package com.example.lab03p03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

/*   Button bt_tak = findViewById(R.id.bt_tak);
   Button bt_nie = findViewById(R.id.bt_nie);*/
    /*TextView tv_wynik;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button bt_tak = findViewById(R.id.bt_tak);
       final Button bt_nie = findViewById(R.id.bt_nie);
        final TextView tv_wynik = findViewById(R.id.tv_wynik);

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id==R.id.bt_tak)
                    tv_wynik.setText("TAK");
                else if (id==R.id.bt_nie)
                            tv_wynik.setText("NIE");
              /* switch (id)
               {
                   case R.id.bt_tak: break;
               }*/
            }
        };
        bt_tak.setOnClickListener(sluchacz);
        bt_nie.setOnClickListener(sluchacz);

    }
}