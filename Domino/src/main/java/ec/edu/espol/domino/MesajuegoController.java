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
    private VBox ficha_individual_m;
    @FXML
    private VBox ficha_individual;

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
        for(Ficha f: mano_m){
            ficha_individual_m= new VBox();
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
                    im_jL2= new ImageView("dado"+l_2+"png");
            }
            else{
                im_jL1= new ImageView("comodin.jpg");
                im_jL2= new ImageView("comodin.jpg");
            }
            ficha_individual_m.getChildren().addAll(im_jL1,im_jL2);
            manomaquina.getChildren().add(ficha_individual_m);
        }
        for(Ficha f: mano_j){
            ficha_individual= new VBox();
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
                    im_mL2= new ImageView("dado"+l_2+"png");
            }
            else{
                im_mL1= new ImageView("comodin.jpg");
                im_mL2= new ImageView("comodin.jpg");
            }
            ficha_individual= new VBox();
            ficha_individual.getChildren().addAll(im_mL1,im_mL2);
            manojugador.getChildren().add(ficha_individual);
        }
    }    

    @FXML
    private void ficha_elegida(MouseEvent event) {
        
    }

    
}
