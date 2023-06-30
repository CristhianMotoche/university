package com.example.concurso.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Lenguaje_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenguaje);
    }

    public void regresoMenuPrincipal(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void abrirSilabas(View view){
        Intent intent = new Intent(this, Silabas_Activity.class);
        startActivity(intent);
    }

    public void abrirDiptongos(View view){
        Intent intent = new Intent(this, Diptongos_Activity.class);
        startActivity(intent);
    }
}
