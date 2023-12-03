/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class JugadorMaquina extends Jugador{
    
    public JugadorMaquina(String n, ArrayList<Ficha> mano) {
        super("Maquina", Utilitaria.crearManoJugador());
    }
    
    public void juego(){
        
    }
    
    
}
