package com.example.apppaisajes;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    ImageView imageViewPaisaje;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_detalle);
        imageViewPaisaje = findViewById(R.id.imageViewPaisajeDetalle);

        int imagen = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            imagen = extras.getInt("imagen");
        }
        imageViewPaisaje.setImageResource(imagen);
    }

}
