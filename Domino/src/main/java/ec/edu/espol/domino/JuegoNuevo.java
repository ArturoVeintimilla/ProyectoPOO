/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.domino;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class JuegoNuevo {
    
    public static void NuevoJuego(Juego game){

        
        
        //0
        game.agregarJugador("Maquina");
        //System.out.println("Ingrese el nombre del jugador:");
        //1
        game.agregarJugador("Jugador");

        
    }
    
    public static void logicaJuego(Juego game)
    {
        Random r = new Random();
        int turno = r.nextInt(1);
        
        boolean condicionVictoria = game.getJugadores().get(0).tamanioMano() > 0 && game.getJugadores().get(1).tamanioMano() > 0;

        while(condicionVictoria==true)
        {

            if(turno == 0)
            {

                if(game.turnoMaquina() == true)
                {
                    //System.out.println("Linea actual: ");
                    game.mostrarLinea();

                    if(game.validarOpciones(game.getJugadores().get(1)) == false)
                    {
                        condicionVictoria = false;
                        //System.out.println("Perdiste");
                    }


                    else if(game.turnoJugador(1) == false)
                    {
                        boolean condicion1 = game.validarOpciones(game.getJugadores().get(1));
                        while(condicion1 == true)
                        {
                            //System.out.println("La ficha no es válida, pruebe otra vez");
                            game.mostrarLinea();
                            condicion1 = !game.turnoJugador(1);
                            game.mostrarLinea();
                        }
                    }
                }

                else
                {
                    //System.out.println("Ganaste");
                    condicionVictoria = false;
                }

                //Turno jugador

            }
            else
            {
                if(game.turnoJugador(1) == true)
                {
                    game.mostrarLinea();

                    if(game.validarOpciones(game.getJugadores().get(1)) == false)
                    {
                        condicionVictoria = false;
                        //System.out.println("Perdiste");
                    }
                    else
                    {
                        boolean condicion1 = game.validarOpciones(game.getJugadores().get(1));
                        while(condicion1 == true)
                        {
                            //System.out.println("La ficha no es válida, pruebe otra vez");
                            game.mostrarLinea();
                            condicion1 = !game.turnoJugador(1);
                            game.mostrarLinea();
                        }

                        if(game.turnoMaquina() == false)
                        {
                            condicionVictoria = false;
                            //System.out.println("Ganaste");
                        }

                        else
                        {
                            game.mostrarLinea();
                        }
                    }
                }

                else
                {
                    //System.out.println("Ganaste");
                    condicionVictoria = false;
                } 
            }
        }
        
        //While se hace false

        /*if(game.getJugadores().get(0).tamanioMano() == 0)
            System.out.println("El ganador es: " + game.getJugadores().get(0).getNombre());
        else if(game.getJugadores().get(1).tamanioMano() == 0)
            System.out.println("El ganador es: " + game.getJugadores().get(1).getNombre());*/

    }
}
