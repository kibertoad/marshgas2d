package marshgas2d.view;


import com.google.common.eventbus.EventBus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lombok.Setter;
import marshgas2d.events.SpawnMarkerEvent;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ElementsController implements Initializable {

    @Setter
    private EventBus eventBus;

    @FXML
    @Setter
    private Accordion elementsAccordion;

    @FXML
    @Setter
    private AnchorPane elementsPane;

    private void spawnMarkerImage() {
        eventBus.post(new SpawnMarkerEvent());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button buttonList = new Button("ButtonList");
        Button image = new Button("Image");
        Button textBox = new Button("TextBox");
        elementsPane.getChildren().add(buttonList);
        //elementsPane.getChildren().add(image);
        //elementsPane.getChildren().add(textBox);

        buttonList.setOnMouseClicked(event -> {
            System.out.println("Clicked.");
            spawnMarkerImage();
        });
    }

}
