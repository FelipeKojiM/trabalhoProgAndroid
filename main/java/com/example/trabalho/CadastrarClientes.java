package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabalho.Controlers.ControlerClientes;
import com.example.trabalho.classes.Clientes;

public class CadastrarClientes extends AppCompatActivity {

    private EditText edNomeCliente;
    private EditText edCpfCliente;
    private TextView tvListaClientes;
    private Button btCadastrarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_clientes);
        edNomeCliente = findViewById(R.id.edNomeCliente);
        edCpfCliente = findViewById(R.id.edCpfCliente);
        tvListaClientes = findViewById(R.id.tvListaClientes);
        btCadastrarCliente = findViewById(R.id.btCadastrarCliente);

        atualizarListaClientes();

        btCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarClientes();
            }
        });
    }

    private void salvarClientes() {
        int cpf;
        if (edCpfCliente.getText().toString().isEmpty()) {
            edCpfCliente.setError("Um Cpf deve ser informado!");
            return;
        } else {
            try {
                cpf = Integer.parseInt(edCpfCliente.getText().toString());
            } catch (Exception ex) {
                edCpfCliente.setError("Informe somente números!");
                return;
            }
        }
        if (edNomeCliente.getText().toString().isEmpty()) {
            edNomeCliente.setError("O nome do Cliente deve ser informado!");
            return;
        }

        Clientes clientes = new Clientes();
        clientes.setNome(edNomeCliente.getText().toString());
        clientes.setCpf(edCpfCliente.getText().toString());

        ControlerClientes.getInstanciaCliente().salvarClientes(clientes);

        Toast.makeText(CadastrarClientes.this,"Cliente" +
                " cadastrado com sucesso!",Toast.LENGTH_LONG).show();

        finish();
    }

    private void atualizarListaClientes() {
        String texto = "";
        for (Clientes clientes : ControlerClientes.getInstanciaCliente().retornarClientes()) {
            texto += "Nome: " + clientes.getNome() + "\n" +
                    "CPF: " + clientes.getCpf() + "\n" +
                    "-----------------------------------------\n";
        }
        tvListaClientes.setText(texto);

    }
}