package com.example.concurso.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirLengua(View v){
        Intent intent = new Intent(this, Lenguaje_Activity.class);
        startActivity(intent);
    }

    public void abrirMatematica(View v){
        Intent intent = new Intent(this, Matematica_Activity.class);
        startActivity(intent);
    }

    public void abrirIngles(View v){
        Intent intent = new Intent(this, Ingles_Activity.class);
        startActivity(intent);
    }

}
