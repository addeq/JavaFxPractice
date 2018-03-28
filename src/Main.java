import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String [] args){
        //launch this program
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

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
