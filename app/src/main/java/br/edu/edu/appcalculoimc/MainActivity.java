package br.edu.edu.appcalculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        btCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String resultado = realizaCalculo();
                exibiResultado(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        double peso = editPeso.getText().length()>0? Double.parseDouble(editPeso.getText().toString()):0;
        double altura =editAltura.getText().length()>0? Double.parseDouble(editAltura.getText().toString()):0;
        double res = peso/(altura * altura);

        String resultado_imc = "";
        if (res <16) {
            resultado_imc = "Magreza grave.";
        }else if ( (res >=16) && (res <17)){
            resultado_imc = "Magreza moderada.";
        }else if ( (res >=17) && (res <18.5)) {
            resultado_imc = "Magreza leve.";
        }else if ( (res >=18.5) && (res <25)) {
            resultado_imc = "Saudável.";
        }else if ( (res >=25) && (res <30)) {
            resultado_imc = "Sobrepeso.";
        }else if ( (res >=30) && (res <35)) {
            resultado_imc = "Obesidade Grau I.";
        }else if ( (res >=35) && (res <40)) {
            resultado_imc = "Obesidade Grau II.";
        }else if ( res>40){
            resultado_imc = "Obsesidade Grau III.";
        }
        else resultado_imc= "Tente novamente!";
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
