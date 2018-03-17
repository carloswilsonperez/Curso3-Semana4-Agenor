package com.example.duvan.petagram;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentsMascotas extends Fragment {

    ArrayList<Mascota> mascotas;
    RecyclerView rvMascotas;


    public fragmentsMascotas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragments_mascotas, container, false);

        rvMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas); //Buscamos el view en el layout
        LinearLayoutManager llm = new LinearLayoutManager(getActivity()); //Creamos un manager para el recycler view
        rvMascotas.setLayoutManager(llm); //cambiamos el recyclerview para que se muestre en un LinearLayout
        inicializarMascotas();
        inicializarAdapdator();

        // Inflate the layout for this fragment
        return  view;
    }

    public void inicializarAdapdator(){
        mascotaAdaptador adaptador = new mascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Catyy",R.drawable.m1));
        mascotas.add(new Mascota("Max",R.drawable.img2));
        mascotas.add(new Mascota("Doggy",R.drawable.img3));
        mascotas.add(new Mascota("Catun",R.drawable.img4));
        mascotas.add(new Mascota("Loran",R.drawable.img5));
        mascotas.add(new Mascota("Moran",R.drawable.img6));


    }

}
