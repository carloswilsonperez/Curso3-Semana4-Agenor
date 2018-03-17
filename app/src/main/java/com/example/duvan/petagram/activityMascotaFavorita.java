package com.example.duvan.petagram;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class activityMascotaFavorita extends AppCompatActivity {

    ImageButton imageButton;
    RecyclerView rvMascotasFavoritas;
    ArrayList<Mascota>  mascotas;



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);
        Toolbar miActionBar =  findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
     

        miActionBar.setTitle("Favoritos");
       if (getSupportActionBar() != null){

           getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       }


        rvMascotasFavoritas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas); //Buscamos el view en el layout
        LinearLayoutManager llm = new LinearLayoutManager(this); //Creamos un manager para el recycler view
        rvMascotasFavoritas.setLayoutManager(llm); //cambiamos el recyclerview para que se muestre en un LinearLayout
        inicializarMascotasFavoritas();
        inicializarAdapdatorFavoritos();

    }

    public void inicializarAdapdatorFavoritos(){
        mascotaAdaptador adaptador = new mascotaAdaptador(mascotas, this);
        rvMascotasFavoritas.setAdapter(adaptador);
    }

    public void inicializarMascotasFavoritas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Max",R.drawable.img2));
        mascotas.add(new Mascota("Moran",R.drawable.img6));
        mascotas.add(new Mascota("Catyy",R.drawable.m1));
        mascotas.add(new Mascota("Loran",R.drawable.img5));
        mascotas.add(new Mascota("Doggy",R.drawable.img3));







    }






}
