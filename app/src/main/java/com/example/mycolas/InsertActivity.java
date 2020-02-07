package com.example.mycolas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {

    Button btnOk;
    EditText textTurno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        btnOk = (Button) findViewById(R.id.btnBuscar);
        textTurno = (EditText) findViewById(R.id.nTurno);

    }


    public void onClickbtnRedondo(View v) {
        int a = 0;
        //Comprobamos que no estén vacios sino lo esta continua con la siguiente activity
        if (textTurno.getText().toString().trim().length() > 0) {
            a = Integer.valueOf(textTurno.getText().toString());

            Intent intent = new Intent(this, ScrollingActivity.class);
            startActivity(intent);
        }
        else {

            // Si esta vacío lanza notificacion Toast con un @String
            Toast toast1 = Toast.makeText(getApplicationContext(), getString(R.string.notification), Toast.LENGTH_LONG);

            toast1.show();
        }
    }
}