package design_inscription;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("connexion"));
        stage.setScene(scene);
        stage.show();
    }
    private void  loadView(String fxml) throws IOException{
        AnchorPane root =(AnchorPane) App.loadFXML(fxml);
    }

    public static void setRoot(String fxml) throws IOException {
        Rectangle2D screen=Screen.getPrimary().getBounds();
        scene.getWindow().setX(3);
        scene.getWindow().setY(3);
        scene.getWindow().setWidth(screen.getWidth());
        scene.getWindow().setHeight(screen.getHeight());
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}