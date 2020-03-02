import javafx.application.Application;
import javafx.stage.Stage;

public class Lab2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LoginPage loginPage = new LoginPage();
        loginPage.build(primaryStage);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.show();
    }
}
