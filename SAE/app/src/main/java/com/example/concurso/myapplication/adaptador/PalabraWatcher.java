package com.example.concurso.myapplication.adaptador;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.concurso.myapplication.lenguaje.Palabra;

/**
 * Created by Concurso on 03/06/2016.
 */
public class PalabraWatcher implements TextWatcher {

    private Palabra palabra;
    private TextView txtCalifica;

    public PalabraWatcher(TextView lblCalificar, Palabra palabra) {
        this.palabra = palabra;
        this.txtCalifica = lblCalificar;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(s.equals(palabra.getSilabas())){
            this.txtCalifica.setText(":)");
        }
        else {
            this.txtCalifica.setText(":(");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {}
}
