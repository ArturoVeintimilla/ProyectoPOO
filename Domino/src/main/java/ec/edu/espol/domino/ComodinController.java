/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.domino;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    public int mesa_lado_fin;
    public int mesa_lado_inicio;
    public int L_1;
    public int L_2;
    private Juego game;
    private HBox h=null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retornar(MouseEvent event) {
        try{
            String texto_L1= lado1.getText();
            String texto_L2= lado2.getText();
            int L_1= Integer.parseInt(texto_L1);
            int L_2= Integer.parseInt(texto_L2);
            FXMLLoader fxml= App.loadFXML("mesajuego");
            MesajuegoController m= fxml.getController();
            if(mesa_lado_inicio==L_2){
                if(L_1==4&&L_2==4){
                    //h= setImagenes("dado4.jpg","dado4.jpg");
                    //m.setImagenComodinInicio("dado4.jpg", "dado4.jpg", game);
                }
                else if(L_2==4){
                    //h= setImagenes("dado"+texto_L1+".png","dado4.jpg");
                    m.setImagenComodinInicio("dado"+texto_L1+".png","dado4.jpg",game);
                }
                else if(L_1==4){
                    //h= setImagenes("dado4.jpg","dado"+texto_L2+".png");
                    m.setImagenComodinInicio("dado4.jpg", "dado"+texto_L2+".png", game);
                }
                else{
                    //h=setImagenes("dado"+texto_L1+".png","dado"+texto_L2+".png");
                    m.setImagenComodinInicio("dado"+texto_L1+".png", "dado"+texto_L2+".png", game);
                }
            }
            else if(mesa_lado_fin==L_1){
                if(L_1==4&&L_2==4){
                    //h= setImagenes("dado4.jpg","dado4.jpg");
                    m.setImagenComodinFinal("dado4.jpg", "dado4.jpg", game);
                }
                else if(L_2==4){
                    //h= setImagenes("dado"+texto_L1+".png","dado4.jpg");
                    m.setImagenComodinFinal("dado"+texto_L1+".png","dado4.jpg",game);
                }
                else if(L_1==4){
                    //h= setImagenes("dado4.jpg","dado"+texto_L2+".png");
                    m.setImagenComodinFinal("dado4.jpg", "dado"+texto_L2+".png", game);
                }
                else{
                    //h=setImagenes("dado"+texto_L1+".png","dado"+texto_L2+".png");
                    m.setImagenComodinFinal("dado"+texto_L1+"png", "dado"+texto_L2+".png", game);
                }
            }
            regresar_juego= (Button)event.getSource();
            Stage sp= (Stage) regresar_juego.getScene().getWindow();
            sp.close();
        }
        catch(IOException e){
            Alert a= new Alert(Alert.AlertType.ERROR,"No se pudo abrir el fxml");
            a.show();
        }
        catch(NumberFormatException ne)
        {
            Alert a = new Alert(Alert.AlertType.ERROR,"Ha ingresado caracteres inavlidos");
            a.show();
        }
    }
    public void setLados(int lado_inicio,int lado_fin){
        mesa_lado_fin=lado_fin;
        mesa_lado_inicio=lado_inicio;
    }
    public void setJuego(Juego game){
        this.game=game;
    }
    public HBox setImagenes(String L_1,String L_2){
        ImageView comodin_L1=new ImageView(L_1);
        ImageView comodin_L2= new ImageView(L_2);
        HBox hb= new HBox();
        comodin_L1.setFitHeight(80);
        comodin_L1.setFitWidth(80);
        comodin_L2.setFitHeight(80);
        comodin_L2.setFitWidth(80);
        hb.getChildren().addAll(comodin_L1,comodin_L2);
        return hb;
    }
        public HBox setImagenComodin(String L_1,String L_2,Juego game){
        ImageView comodin_L1=new ImageView(L_1);
        ImageView comodin_L2= new ImageView(L_2);
        HBox hb= new HBox();
        comodin_L1.setFitHeight(80);
        comodin_L1.setFitWidth(80);
        comodin_L2.setFitHeight(80);
        comodin_L2.setFitWidth(80);
        hb.getChildren().addAll(comodin_L1,comodin_L2);
        return hb;
    }
}
