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
import com.richardsoares.apptravel.ui.model.Pacote;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

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

        TextView pacoteLocal = viewCriada.findViewById(R.id.item_pacote_local);
        pacoteLocal.setText(pacote.getLocal());

        ImageView pacoteImagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(pacote.getImagem(),
                "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        pacoteImagem.setImageDrawable(drawableImagemPacote);

        TextView pacoteDias = viewCriada.findViewById(R.id.item_pacote_dias);
        pacoteDias.setText(pacote.getDias() + "dias");

        TextView pacotePreco = viewCriada.findViewById(R.id.item_pacote_preco);
        pacotePreco.setText(pacote.getPreco().toString());

        return viewCriada;
    }
}
