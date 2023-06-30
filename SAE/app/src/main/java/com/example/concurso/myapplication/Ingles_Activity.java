package com.example.concurso.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ingles_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingles);
    }

    public void regresoMenuPrincipal(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
