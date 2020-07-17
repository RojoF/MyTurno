package com.example.mycolas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class InsertActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";
    private static final String[] COLAS = {
            "1",
            "2",
            "3",
            "4"

    };
    Button btnOk;
    int spin_uno = -1;
    MaterialSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        btnOk = (Button) findViewById(R.id.btnBuscar);
        spinner = findViewById(R.id.spin);
        spinner.setItems(COLAS);

        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, getString(R.string.seleccion_spin) + item, Snackbar.LENGTH_LONG).show();
                spin_uno = position;
            }
        });

        spinner.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override
            public void onNothingSelected(MaterialSpinner spinner) {
                Snackbar.make(spinner, getString(R.string.seleccion_spin_dos), Snackbar.LENGTH_LONG).show();
            }
        });

    }

    public void onClickbtnRedondo(View v) {

        //Comprobamos que no estén vacios sino lo esta continua con la siguiente activity

        if (spin_uno >= 0) {
            Intent intent = new Intent(this, ScrollingActivity.class);
            //String message = spinner.getText().toString();
            String valor = String.valueOf(spinner.getText());
            //int num = Integer.valueOf(valor);
            intent.putExtra(EXTRA_MESSAGE, valor);
            startActivity(intent);
        } else {

            // Si esta vacío lanza notificacion Toast con un @String
            Toast toast1 = Toast.makeText(getApplicationContext(), getString(R.string.notification), Toast.LENGTH_LONG);
            toast1.show();
        }
    }
}