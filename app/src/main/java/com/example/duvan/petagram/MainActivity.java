package com.example.duvan.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota>  mascotas;
    RecyclerView rvMascotas;
    private Toolbar t2;
    private TabLayout tableLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t2 = (Toolbar) findViewById(R.id.toolBar2);
        tableLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        Toolbar miActionBar =  (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        if(t2 != null){
            setSupportActionBar(t2);
        }



       /* rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas); //Buscamos el view en el layout
        LinearLayoutManager llm = new LinearLayoutManager(this); //Creamos un manager para el recycler view
        rvMascotas.setLayoutManager(llm); //cambiamos el recyclerview para que se muestre en un LinearLayout
        inicializarMascotas();
        inicializarAdapdator();*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mContacto:
                Intent intent  = new Intent(this, contacto.class);
                startActivity(intent);
                break;

                case R.id.mAcerca:
                    Intent intent2  = new Intent(this, acercaActivity.class);
                    startActivity(intent2);
                    break;



            case R.id.mStar:
                Intent intent1 = new Intent(this, activityMascotaFavorita.class);
                startActivity(intent1);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    /*public void inicializarAdapdator(){
         mascotaAdaptador adaptador = new mascotaAdaptador(mascotas, this);
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


    }*/



    public ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new fragmentsMascotas());
        fragments.add(new fragmentPerfilMascota());

        return fragments;


    }

    public void setUpViewPager(){
        viewPager.setAdapter(new pageAdapter(getSupportFragmentManager(), agregarFragments()));
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.getTabAt(0).setIcon(R.drawable.home);
        tableLayout.getTabAt(1).setIcon(R.drawable.ic_github_face);


    }

}
