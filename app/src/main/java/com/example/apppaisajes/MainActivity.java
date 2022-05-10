package com.example.apppaisajes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Paisaje> paisajeList = new ArrayList<>();
    RecyclerAdapter adapterPaisajes;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    ClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarLista();

    }

    private void rellenarLista(){

        Paisaje imagen1 = new Paisaje(R.drawable.paisaje1);
        Paisaje imagen2 = new Paisaje(R.drawable.paisaje2);
        Paisaje imagen3 = new Paisaje(R.drawable.paisaje3);
        Paisaje imagen4 = new Paisaje(R.drawable.paisaje4);
        Paisaje imagen5 = new Paisaje(R.drawable.paisaje5);
        Paisaje imagen6 = new Paisaje(R.drawable.paisaje6);
        Paisaje imagen7 = new Paisaje(R.drawable.paisaje7);
        Paisaje imagen8 = new Paisaje(R.drawable.paisaje8);
        //int imagen = (R.drawable.);

        paisajeList.add(imagen1);
        paisajeList.add(imagen2);
        paisajeList.add(imagen3);
        paisajeList.add(imagen4);
        paisajeList.add(imagen5);
        paisajeList.add(imagen6);
        paisajeList.add(imagen7);
        paisajeList.add(imagen8);
        //paisajeList.add();
    }

    private void cargarLista(){
        setOnClickListener();
        rellenarLista();
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapterPaisajes = new RecyclerAdapter(paisajeList, getApplicationContext(), clickListener);
        recyclerView.setAdapter(adapterPaisajes);

    }

    private void setOnClickListener(){
        clickListener = posicion -> {
            Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
            intent.putExtra("imagen", paisajeList.get(posicion).getImagen());
            startActivity(intent);
        };
    }

}