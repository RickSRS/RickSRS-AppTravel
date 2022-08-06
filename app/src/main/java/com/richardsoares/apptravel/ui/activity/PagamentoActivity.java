package com.richardsoares.apptravel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.richardsoares.apptravel.R;
import com.richardsoares.apptravel.model.Pacote;
import com.richardsoares.apptravel.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        exibePreco(pacote);
    }

    private void exibePreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String moedaBrasileira = MoedaUtil.formataMoedaParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}