package com.example.concurso.myapplication.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.concurso.myapplication.R;
import com.example.concurso.myapplication.lenguaje.Palabra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Concurso on 03/06/2016.
 */
public class PalabraAdapter extends ArrayAdapter{
    private Context context;
    private View rowView;
    private ArrayList<Palabra> palabras;

    public PalabraAdapter(Context contexto, List objects) {
        super(contexto, 0, objects);
    }

    @Override
    public View getView(int position, View view, ViewGroup padre) {

         if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_silaba, padre, false);
        }

        TextView lblPalabra = (TextView) view.findViewById(R.id.lblPalabra);
        EditText txtPalabra = (EditText) view.findViewById(R.id.txtPalabra);
        TextView lblCalificar = (TextView) view.findViewById(R.id.lblCalificar);

        lblPalabra.setText(this.palabras.get(position).getPalabra());

        addEditTextListener(txtPalabra, lblCalificar, this.palabras.get(position));
        return view;
    }

    private void addEditTextListener(EditText editText, TextView lblCalificar, Palabra palabra) {
        editText.addTextChangedListener(new PalabraWatcher(lblCalificar, palabra));
    }
}
