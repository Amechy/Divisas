package com.example.divisas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//-------------------------------------------------
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    double Euro = 0d;
    double Dolar = 0d;
    double valorDivisa = 1.18d;
    Button convertirDivisa;
    EditText etxEuro;
    EditText etxDolar;
    RadioButton rbtnDolar;
    RadioButton rbtnEuro;
    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertirDivisa = (Button) findViewById(R.id.btnConvertir);
        convertirDivisa.setOnClickListener(this);
        rbtnDolar = (RadioButton) findViewById(R.id.rbtnDolar);
        rbtnEuro = (RadioButton) findViewById(R.id.rbtnEuro);
    }

    @Override
    public void onClick(View view) {
        if (rbtnDolar.isChecked()) {
            etxDolar = (EditText) findViewById(R.id.etxDolar);
            etxEuro = (EditText) findViewById(R.id.etxEuro);
            if (etxDolar.getText().length() > 0) {
                Dolar = Double.parseDouble(etxDolar.getText().toString());
                Euro = Double.parseDouble(etxEuro.getText().toString());
                resultado = String.valueOf(Dolar * valorDivisa);
                etxEuro.setText(resultado);
            } else {
                etxDolar.setText("1");
            }


        } else {
            if (rbtnEuro.isChecked()) {
                etxEuro = (EditText) findViewById(R.id.etxEuro);
                etxDolar = (EditText) findViewById(R.id.etxDolar);
                if (etxEuro.getText().length() > 0) {
                    Euro = Double.parseDouble(etxEuro.getText().toString());
                    Dolar = Double.parseDouble(etxDolar.getText().toString());
                    resultado = String.valueOf(Euro / valorDivisa);
                    etxDolar.setText(resultado);
                } else {
                    etxEuro.setText("1");
                }
            }
        }
    }
}
