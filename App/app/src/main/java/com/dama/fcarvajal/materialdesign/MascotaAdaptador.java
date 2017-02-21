package com.dama.fcarvajal.materialdesign;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcarvajal on 20/02/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private ArrayList<Mascota> ListaMascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> ListaMascotas, Activity activity) {
        this.ListaMascotas = ListaMascotas;
        this.activity = activity;
    }

    //Va a inflar el layout y lo pasara al ViewHolder para que
    //el obtenga cada elemento de los views

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }


    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = ListaMascotas.get(position);

        holder.imgMascotaCV.setImageResource(mascota.getFoto());
        holder.tvMascotaCV.setText(mascota.getNombre());
        holder.tvRaitingCV.setText(mascota.getRaiting_string());

        holder.imgHuesoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setRaiting();

                holder.tvRaitingCV.setText(mascota.getRaiting_string());
            }
        });

        holder.imgMascotaCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {//cantidad de elementos que contiene la lista de mascotas
        return ListaMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascotaCV;
        private ImageView imgHuesoCV;
        private TextView tvMascotaCV;
        private TextView tvRaitingCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascotaCV = (ImageView) itemView.findViewById(R.id.imgMascotaCV);
            imgHuesoCV = (ImageView) itemView.findViewById(R.id.imgHuesoCV);
            tvMascotaCV = (TextView) itemView.findViewById(R.id.tvMascotaCV);
            tvRaitingCV = (TextView) itemView.findViewById(R.id.tvRaitingCV);
        }
    }


}
