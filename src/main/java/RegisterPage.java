import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class RegisterPage {

    public void build(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(30);
        gridPane.setVgap(30);
        Label labelUsername = new Label("Username");
        TextField textUsername = new TextField();
        Label labelPass = new Label("Password");
        TextField textPass = new TextField();
        Button buttonBack = new Button("Inapoi");
        Button buttonRegister = new Button("Register");
        GridPane.setConstraints(labelUsername, 0, 0);
        GridPane.setConstraints(textUsername, 1, 0);
        GridPane.setConstraints(labelPass, 0, 1);
        GridPane.setConstraints(textPass, 1, 1);
        GridPane.setConstraints(buttonBack, 0, 2);
        GridPane.setConstraints(buttonRegister, 1, 2);

        gridPane.getChildren().addAll(labelUsername, labelPass, textPass, textUsername, buttonRegister, buttonBack);
        buttonBack.setOnMouseClicked( e -> {
            LoginPage loginPage = new LoginPage();
            loginPage.build(stage);
        });
        buttonRegister.setOnMouseClicked( e -> {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.saveNewUser(textUsername.getText(), textPass.getText());
            LoginPage loginPage = new LoginPage();
            loginPage.build(stage);
        });
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
    }
}
