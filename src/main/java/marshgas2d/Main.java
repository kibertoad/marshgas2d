package marshgas2d;

import com.google.common.eventbus.EventBus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import marshgas2d.view.CanvasController;
import marshgas2d.view.ElementsController;

import java.net.URL;

public class Main extends Application {

    private final EventBus eventBus = new EventBus();

    private static final URL FXML_URL_MAIN = Main.class.getClassLoader().getResource("fxml/canvas.fxml");
    private static final URL FXML_URL_ELEMENTS = Main.class.getClassLoader().getResource("fxml/elements.fxml");

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(FXML_URL_MAIN);
        Parent mainRoot = loader.load();

        CanvasController canvasController = loader.getController();
        canvasController.setEventBus(eventBus);
        eventBus.register(canvasController);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(mainRoot, 300, 275));
        primaryStage.setX(300);
        primaryStage.setY(300);

        canvasController.postInitialize();
        primaryStage.show();

        FXMLLoader loader2 = new FXMLLoader(FXML_URL_ELEMENTS);
        Parent elementsRoot = loader2.load();

        ElementsController elementsController = loader2.getController();
        elementsController.setEventBus(eventBus);

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
