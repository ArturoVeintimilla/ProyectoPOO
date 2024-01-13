package ec.edu.espol.domino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {
    
    //prueba

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MesaJuego"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        launch();
        Juego game = new Juego();
        ArrayList<Ficha> mano_m= game.getJugadores().get(0).getMano();
        ArrayList<Ficha> mano_j= game.getJugadores().get(1).getMano();
        Random r = new Random();
        int turno = r.nextInt(1);

        game.agregarJugador("Maquina");
        //System.out.println("Ingrese el nombre del jugador:");
        game.agregarJugador("Jugador");


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