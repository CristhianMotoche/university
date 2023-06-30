package com.example.concurso.myapplication;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.concurso.myapplication.adaptador.TablaAdaptador;

import java.util.ArrayList;

public class TablasMultiplicar_Activity extends AppCompatActivity {

    private Spinner spNumero;
    private int valor;
    private int resultado;
    private ListView lvTablaMultiplicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablas_multiplicar);

        lvTablaMultiplicar = (ListView) findViewById(R.id.lvTablas);
        spNumero = (Spinner) findViewById(R.id.spNumero);

        String [] tablas = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

        ArrayAdapter<String> adaptadorTablas =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tablas);

        spNumero.setAdapter(adaptadorTablas);
        spNumero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valor = Integer.parseInt(spNumero.getSelectedItem().toString());
                lvTablaMultiplicar.setAdapter(new TablaAdaptador(TablasMultiplicar_Activity.this, toTableList(valor)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    public ArrayList<String> toTableList(int value){
        ArrayList<String> arreglo = new ArrayList<>();
        for (int i = 0; i < 13; i ++){
            arreglo.add(i + "x" + value + "=" + (value*i));
        }
        return arreglo;
    }
}
