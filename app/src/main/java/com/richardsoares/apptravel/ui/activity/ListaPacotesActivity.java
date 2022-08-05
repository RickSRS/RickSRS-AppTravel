package com.richardsoares.apptravel.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.richardsoares.apptravel.R;
import com.richardsoares.apptravel.dao.PacoteDAO;
import com.richardsoares.apptravel.ui.adapter.ListaPacotesAdapter;
import com.richardsoares.apptravel.ui.model.Pacote;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle("Pacotes");
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);

        List<Pacote> pacotes = new PacoteDAO().lista();

        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}