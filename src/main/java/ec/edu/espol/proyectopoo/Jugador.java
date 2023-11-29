/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.util.ArrayList;

/**
 *
 * @author TOSHIBA
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador(String n, ArrayList<Ficha> mano) {
        this.nombre = n;
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Ficha getFicha(int i){
        if (i>0 && i<=mano.size())
            return mano.get(i-1);
        else
            return null;
    }
    
    
}
