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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
    @FXML
    private Button bttInicio;
    @FXML
    private Button bttFin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Juego game = new Juego();
        JuegoNuevo.NuevoJuego(game);   
    } 
    private void actualizar_fichas(ArrayList<Ficha> game,HBox lugar){
        ImageView im_L1;
        ImageView im_L2;
        for(Ficha f: game){
            HBox ficha_individual_m= new HBox();
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
            ficha_individual_m.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
                
            }
        }
    }    

    @FXML
    private void ficha_al_inicio(MouseEvent event) {
    }

    @FXML
    private void ficha_al_final(MouseEvent event) {
    }


    
}
