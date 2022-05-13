package br.edu.edu.appcalculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class    MainActivity extends AppCompatActivity {

    EditText editPeso;
    EditText editAltura;
    Button btCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoVerificar();
    }

    protected void carregaComponentes() {
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        btCalcular = findViewById(R.id.btCalcular);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoVerificar() {
        btCalcular.setOnClickListener(view -> {
            Toast.makeText(this, "Calculando", Toast.LENGTH_SHORT).show();
            String resultado = realizaCalculo();
            exibiResultado(resultado);
            limpaCampos();
        });
    }

    protected String realizaCalculo() {
        double peso = editPeso.getText().length()>0? Double.parseDouble(editPeso.getText().toString()):0;
        double altura =editAltura.getText().length()>0? Double.parseDouble(editAltura.getText().toString()):0;
        double res = peso/(altura * altura);

        String resultado_imc = "";
        if (res <16) {
            Toast.makeText(this, "Magreza grave", Toast.LENGTH_SHORT).show();
            resultado_imc = "Magreza grave.";
        }else if ( (res >=16) && (res <17)){
            Toast.makeText(this, "Magreza moderada", Toast.LENGTH_SHORT).show();
            resultado_imc = "Magreza moderada.";
        }else if ( (res >=17) && (res <18.5)) {
            Toast.makeText(this, "Magreza leve", Toast.LENGTH_SHORT).show();
            resultado_imc = "Magreza leve.";
        }else if ( (res >=18.5) && (res <25)) {
            Toast.makeText(this, "Saldavel", Toast.LENGTH_SHORT).show();
            resultado_imc = "Saudável.";
        }else if ( (res >=25) && (res <30)) {
            Toast.makeText(this, "Sobrepeso", Toast.LENGTH_SHORT).show();
            resultado_imc = "Sobrepeso.";
        }else if ( (res >=30) && (res <35)) {
            Toast.makeText(this, "Obesidade Grau I", Toast.LENGTH_SHORT).show();
            resultado_imc = "Obesidade Grau I.";
        }else if ( (res >=35) && (res <40)) {
            Toast.makeText(this, "Obesidade Grau II", Toast.LENGTH_SHORT).show();
            resultado_imc = "Obesidade Grau II.";
        }else if ( res>40){
            Toast.makeText(this, "Obesidade Grau III", Toast.LENGTH_SHORT).show();
            resultado_imc = "Obsesidade Grau III.";
        }
        else Toast.makeText(this, "Dados invalido", Toast.LENGTH_SHORT).show();
        return resultado_imc;

    }

    protected void exibiResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        editPeso.setText("");
        editAltura.setText("");
        editAltura.requestFocus();
    }
};
