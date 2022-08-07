package com.richardsoares.apptravel.ui.activity;

import static com.richardsoares.apptravel.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.richardsoares.apptravel.R;
import com.richardsoares.apptravel.model.Pacote;
import com.richardsoares.apptravel.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            exibePreco(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button finalizaCompra = findViewById(R.id.pagamento_btn_finaliza_compra);
        finalizaCompra.setOnClickListener(v -> vaiParaResumo(pacote));
    }

    private void vaiParaResumo(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void exibePreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String moedaBrasileira = MoedaUtil.formataMoedaParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}