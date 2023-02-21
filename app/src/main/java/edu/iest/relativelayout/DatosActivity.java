package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {
    TextView tvCanal;
    TextView tvPrograma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_datos);
        tvPrograma  = findViewById(R.id.tvPrograma);
        tvCanal =  findViewById(R.id.tvCanal);
        Button bnRegresar = findViewById(R.id.bnRegresar);
        String canal = getIntent().getStringExtra("canal");
        String programa = getIntent().getStringExtra("programa");
        tvCanal.setText(canal);
        tvPrograma.setText(programa);

        bnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(DatosActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}