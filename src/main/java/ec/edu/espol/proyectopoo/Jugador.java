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
    
    public Ficha getFicha(int i){
        if (i>0 && i<=mano.size())
            return mano.get(i-1);
        else
            return null;
    }
    
    public void removerFicha(Ficha f){
        for(int i=0;i<mano.size();i++){
            if(f.equals(mano.get(i)))
                mano.remove(i);
        }
    }
    public String getNombre() {
        return nombre;
    }
    
    public void imprimirMano(){
       StringBuilder s1 = new StringBuilder();
        for(int i = 0;i < mano.size();i++){
            s1.append(mano.get(i).toString());
            if(i < mano.size() - 1)
                s1.append(" - ");
        }
        System.out.println(s1);
    }
   
     public int tamanioMano(){
         return mano.size();
     
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }
     
     
}


