package com.richardsoares.apptravel.ui.activity;

import static com.richardsoares.apptravel.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.richardsoares.apptravel.R;
import com.richardsoares.apptravel.dao.PacoteDAO;
import com.richardsoares.apptravel.model.Pacote;
import com.richardsoares.apptravel.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();

        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaPacotes.setOnItemClickListener((parent, view, index, id) -> {
            Pacote pacoteSelecionado = pacotes.get(index);
            vaiParaResumoPacote(pacoteSelecionado);
        });
    }

    private void vaiParaResumoPacote(Pacote pacote) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }
}