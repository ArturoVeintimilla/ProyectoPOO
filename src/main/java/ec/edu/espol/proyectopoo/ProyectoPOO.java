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
        Random r = new Random();
        int turno = r.nextInt(1);
        if(opcion == 1)
        {
            game.agregarJugador("Maquina");
            System.out.println("Ingrese el nombre del jugador:");
            game.agregarJugador(sc.next());
            

            boolean condicionVictoria = game.getJugadores().get(0).tamanioMano() > 0 && game.getJugadores().get(1).tamanioMano() > 0;
            
            while(condicionVictoria==true)
            {
                
                if(turno == 0)
                {
                    System.out.println(game.turnoMaquina());
                    if(game.turnoMaquina().equals("Agregado"))
                    {
                        game.mostrarLinea();
                        System.out.println(game.turnoJugadorVSMaquina());
                        if(game.turnoJugadorVSMaquina().equals("Perdiste"))
                            condicionVictoria=false;
                    }
                    else
                    {
                        condicionVictoria = false;
                    }    
                }
                else
                {
                    System.out.println(game.turnoJugadorVSMaquina());
                    if(game.turnoJugadorVSMaquina().equals("Agregado"))
                    {
                        System.out.println(game.turnoMaquina());
                        if(game.turnoMaquina().equals("Ganaste"))
                            condicionVictoria=false;
                    }
                    else
                    {
                        condicionVictoria = false;
                    }    
                }
            }
        }
        else{
            for (int i=0;i<=1;i++){
                System.out.print("Ingrese nombre del jugador #"+i+":");
                game.agregarJugador(sc.next());
            }

            boolean condicionVictoria = game.getJugadores().get(turno).tamanioMano() > 0;
            
            while(condicionVictoria == true)
            {
                System.out.println("Turno de: " + game.getJugadores().get(turno).getNombre());
                if(game.turnoJugador(turno) == true)
                {
                    System.out.println("Añadido correctamente");
                    game.mostrarLinea();
                    turno++;
                    if(turno>1)
                        turno=0;
                }
                
                else
                {
                    if(game.validarOpciones(game.getJugadores().get(turno)) == false)
                    {
                        condicionVictoria = false;
                        System.out.println("Perdió " + game.getJugadores().get(turno).getNombre());
                    }
                    else
                    {
                        boolean condicion1 = game.validarOpciones(game.getJugadores().get(turno));
                        while(condicion1 == true)
                        {
                            System.out.println("La ficha no es válida, pruebe otra vez");
                            game.mostrarLinea();
                            condicion1 = !game.turnoJugador(turno);
                            game.mostrarLinea();
                        }
                        
                    }
                }
            }
                
        }
    }
}
