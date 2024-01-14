/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.domino;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author TOSHIBA
 */
public class ComodinController implements Initializable {

    @FXML
    private Button regresar_juego;
    @FXML
    private TextField lado1;
    @FXML
    private TextField lado2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retornar(MouseEvent event) {
        String texto_L1= lado1.getText();
        String texto_L2= lado2.getText();
        int L_1= Integer.parseInt(texto_L1);
        int L_2= Integer.parseInt(texto_L2);
        
        Button b= (Button)event.getSource();
        Stage sp= (Stage) b.getScene().getWindow();
        sp.close();
        
    }
    
}
