package marshgas2d;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    private static final URL FXML_URL_MAIN = Main.class.getClassLoader().getResource("fxml/elements.fxml");
    private static final URL FXML_URL_ELEMENTS = Main.class.getClassLoader().getResource("fxml/elements.fxml");

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent mainRoot = FXMLLoader.load(FXML_URL_MAIN);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(mainRoot, 300, 275));
        primaryStage.setX(300);
        primaryStage.setY(300);
        primaryStage.show();

        Parent elementsRoot = FXMLLoader.load(FXML_URL_ELEMENTS);
        Stage secondStage = new Stage();
        secondStage.setTitle("Elements");
        secondStage.setScene(new Scene(elementsRoot, 300, 275));
        secondStage.setX(1200);
        secondStage.setY(300);
        secondStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
