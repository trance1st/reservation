import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListingPage {

    public void build(Stage stage) {
        HBox hBox = new HBox();
        Label labelTitle = new Label("Alege camera");
        hBox.getChildren().add(labelTitle);
        stage.setScene(new Scene(hBox));
    }
}
