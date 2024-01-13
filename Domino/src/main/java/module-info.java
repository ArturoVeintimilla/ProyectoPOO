module ec.edu.espol.domino {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.domino to javafx.fxml;
    exports ec.edu.espol.domino;
}
