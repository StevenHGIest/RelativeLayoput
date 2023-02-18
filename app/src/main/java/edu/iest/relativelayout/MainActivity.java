package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView  ivContinuara = findViewById(R.id.ivContinuara);
    String spText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button bnCanal = findViewById(R.id.btnCambiar);
        EditText etCanal = findViewById(R.id.etCanal);
        TextView tvCanal = findViewById(R.id.tvCanal);
        Spinner spProgramas = findViewById(R.id.spProgramas);

       spProgramas.setOnItemSelectedListener(this);
        bnCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aqui se coloca la logica del click
                // obtendremos elvalor del editText y lo asignaremos al textView inferior
                String texto = etCanal.getText().toString();
                // Como esta dentro pónemos la vitas donde esta para que sepa donde se tiene que estar
                Toast.makeText(MainActivity.this, "El valor era "+texto, Toast.LENGTH_LONG).show();
                tvCanal.setText(texto);
            }
        });

        ivContinuara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DatosActivity.class);
                i.putExtra("programa", spText);
                i.putExtra("canal", etCanal.toString());
                startActivity(i);
            }
        });

    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
        spText = adapterView.getItemAtPosition(posicion).toString();
        Snackbar.make(adapterView, "Programa seleccionado"+spText, Snackbar.LENGTH_LONG).show();

        if (posicion == 0) {
            ivContinuara.setImageResource(R.drawable.tbclt);
        }else if (posicion == 1) {
            ivContinuara.setImageResource(R.drawable.tbcontinued);
        }else if (posicion == 2){
            ivContinuara.setImageResource(R.drawable.tbcop);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}