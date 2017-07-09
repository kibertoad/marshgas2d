package marshgas2d.view;


import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import lombok.Setter;

public class ElementsController {

    @FXML
    @Setter
    private Accordion elementsAccordion;

    @FXML
    @Setter
    private AnchorPane elementsPane;

    public void initialize() {
        Button button1 = new Button("wub-wub");
        elementsPane.getChildren().add(button1);
    }


}
