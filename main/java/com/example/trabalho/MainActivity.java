package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btClientes;
    private Button btItens;
    private Button btLancarPedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btClientes = findViewById(R.id.btClientes);
        btItens= findViewById(R.id.btItens);
        btLancarPedido= findViewById(R.id.btLancarPedido);

        btClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { cadastroCliente();} });

        btItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { cadastroListaItens();} });

        btLancarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { lancarPedido();} });
    }

    public void cadastroCliente(){
        Intent intent = new Intent(MainActivity.this, CadastrarClientes.class);
        startActivity(intent);
    }
    public void cadastroListaItens(){
        Intent intent = new Intent(MainActivity.this, ItensDeVenda.class);
        startActivity(intent);
    }
    public void lancarPedido(){
        Intent intent = new Intent(MainActivity.this, LancarPedido.class);
        startActivity(intent);
    }

    //Override
    //protected void onRestart() {
        //super.onRestart();
        //Toast.makeText(MainActivity.this,"Pedido\n" +
                //"de venda foi cadastrado com sucesso!",Toast.LENGTH_LONG).show();
    //}
}