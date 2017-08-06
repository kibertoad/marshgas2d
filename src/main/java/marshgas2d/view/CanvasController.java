package marshgas2d.view;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import lombok.Setter;
import marshgas2d.events.SpawnMarkerEvent;
import marshgas2d.fxutil.PostInitializable;
import marshgas2d.model.elements.ElementMarker;

import java.net.URL;
import java.util.*;

public class CanvasController implements Initializable, PostInitializable {

    @Setter
    private EventBus eventBus;

    private ImageView activeMarkerView;

    private final Map<ImageView, ElementMarker> markerMap = new HashMap<>();

    @FXML
    @Setter
    private Pane canvasPane;

    private static final URL PLACEHOLDER_IMAGE_URL = CanvasController.class.getResource("/assets/images/placeholder.png");
    private static final Image PLACEHOLDER_IMAGE = new Image(PLACEHOLDER_IMAGE_URL.toString());

    @Subscribe
    public void spawnMarker(SpawnMarkerEvent event) {
        System.out.println("Got event, let's spawn stuff.");
        final ImageView newMarkerView = new ImageView(PLACEHOLDER_IMAGE);
        newMarkerView.setFocusTraversable(true);
        canvasPane.getChildren().add(newMarkerView);

        newMarkerView.setOnMouseClicked(clickedEvent -> {
            System.out.println("Element was clicked");

            if (MouseButton.SECONDARY.equals(clickedEvent.getButton())) {
                if (activeMarkerView == null) {
                    activeMarkerView = newMarkerView;
                    System.out.println("Element was selected");
                    clickedEvent.consume();
                }
            }
        });

        markerMap.put(newMarkerView, new ElementMarker(event.getElementPrototype()));
        activeMarkerView = newMarkerView;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void postInitialize() {
        canvasPane.getScene().setOnMouseMoved(event -> {
            if (activeMarkerView != null) {
                System.out.print("Moved: " + event.getX() + "/" + event.getY());
                activeMarkerView.setX(event.getX());
                activeMarkerView.setY(event.getY());
            }
        });

        canvasPane.getScene().setOnMouseClicked(event -> {
            if (activeMarkerView != null) {
                activeMarkerView = null;
                System.out.println("Element was deselected");
            }
        });

    }
}
