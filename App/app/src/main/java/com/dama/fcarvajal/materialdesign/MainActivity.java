package com.dama.fcarvajal.materialdesign;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.app.ToolbarActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    public ArrayList<Mascota> ListaMascotas;
    private ArrayList<Mascota> ListaTopCinco;
    private RecyclerView RVListaMascotas;
    private MascotaAdaptador adaptador;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        setFloatingActionButton();
        setRecyclerView();
    }

    public void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        setSupportActionBar(toolbar);

        TextView tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvTitulo.setText(R.string.petagram);

//        ImageView imgEstrella = (ImageView) findViewById(R.id.imgEstrella);
//        imgEstrella.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Clic top 5.", Toast.LENGTH_SHORT).show();
//
//                inicializarListaTopCinco();
//
//                Intent intent = new Intent(MainActivity.this, TopCincoActivity.class);
//                intent.putExtra("ListaTopCinco", ListaTopCinco);
//
//                MainActivity.this.startActivity(intent);
//            }
//        });
    }

    public void inicializarListaTopCinco() {

        ArrayList<Mascota> ListaTemporal = new ArrayList<Mascota>();

        for(Mascota mascota : ListaMascotas){
            ListaTemporal.add(mascota);
        }

        for (int i = 0; i < ListaTemporal.size(); i++) {
            for (int j = ListaTemporal.size() - 1; j > i; j--) {
                if (ListaTemporal.get(i).getRaiting() < ListaTemporal.get(j).getRaiting()) {

                    Mascota mascota = ListaTemporal.get(i);
                    ListaTemporal.set(i,ListaTemporal.get(j)) ;
                    ListaTemporal.set(j,mascota);
                }
            }
        }

        ListaTopCinco = new ArrayList<Mascota>();

        for(int i = 0; i < 5; i++){

            ListaTopCinco.add(ListaTemporal.get(i));
        }
    }

    public void setFloatingActionButton()
    {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clic en boton flotante cámara.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setRecyclerView(){
        RVListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas_main_activity);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RVListaMascotas.setLayoutManager(llm);
        inicialiarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(ListaMascotas, this);
        RVListaMascotas.setAdapter(adaptador);
    }

    public void inicialiarListaMascotas() {
            ListaMascotas = new ArrayList<Mascota>();

            ListaMascotas.add(new Mascota("Bruto", 3, R.drawable.dog_bruto));
            ListaMascotas.add(new Mascota("Cocky", 2, R.drawable.dog_cocky));
            ListaMascotas.add(new Mascota("Jack", 7, R.drawable.dog_jack));
            ListaMascotas.add(new Mascota("Kira", 1, R.drawable.dog_kira));
            ListaMascotas.add(new Mascota("Lebre", 5, R.drawable.dog_lebre));
            ListaMascotas.add(new Mascota("Lolo", 4, R.drawable.dog_lolo));
            ListaMascotas.add(new Mascota("Rock", 8, R.drawable.dog_rock));
            ListaMascotas.add(new Mascota("Sammy", 9, R.drawable.dog_sammy));
            ListaMascotas.add(new Mascota("Tile", 6, R.drawable.dog_tile));
    }

    public void irTopCinco(View v) {
        Toast.makeText(MainActivity.this, "Clic top 5.", Toast.LENGTH_SHORT).show();

        inicializarListaTopCinco();

        Intent intent = new Intent(MainActivity.this, TopCincoActivity.class);
        intent.putExtra(String.valueOf(R.string.lista_serializada), ListaTopCinco);

        MainActivity.this.startActivity(intent);
    }

}
