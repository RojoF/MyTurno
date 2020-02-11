package com.example.mycolas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Metodo OnCLick Listener para cuando se pulsa boton enlazar con otra activity
    public void onClickFab (View v) {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }
}
