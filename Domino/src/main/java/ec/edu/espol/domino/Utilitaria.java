/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.domino;

import java.util.ArrayList;

/**
 *
 * @author TOSHIBA
 */
public class Utilitaria {
    public static ArrayList<Ficha>crearManoJugador(){
        ArrayList<Ficha>mano=new ArrayList();
        while(mano.size()<=4){
            int numeroAleatorio1 = (int) (Math.random() * 6) + 1;
            int numeroAleatorio2= (int) (Math.random() * 6) + 1;
            Ficha f=new Ficha(numeroAleatorio1,numeroAleatorio2);
            mano.add(f);
        }
        Ficha fc=new FichaComodin();
        mano.add(fc);
        return mano;
    }
}
