package com.example.mycolas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btnColas, btnRuta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnColas = findViewById(R.id.Turnobtn);
        btnRuta = findViewById(R.id.Rutabtn);
    }

    // Metodo OnCLick Listener para cuando se pulsa boton enlazar con otra activity
    public void onClickTurno(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.imagen_click));
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }

    public void onClickRuta(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.imagen_click));
        //Intent intent = new Intent(this, InsertActivity.class);
        //startActivity(intent);
    }
}
