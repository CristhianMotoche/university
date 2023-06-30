package com.example.concurso.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.concurso.myapplication.adaptador.PalabraAdapter;
import com.example.concurso.myapplication.lenguaje.Palabra;

import java.util.ArrayList;
import java.util.Collections;

public class Silabas_Activity extends AppCompatActivity {
    ArrayList<Palabra> palabras;
    ListView lvPalabra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silabas);

        lvPalabra = (ListView)findViewById(R.id.lvSilaba);

        palabras = new ArrayList<Palabra>();
        palabras.add(new Palabra("gato","ga to"));
        palabras.add(new Palabra("perro","pe rro"));
        palabras.add(new Palabra("libro","li bro"));
        palabras.add(new Palabra("casa","ca sa"));
        palabras.add(new Palabra("refrigeradora","re fri ge ra do ra"));
        palabras.add(new Palabra("murciélago","mur cié la go"));
        palabras.add(new Palabra("aeropuerto","a e ro puer to"));
        palabras.add(new Palabra("sol","sol"));
        palabras.add(new Palabra("chocolate","cho co la te"));
        palabras.add(new Palabra("televisión","te le vi sión"));
        palabras.add(new Palabra("pelota","pe lo ta"));
        palabras.add(new Palabra("parque","par que"));
        palabras.add(new Palabra("computador","com pu ta dor"));
        palabras.add(new Palabra("hermana","her ma na"));
        palabras.add(new Palabra("lapicero","la pi ce ro"));

        Collections.shuffle(palabras);

        lvPalabra.setAdapter(new PalabraAdapter(this, palabras));

    }

    public void calificar(View view){

    }

    public void resolver(View view){

    }

    public void nuevo(View view){

    }

    public void llenar(){

    }




}
