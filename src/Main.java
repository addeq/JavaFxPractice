import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application{

    public static void main(String [] args){
        //launch this program
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("JavaFx Practice");

        //Controls to test goes here
        Button button = new Button();       //creates new button
        button.setText("Button");           //set button text
        button.getStyleClass().add("button-blue");
        //
        AnchorPane anchorPane = new AnchorPane();
        //Events for that controls goes here

        //
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button); //change the control here

        Scene scene = new Scene(stackPane,200,200);
        scene.getStylesheets().add("JavaFxStyleSheet.css");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //QUESTION BOX
    //Uncomment to test
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("This is Main page");
//
//        Button dialogButton = new Button("Open Dialog box");
//
//        dialogButton.setOnAction(e -> {
//            boolean result = QuestionBox.dialogDisplay("Yes or No?");
//            System.out.println(result);
//        });
//
//        primaryStage.setOnCloseRequest(e -> {
//            e.consume();
//            QuestionBox.closeProgram(primaryStage);
//        });
//
//        StackPane spLayout = new StackPane();
//        spLayout.getChildren().add(dialogButton);
//
//        Scene mainScene = new Scene(spLayout,300,250);
//        primaryStage.setScene(mainScene);
//        primaryStage.show();
//
//    }

    //ALERT BOX
    //Uncomment to test
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Main window");
//
//        Button alertBoxBtn = new Button("AlertBox");
//        alertBoxBtn.setOnAction(e -> AlertBox.displayAlertBox("This is alert box", "Hello message"));
//
//        StackPane spLayout = new StackPane();
//        spLayout.getChildren().add(alertBoxBtn);
//
//        Scene mainScene = new Scene(spLayout,300,250);
//        primaryStage.setScene(mainScene);
//        primaryStage.show();
//    }



}
