package marshgas2d.view;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lombok.Setter;
import marshgas2d.events.SpawnMarkerEvent;
import marshgas2d.fxutil.PostInitializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CanvasController implements Initializable, PostInitializable {

    @Setter
    private EventBus eventBus;

    private ImageView activeMarker;

    @FXML
    @Setter
    private Pane canvasPane;

    private static final URL PLACEHOLDER_IMAGE_URL = CanvasController.class.getResource("/assets/images/placeholder.png");
    private static final Image PLACEHOLDER_IMAGE = new Image(PLACEHOLDER_IMAGE_URL.toString());

    @Subscribe
    public void spawnMarker(SpawnMarkerEvent event) {
        System.out.println("Got event, let's spawn stuff.");
        activeMarker = new ImageView(PLACEHOLDER_IMAGE);
        activeMarker.setFocusTraversable(true);
        canvasPane.getChildren().add(activeMarker);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void postInitialize() {
        canvasPane.getScene().setOnMouseMoved(event -> {
            if (activeMarker != null) {
                System.out.print("Moved: " + event.getX() + "/" + event.getY());
                activeMarker.setX(event.getX());
                activeMarker.setY(event.getY());
            }
        });

        canvasPane.getScene().setOnMouseClicked(event -> {
            if (activeMarker != null) {
                activeMarker = null;
            }
        });

    }
}
