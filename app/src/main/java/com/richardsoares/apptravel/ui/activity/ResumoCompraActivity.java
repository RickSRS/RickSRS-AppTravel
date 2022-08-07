package com.richardsoares.apptravel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.richardsoares.apptravel.R;
import com.richardsoares.apptravel.model.Pacote;
import com.richardsoares.apptravel.util.DataUtil;
import com.richardsoares.apptravel.util.MoedaUtil;
import com.richardsoares.apptravel.util.ResourceUtil;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle("Resumo da Compra");

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());

        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawablePacote = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);

        TextView data = findViewById(R.id.resumo_compra_data);
        String periodoEmTexto = DataUtil.PeriodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);

        TextView preco = findViewById(R.id.resumo_compra_preco);
        String moedaBrasileira = MoedaUtil.formataMoedaParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}