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

    private static Scene scene;
    public static Juego game;

    public void setGame(Juego game) {
        this.game = game;
    }
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mesajuego").load(), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {
        launch();
        try {
            FXMLLoader fxml= App.loadFXML("mesajuego");
            MesajuegoController m= fxml.getController();
            m.jugarPartida(game);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
