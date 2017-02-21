package com.dama.fcarvajal.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 20/2/2017.
 */

public class TopCincoActivity  extends AppCompatActivity {

    private ArrayList<Mascota> ListaTopCinco;
    private RecyclerView RVListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_cinco);
        setToolbar();
        setRecyclerView();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        setSupportActionBar(toolbar);

        TextView tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvTitulo.setText(R.string.petagram_top_5);

        ImageView imgEstrella = (ImageView) findViewById(R.id.imgEstrella);
        imgEstrella.setVisibility(View.INVISIBLE);
    }

    public void setRecyclerView(){
        RVListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas_topcinco_activity);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RVListaMascotas.setLayoutManager(llm);
        inicializarParametros();
        inicializarAdaptador();
    }

    public void inicializarParametros() {
        Bundle parametros = getIntent().getExtras();

        ListaTopCinco = (ArrayList<Mascota>) parametros.getSerializable(String.valueOf(R.string.lista_serializada));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(ListaTopCinco, this);
        RVListaMascotas.setAdapter(adaptador);
    }

}
