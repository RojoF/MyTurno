package com.example.mycolas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
            }


    public void onClickfabs (View v) {
        Intent intent = new Intent(this, ScrollingActivity.class);
        startActivity(intent);
    }
}