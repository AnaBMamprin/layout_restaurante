package com.example.restaurante;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtConsumo;
    private EditText edtCouvert;
    private EditText edtPessoas;
    private Button btnCalcular;
    private TextView txtTaxa;
    private TextView txtValorTotal;
    private TextView txtValorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtConsumo = findViewById(R.id.edtConsumo);
        edtCouvert = findViewById(R.id.edtCouvert);
        edtPessoas = findViewById(R.id.edtPessoas);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtTaxa = findViewById(R.id.txtTaxa);
        txtValorTotal = findViewById(R.id.txtValorTotal);
        txtValorPessoa = findViewById(R.id.txtValorPessoa);
    }

    public void calcular(View view) {
        double consumo = Double.parseDouble(edtConsumo.getText().toString());
        double couvert = Double.parseDouble(edtCouvert.getText().toString());
        int pessoas = Integer.parseInt(edtPessoas.getText().toString());
        double valorTotal = 0;
        double valorPessoa;

        valorTotal = (consumo + couvert + (0.10*consumo));
        valorPessoa = valorTotal/pessoas;
        DecimalFormat df = new DecimalFormat("0.00");

        txtTaxa.setText("" + df.format(0.10*consumo));
        txtValorTotal.setText("" + df.format(valorTotal));
        txtValorPessoa.setText("" + df.format(valorPessoa));
        Toast.makeText(MainActivity.this, "Obrigada pela preferência!", Toast.LENGTH_LONG).show();




    }
}