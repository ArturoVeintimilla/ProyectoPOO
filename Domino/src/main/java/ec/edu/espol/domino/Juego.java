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
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;

    public Juego() 
    {
        lineaJuego = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    public ArrayList<Ficha> getLineaJuego() {
        return lineaJuego;
    }
    
    public void agregarJugador(String nombre)
    {
        Jugador j1 = new Jugador(nombre, Utilitaria.crearManoJugador());
        jugadores.add(j1);
    }
    
    
    
    public int obtenerValorInicioLinea()
    {
        return lineaJuego.get(0).getLado1();
    }
    
    public int obtenerValorFinLinea()
    {
        return lineaJuego.get(lineaJuego.size()-1).getLado2();
    }
    
    public void mostrarLinea()
    {
        StringBuilder s1 = new StringBuilder();
        for(int i = 0;i < lineaJuego.size();i++)
        {
            s1.append(lineaJuego.get(i).toString());
            if(i < lineaJuego.size() - 1)
                s1.append(" - ");
        }
        System.out.println(s1);
    }
    
    public boolean agregarFichaLinea(Ficha ficha,Jugador j)
    {
        if(!(ficha instanceof FichaComodin))
        {
            if(lineaJuego.size() == 0)
            {
                lineaJuego.add(ficha);
                j.removerFicha(ficha);
            }
            else 
                if(ficha.getLado2() == obtenerValorInicioLinea())
                {
                    lineaJuego.add(0, ficha);
                    j.removerFicha(ficha);
                }
                else if(ficha.getLado1() == obtenerValorFinLinea())
                {
                    lineaJuego.add(lineaJuego.size(), ficha);
                    j.removerFicha(ficha);
                }
                else
                    return false;
        }
        else 
        {
            Scanner sc = new Scanner(System.in);
            sc.useLocale(Locale.US);
            sc.useDelimiter("\n");
            
            FichaComodin fc = (FichaComodin) ficha;
            
            if(lineaJuego.size() == 0)
            {
                lineaJuego.add(fc);
                
                do
                {
                System.out.println("Ingrese un valor para el lado 1");
                fc.setLado1(sc.nextInt());
                }while(fc.getLado1() < 1 && fc.getLado1() > 6);
                
                do
                {
                System.out.println("Ingrese un valor para el lado 2");
                fc.setLado2(sc.nextInt());
                }while(fc.getLado2() < 1 && fc.getLado2() > 6);
                
                j.removerFicha(ficha);
            }
            
            else 
            {
                System.out.println("Posición: ");
                String posicion = sc.next();
                if(posicion.equals("Inicio"))
                {
                    lineaJuego.add(0, ficha);
                    do
                    {
                    System.out.println("Ingrese un valor para el lado 1");
                    fc.setLado1(sc.nextInt());
                    }while(fc.getLado1() < 1 && fc.getLado1() > 6);
                    
                    j.removerFicha(ficha);
                }
                
                else if(posicion.equals("Fin"))
                {
                    lineaJuego.add(lineaJuego.size(), ficha);
                    do
                    {
                    System.out.println("Ingrese un valor para el lado 2");
                    fc.setLado2(sc.nextInt());
                    }while(fc.getLado2() < 1 && fc.getLado2() > 6);
                    
                    j.removerFicha(ficha);
                }
            }
        }
        
        return true;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    

    public boolean turnoMaquina()
    {
        //System.out.println("Mano de la maquina: ");
        
        Jugador maquina = this.jugadores.get(0);
        
        //maquina.imprimirMano();
        
        for(Ficha f:maquina.getMano())
        {

            if(!(f instanceof FichaComodin))
            {
                if(this.agregarFichaLinea(f, maquina) == true)
                    return true;
            }

            else if(f instanceof FichaComodin)
            {
                Random r = new Random();
                int dado = r.nextInt(2);
                int nrand = (int) ((Math.random() * 6) + 1);
                
                if(dado == 0)
                {
                    lineaJuego.add(0,f);
                    ((FichaComodin) f).setLado1(nrand);
                    ((FichaComodin)f).setLado2(lineaJuego.get(0).getLado1());
                    maquina.removerFicha(f);
                    
                }
                else
                {
                    lineaJuego.add(lineaJuego.size(),f);
                    ((FichaComodin) f).setLado2(nrand);
                    ((FichaComodin)f).setLado1(lineaJuego.get(lineaJuego.size()-1).getLado2());
                    maquina.removerFicha(f);
                }
                
                return true;
                
            }  
        }
        
        return false;
        
    }
   
                         
    public boolean turnoJugador(int p)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        sc.useDelimiter("\n");
        
        Jugador j = this.jugadores.get(p);
        
        System.out.println("Fichas actuales que puede jugar: ");
        j.imprimirMano();
        
        System.out.println("Seleccione el indice de la ficha que desea jugar");
        int eleccion = sc.nextInt();
        
        while(eleccion < 0 || eleccion > j.tamanioMano())
        {
            System.out.println("El indice no es valido, ingrese otro indice: ");
            eleccion = sc.nextInt();
        }
        
        return this.agregarFichaLinea(j.getFicha(eleccion), j);
        
    }
    
    public boolean validarOpciones(Jugador j)
        {
            for(Ficha f:j.getMano())
            {
                    if(f.getLado2() == obtenerValorInicioLinea())
                        return true;

                    else if(f.getLado1() == obtenerValorFinLinea())
                        return true;

                    else if(f instanceof FichaComodin)
                        return true;
            }
            return false;
        }
}
