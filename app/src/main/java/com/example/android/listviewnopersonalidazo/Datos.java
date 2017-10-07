package com.example.android.listviewnopersonalidazo;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class Datos {

    private static ArrayList<Carros> carros = new ArrayList();

    public static void guardarCarros(Carros c){
        carros.add(c);
    }

    public static ArrayList<Carros> obtenerCarros(){
        return carros;
    }
}
