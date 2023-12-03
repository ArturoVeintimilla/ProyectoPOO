/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyectopoo;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Arturo
 */
public class ProyectoPOO {
   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        sc.useDelimiter("\n");
        
        Juego game = new Juego();
        
        System.out.println("Bienvenido al juego, elija una de las siguientes opciones:");
        System.out.println("1. Jugar contra la maquina");
        System.out.println("2. Jugar contra jugador");
        int opcion = sc.nextInt();
        if(opcion == 1)
        {
            game.agregarJugador("Maquina");
            System.out.println("Ingrese el nombre del jugador");
            game.agregarJugador(sc.next());
            
            Random r = new Random();
            int turno = r.nextInt(1);
            
            boolean condicionVictoria = game.getJugadores().get(0).tamanioMano() > 0 && game.getJugadores().get(1).tamanioMano() > 0;
            
            while(condicionVictoria)
            {
                
                if(turno == 0)
                {
                    if(game.turnoMaquina())
                    {
                        System.out.println("Agregado");
                        game.turnoJugador();
                    }
                    else
                    {
                        System.out.println("Ganaste");
                        condicionVictoria = false;
                    }   
                    
                        
                    
                    
                }
                else
                {
                    game.turnoJugador();
                    game.turnoMaquina();
                }
                    
                
            }
        }
   
    }
}
