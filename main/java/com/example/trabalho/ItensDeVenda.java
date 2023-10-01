package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho.Controlers.ControlerItens;
import com.example.trabalho.classes.Itens;

public class ItensDeVenda extends AppCompatActivity {

    private EditText edCodigoItem;
    private EditText edDescricaoItem;
    private EditText edValorItem;
    private Button btCadastrarItem;
    private EditText edNomeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_de_venda);

        edCodigoItem = findViewById(R.id.edCodigoItem);
        edDescricaoItem = findViewById(R.id.edDescricaoItem);
        edValorItem = findViewById(R.id.edValorItem);
        btCadastrarItem = findViewById(R.id.btCadastrarItem);
        edNomeItem = findViewById(R.id.edNomeItem);

        btCadastrarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroItem();
                onRestart();
            }
        });
    }

    private void cadastroItem() {
            if(edNomeItem.getText().toString().isEmpty()){
                edNomeItem.setError("Informe o nome do item!");
                return;
            }
            if(edCodigoItem.getText().toString().isEmpty()){
                edCodigoItem.setError("Informe o código do item!");
                return;
            }
            if(edDescricaoItem.getText().toString().isEmpty()){
                edDescricaoItem.setError("Informe a descrição do item!");
                return;
            }
            if(edValorItem.getText().toString().isEmpty()){
                edValorItem.setError("Informe o valor do item!");
                return;
            }

            Itens itens = new Itens();
            itens.setCodigo(Integer.parseInt(edCodigoItem.getText().toString()));
            itens.setValor(Double.parseDouble(edValorItem.getText().toString()));
            itens.setNome(edNomeItem.getText().toString());
            itens.setDescricao(edDescricaoItem.getText().toString());

            ControlerItens.getInstanciaItem().salvarItens(itens);
            finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(ItensDeVenda.this,"Item" +
                " cadastrado com sucesso!",Toast.LENGTH_LONG).show();
    }
}