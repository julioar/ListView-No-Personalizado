package com.example.android.listviewnopersonalidazo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Registrar extends AppCompatActivity {
    private EditText cajaplaca, cajaprecio;
    private Spinner cajamodelo;
    private Spinner cajacolor;
    private Spinner cajamarca;
    private String [] modelo;
    private String [] marca;
    private String [] color;
    private Resources res;
    private ArrayList<Integer> fotos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        cajaplaca = (EditText)findViewById(R.id.txtPlaca);
        cajamarca = (Spinner)findViewById(R.id.spMarca);
        cajamodelo = (Spinner)findViewById(R.id.spModelo);
        cajacolor = (Spinner)findViewById(R.id.spColor);
        cajaprecio = (EditText)findViewById(R.id.txtPrecio);

        res = this.getResources();

        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);


        marca = res.getStringArray(R.array.marca);
        modelo = res.getStringArray(R.array.modelo);
        color = res.getStringArray(R.array.color);

        ArrayAdapter<String> adapter_marca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,marca);
        cajamarca.setAdapter(adapter_marca);

        ArrayAdapter<String> adapter_modelo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,modelo);
        cajamodelo.setAdapter(adapter_modelo);

        ArrayAdapter<String> adapter_color = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,color);
        cajacolor.setAdapter(adapter_color);

    }

    public void guardar(View v){
        String pl;
        int mar,mod, col,pre;
        pl= cajaplaca.getText().toString();
        mar = cajamarca.getSelectedItemPosition();
        mod = cajamodelo.getSelectedItemPosition();
        col = cajacolor.getSelectedItemPosition();
        pre = Integer.parseInt(cajaprecio.getText().toString());

        Carros c = new Carros(Registrar.fotoAleatoria(fotos),pl,mar,mod,col,pre);
        c.guardar();

        Toast.makeText(this,res.getString(R.string.mensaje_guardado),Toast.LENGTH_SHORT).show();
        //limpiar();
    }
    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }
}
