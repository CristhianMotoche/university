package com.example.concurso.myapplication.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.concurso.myapplication.R;

import java.util.List;

/**
 * Created by USREPS_2 on 03/06/2016.
 */
public class TablaAdaptador extends ArrayAdapter {

    private Context contexto;
    private List<String> operaciones;

    public TablaAdaptador(Context context, List objects) {
        super(context, 0, objects);
        this.contexto = context;
        this.operaciones = objects;
    }

    public View getView(int position, View view, ViewGroup padre) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) contexto
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_item__tablas, padre, false);
        }

        TextView lblOperacion = (TextView) view.findViewById(R.id.lblItem);
        lblOperacion.setText(this.operaciones.get(position));
        return view;
    }
}
