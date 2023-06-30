package com.example.concurso.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Matematica_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematica);
    }

    public void regresoMenuPrincipal(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void abrirTablas(View view){
        Intent intent = new Intent(this, TablasMultiplicar_Activity.class);
        startActivity(intent);
    }

    public void abrirRepaso(View view){
        Intent intent = new Intent(this,RepasoMultiplicacion_Activity.class);
        startActivity(intent);
    }
}
