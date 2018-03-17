package com.example.duvan.petagram;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentPerfilMascota extends Fragment {

    RecyclerView rvMiMascota;
    ArrayList<Mascota> mascotas;


    public fragmentPerfilMascota() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_perfil_mascota, container, false);
        rvMiMascota = (RecyclerView) view.findViewById(R.id.fotosMascota); //Buscamos el view en el layout
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3); //Creamos un manager para el recycler view
        rvMiMascota.setLayoutManager(llm); //cambiamos el recyclerview para que se muestre en un LinearLayout
        inicializarMascotasFavoritas();
        inicializarAdapdatorMiMascota();

        return view;

    }

    public void inicializarAdapdatorMiMascota(){
        miMascotaAdapter adaptador = new miMascotaAdapter(mascotas, getActivity());
        rvMiMascota.setAdapter(adaptador);
    }

    public void inicializarMascotasFavoritas(){
        mascotas = new ArrayList<>();


        mascotas.add(new Mascota("MOTAS",R.drawable.img5));
        mascotas.add(new Mascota("MOTAS",R.drawable.img5));
        mascotas.add(new Mascota("MOTAS",R.drawable.img5));
        mascotas.add(new Mascota("MOTAS",R.drawable.img5));
        mascotas.add(new Mascota("MOTAS",R.drawable.img5));
        mascotas.add(new Mascota("MOTAS",R.drawable.img5));
        mascotas.add(new Mascota("MOTAS",R.drawable.img5));
        mascotas.add(new Mascota("MOTAS",R.drawable.img5));
        mascotas.add(new Mascota("MOTAS",R.drawable.img5));


}
}
