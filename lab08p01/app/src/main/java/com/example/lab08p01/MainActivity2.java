package com.example.lab08p01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity implements GestureDetector.OnGestureListener {

    ImageView obrazek;
    GestureDetector detektor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        obrazek = findViewById(R.id.a2_iv);
        Bundle paczka = getIntent().getExtras();
        int grafika = paczka.getInt("id");
        obrazek.setImageResource(grafika);
        detektor = new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detektor.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        float dx = e2.getX() - e1.getX();
        float dy = e2.getY() - e1.getY();
        if(Math.abs(dy)>Math.abs(dx))
            if(dy>0)
                finish();

        return false;
    }
}