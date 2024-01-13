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
        
        ImageView im_jL1;
        ImageView im_jL2;
        ImageView im_mL1;
        ImageView im_mL2;
        
        Juego game = new Juego();
        JuegoNuevo.NuevoJuego(game);

        for(Ficha f: game.getJugadores().get(0).getMano()){
            
            HBox ficha_individual_m = new HBox();
            
            if(!(f instanceof FichaComodin)){
                int lado1= f.getLado1();
                int lado2= f.getLado2();
                String l_1=""+lado1;
                String l_2=""+lado2;
                if(lado1 == 4)
                    im_jL1= new ImageView("dado4.jpg");
                else
                    im_jL1= new ImageView("dado"+l_1+".png");
                if(lado2== 4)
                    im_jL2= new ImageView("dado4.jpg");
                else
                    im_jL2= new ImageView("dado"+l_2+".png");
            }
            else{
                im_jL1= new ImageView("comodin.jpg");
                im_jL2= new ImageView("comodin.jpg");
            }
            im_jL1.setFitHeight(80);
            im_jL1.setFitWidth(80);
            im_jL2.setFitWidth(80);
            im_jL2.setFitHeight(80);
            
            ficha_individual_m.getChildren().addAll(im_jL1,im_jL2);
            manomaquina.getChildren().add(ficha_individual_m);
            manomaquina.setSpacing(10);
            manomaquina.setAlignment(Pos.CENTER);
            
        }
        
        for(Ficha f: game.getJugadores().get(1).getMano()){
            
            HBox ficha_individual = new HBox();
            
            if(!(f instanceof FichaComodin)){
                int lado1= f.getLado1();
                int lado2= f.getLado2();
                String l_1= ""+lado1;
                String l_2=""+lado2;
                if(lado1 == 4)
                    im_mL1= new ImageView("dado4.jpg");
                else
                    im_mL1= new ImageView("dado"+l_1+".png");
                if(lado2== 4)
                    im_mL2= new ImageView("dado4.jpg");
                else
                    im_mL2= new ImageView("dado"+l_2+".png");
            }
            else{
                im_mL1= new ImageView("comodin.jpg");
                im_mL2= new ImageView("comodin.jpg");
            }

            im_mL1.setFitHeight(80);
            im_mL1.setFitWidth(80);
            im_mL2.setFitWidth(80);
            im_mL2.setFitHeight(80);
            
            ficha_individual.getChildren().addAll(im_mL1,im_mL2);
            manojugador.getChildren().add(ficha_individual);
            manojugador.setSpacing(10);
            manojugador.setAlignment(Pos.CENTER);
        }
        
        
    }    


    
}
