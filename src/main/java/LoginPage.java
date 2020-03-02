import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage {

    public void build(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        Label labelTitle = new Label("Bine ai venit");
        Label labelUsername = new Label("Username:");
        Label labelPassword = new Label("Password:");
        TextField textFieldUsername = new TextField();
        PasswordField passwordField = new PasswordField();
        Button buttonLogin = new Button("Login");
        Label labelRes = new Label();
        gridPane.setConstraints(labelTitle, 0, 0);
        gridPane.setConstraints(labelUsername, 0, 1);
        gridPane.setConstraints(textFieldUsername, 1, 1);
        gridPane.setConstraints(labelPassword, 0, 2);
        gridPane.setConstraints(passwordField, 1, 2);
        gridPane.setConstraints(labelRes, 0, 3);
        gridPane.setConstraints(buttonLogin, 1, 3);
        gridPane.getChildren().addAll(labelTitle, labelUsername, labelPassword,
                textFieldUsername, passwordField, buttonLogin, labelRes);
        Scene scene = new Scene(gridPane);
        buttonLogin.setOnMouseClicked(e -> {
            String user = textFieldUsername.getText();
            String pass = passwordField.getText();
            DatabaseConnection databaseConnection = new DatabaseConnection();
            boolean found = databaseConnection.findUser(user, pass);
            if(found) {
                ListingPage listingPage = new ListingPage();
                listingPage.build(stage);
            } else {
                labelRes.setText("Mai incearca...");
            }
        });
        Button registerButton = new Button("Register");
        registerButton.setOnMouseClicked( e -> {
            RegisterPage registerPage = new RegisterPage();
            registerPage.build(stage);
        });
        gridPane.setConstraints(registerButton, 2, 3);
        gridPane.getChildren().add(registerButton);

        stage.setScene(scene);
    }
}
