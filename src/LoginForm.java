import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginForm extends Application{
    Stage window;

    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Login Page");

        GridPane gPane = new GridPane();
        //set padding around the gridpane
        //insets is an object that can take 4 values
        gPane.setPadding(new Insets(10,10,10,10));

        //set spacing horizontally
        gPane.setHgap(8);

        //set spacing vertically
        gPane.setVgap(10);

        Label userNameLabel = new Label("Username: ");
        //set coordinates of element to where it should appear on grid
        gPane.setConstraints(userNameLabel,0,0);

        TextField userNameText = new TextField("Addeq");
        gPane.setConstraints(userNameText,1,0);

        Label passwordLabel = new Label("Password: ");
        gPane.setConstraints(passwordLabel, 0,1);

        TextField passwordText = new TextField();
        passwordText.setPromptText("password");
        gPane.setConstraints(passwordText,1,1);

        Button loginButton = new Button("Login");
        gPane.setConstraints(loginButton,0,3);
        gPane.getChildren().addAll(loginButton,userNameLabel,userNameText,passwordLabel,passwordText);

        Scene scene = new Scene(gPane, 250,150);

        window.setScene(scene);
        window.show();
    }
}
