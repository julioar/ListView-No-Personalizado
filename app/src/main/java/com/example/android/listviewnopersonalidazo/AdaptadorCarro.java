package com.example.android.listviewnopersonalidazo;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class AdaptadorCarro extends BaseAdapter {

    private Context contexto;
    private ArrayList<Carros> carros;
    private Resources res;
    private String [] m, mo, co, pre;

    public AdaptadorCarro(Context contexto, ArrayList<Carros> carros){
        this.contexto=contexto;
        this.carros=carros;
        res=contexto.getResources();
        m=res.getStringArray(R.array.marca);
        mo=res.getStringArray(R.array.modelo);
        co=res.getStringArray(R.array.modelo);

    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Definición de las variables a utilizar
        res = contexto.getResources();
        View v = view;

        //Crear el objeto LayoutInflater para modificar la vista
        LayoutInflater inf = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inf.inflate(R.layout.item_lista,null);

        //Creamos un objeto Persona
        Carros c = carros.get(i);

        //Capturar elemento de la vista
        ImageView foto = (ImageView)v.findViewById(R.id.imgFoto);
        TextView placa = (TextView)v.findViewById(R.id.lblPlaca);
        TextView marca = (TextView) v.findViewById(R.id.lblMarca);
        TextView modelo = (TextView)v.findViewById(R.id.lblModelo);
        TextView color = (TextView)v.findViewById(R.id.lblColor);
        TextView precio = (TextView)v.findViewById(R.id.lblPrecio);


        //Setear elementos a la vista

        //foto.setImageDrawable(res.getDrawable(p.getFoto()));
        foto.setImageDrawable(ResourcesCompat.getDrawable(res,c.getFoto(),null));
        placa.setText("Placa "+c.getPlaca());
        marca.setText(m[ c.getMarca()]);
        modelo.setText(mo[ c.getModelo()]);
        color.setText(co [c.getColor()]);
        precio.setText("$ "+c.getPrecio());

        return v;


    }
}
