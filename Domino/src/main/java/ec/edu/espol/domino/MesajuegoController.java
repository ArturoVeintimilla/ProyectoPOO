/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.domino;

import ec.edu.espol.domino.Ficha;
import ec.edu.espol.domino.FichaComodin;
import ec.edu.espol.domino.Utilitaria;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author TOSHIBA
 */
public class MesajuegoController implements Initializable {

    @FXML
    private HBox manomaquina;
    @FXML
    private HBox manojugador;
    @FXML
    private HBox mesafichas;

    @FXML
    private ScrollPane idScrollPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Ventana de inicio
        Juego game = new Juego();
        JuegoNuevo.NuevoJuego(game);   
        
        //0
        game.agregarJugador("Maquina");
        //1
        game.agregarJugador("Jugador");
        
        
        ArrayList<Ficha> listaManoMaquina = game.getJugadores().get(0).getMano();
        ArrayList<Ficha> listaManoJugador = game.getJugadores().get(1).getMano();
        
        actualizar_fichas(listaManoJugador, manojugador);
        actualizar_fichas(listaManoMaquina, manomaquina);
        
        //jugarPartida(game);
            
    } 
    
    
    
    private void actualizar_fichas(ArrayList<Ficha> game,HBox lugar){
        ImageView im_L1;
        ImageView im_L2;
        int counter = 0;
        
        for(Ficha f: game){
            HBox ficha_individual_m= new HBox();
            ficha_individual_m.setId("" + counter);
            counter++;
            if(!(f instanceof FichaComodin)){
                int lado1= f.getLado1();
                int lado2= f.getLado2();
                String l_1=""+lado1;
                String l_2=""+lado2;
                if(lado1 == 4)
                    im_L1= new ImageView("dado4.jpg");
                else
                    im_L1= new ImageView("dado"+l_1+".png");
                if(lado2== 4)
                    im_L2= new ImageView("dado4.jpg");
                else
                    im_L2= new ImageView("dado"+l_2+".png");
            }
            else{
                im_L1= new ImageView("comodin.jpg");
                im_L2= new ImageView("comodin.jpg");
            }
            im_L1.setFitHeight(80);
            im_L1.setFitWidth(80);
            im_L2.setFitHeight(80);
            im_L2.setFitWidth(80);
            ficha_individual_m.getChildren().addAll(im_L1,im_L2);
            lugar.getChildren().add(ficha_individual_m);
            lugar.setSpacing(10);
            lugar.setAlignment(Pos.CENTER);
            
            
        }
    }    

    private void crearEventoFicha(HBox caja, Juego game)
    {   
        Jugador j = game.getJugadores().get(1);
        
        //Recorremos la mano del jugador para agregar eventos de click a las fichas
        caja.getChildren().forEach((Node node) -> {
            node.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> { 
                // Obtenemos el contenedor de la ficha y su ID a referenciar en el ArrayList
                HBox ficha = (HBox) t.getSource();
                int posicion = Integer.parseInt(ficha.getId());
                
                
                //Si no se elige la comodín se maneja la lógica normal
                if(posicion != caja.getChildren().size()-1)
                {
                    //Si podemos agregar una ficha se agrega
                    if(game.agregarFichaLinea(j.getMano().get(posicion), j) == true)
                    {
                        idScrollPane.setContent(mesafichas);
                        mesafichas.getChildren().clear();
                        actualizar_fichas(game.getLineaJuego(), mesafichas);
                        manojugador.getChildren().clear();
                        actualizar_fichas(j.getMano(), manojugador);
                        crearEventoFicha(caja, game);          
                    }
                    
                    //Si no, entonces muestra el mensaje de alerta
                    else
                    {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "No se puede jugar esa ficha");
                        a.show();
                    }
                }
                
                //Si se elige la comodín se debe llamar a la interfaz respectiva
                else
                {
                    
                }
            });
            
        });    
    }
    
    public void jugadaMaquina(HBox caja, Juego game)
    {
        //Limpiamos la mano de la maquina y obtenemos su mano
        ArrayList<Ficha> listaManoMaquina = game.getJugadores().get(0).getMano();
        caja.getChildren().clear();
        
        //Mostramos mano de la maquina
        actualizar_fichas(listaManoMaquina, manomaquina);
        
        //Actualizamos la linea de juego
        idScrollPane.setContent(mesafichas);
        mesafichas.getChildren().clear();
        actualizar_fichas(game.getLineaJuego(), mesafichas);
    }
    
    public void jugarPartida(Juego game)
    {
        Random r = new Random();
        int turno = r.nextInt(1);
        
        //Condicion: Alguno de los jugadores se queda sin cartas
        boolean condicionVictoria = game.getJugadores().get(0).tamanioMano() > 0 && game.getJugadores().get(1).tamanioMano() > 0;

        while(condicionVictoria==true)
        {
            //Empieza la maquina
            if(turno == 0)
            {
                //Maquina juega
                if(game.turnoMaquina() == true)
                {
                    //Actualizamos la mano de la maquina
                    jugadaMaquina(manomaquina, game);

                    //Jugador no puede jugar
                    if(game.validarOpciones(game.getJugadores().get(1)) == false)
                    {
                        condicionVictoria = false;
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Perdiste, te falta, te falta...");
                        a.show();
                    }

                    //Jugador juega
                    else 
                    {
                        crearEventoFicha(manojugador, game);
                    }
                }
                
                //Maquina no pudo jugar
                else
                {
                    condicionVictoria = false;
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Felicitaciones, ganaste!!");
                    a.show();  
                }

                //Si nadie perdió se repite el while en este punto

            }
           
            //Empieza el jugador
            else
            {   
                //Jugador juega
                crearEventoFicha(manojugador, game);
                
                //Si no tiene opciones este pierde
                if(game.validarOpciones(game.getJugadores().get(1)) == false)
                {
                    condicionVictoria = false;
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Perdiste, te falta, te falta...");
                    a.show();
                }
                
                //Maquina no puede jugar
                if(game.turnoMaquina() == false)
                {
                    condicionVictoria = false;
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Felicitaciones, ganaste!!");
                    a.show();
                    //System.out.println("Ganaste");
                }
                
                //Maquina juega
                else
                {
                    jugadaMaquina(manomaquina, game);
                }
            }
        }
        
        //Declaramos un ganador
        
        if(game.getJugadores().get(0).tamanioMano() == 0)
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Perdiste, te falta, te falta...");
            a.show();
        }    
        else if(game.getJugadores().get(1).tamanioMano() == 0)
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Felicitaciones, ganaste!!");
            a.show();
        }
    }
}
