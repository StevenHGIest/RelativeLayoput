package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        String canal = getIntent().getStringExtra("canal");
        String programa = getIntent().getStringExtra("programa");

    }
}