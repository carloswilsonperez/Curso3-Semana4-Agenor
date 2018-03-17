package com.example.duvan.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by duvan on 15/03/2018.
 */

public class miMascotaAdapter extends RecyclerView.Adapter<miMascotaAdapter.mascotaViewHolder> {


    ArrayList<Mascota> mascotas;
    Activity activity;

    public miMascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }



    @Override
    public mascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mi_mascotas , parent, false);

        return new mascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(mascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);



    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }




    public static class mascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView nombreMascota;
        private ImageButton ibHuesoRaiting;
        private ImageButton ibRaiting;
        private TextView tvContador;


        public mascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota      = (ImageView)  itemView.findViewById(R.id.imgMiMascota);

            ibRaiting       = (ImageButton) itemView.findViewById(R.id.ibRaitingM);
            tvContador      = (TextView)  itemView.findViewById(R.id.tvContadorM);

        }
    }
}
