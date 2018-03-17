package com.example.duvan.petagram;


import android.app.Activity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class mascotaAdaptador extends RecyclerView.Adapter<mascotaAdaptador.mascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public mascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public mascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascotas , parent, false);

        return new mascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(mascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.nombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.imgMascota.setImageResource(mascota.getImagen());

        mascotaViewHolder.ibHuesoRaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Raitiaste a "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }




    public static class mascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView  nombreMascota;
        private ImageButton ibHuesoRaiting;
        private ImageButton ibRaiting;
        private TextView tvContador;


        public mascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota      = (ImageView)  itemView.findViewById(R.id.imgMascota);
            nombreMascota   = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            ibHuesoRaiting  = (ImageButton) itemView.findViewById(R.id.ibHuesoRaiting);
            ibRaiting       = (ImageButton) itemView.findViewById(R.id.ibRaiting);
            tvContador      = (TextView)  itemView.findViewById(R.id.tvContador);

        }
    }
}





