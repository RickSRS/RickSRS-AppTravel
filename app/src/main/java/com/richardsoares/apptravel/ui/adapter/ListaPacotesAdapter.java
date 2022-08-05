package com.richardsoares.apptravel.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.richardsoares.apptravel.R;
import com.richardsoares.apptravel.model.Pacote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int index) {
        return pacotes.get(index);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int index, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(index);
        exibeLocal(viewCriada, pacote);
        exibeImagem(viewCriada, pacote);
        exibeDias(viewCriada, pacote);
        exibePreco(viewCriada, pacote);

        return viewCriada;
    }

    private void exibePreco(View viewCriada, Pacote pacote) {
        TextView pacotePreco = viewCriada.findViewById(R.id.item_pacote_preco);
        BigDecimal precoPacote = pacote.getPreco();
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String precoFormatado = formatoBrasileiro
                .format(precoPacote)
                .replace("R$", "R$ ");
        pacotePreco.setText(precoFormatado);
    }

    private void exibeDias(View viewCriada, Pacote pacote) {
        TextView pacoteDias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = "";
        int qtdDias = pacote.getDias();
        if (qtdDias > 1) {
            diasEmTexto = qtdDias + " dias";
        } else {
            diasEmTexto = qtdDias + " dia";
        }
        pacoteDias.setText(diasEmTexto);
    }

    private void exibeImagem(View viewCriada, Pacote pacote) {
        ImageView pacoteImagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(pacote.getImagem(),
                "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        pacoteImagem.setImageDrawable(drawableImagemPacote);
    }

    private void exibeLocal(View viewCriada, Pacote pacote) {
        TextView pacoteLocal = viewCriada.findViewById(R.id.item_pacote_local);
        pacoteLocal.setText(pacote.getLocal());
    }
}
