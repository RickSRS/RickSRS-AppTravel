package com.richardsoares.apptravel.ui.activity;

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

        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        startActivity(intent);

    }

    private void configuraLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}