import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class QuestionBox extends Application{

    private Stage window;

    public static void main(String[] args){
        //LAUNCH THE FORM
        launch(args);
    }

    //OVERRIDE start FROM Application
    @Override
    public void start(Stage primaryStage) throws Exception {
        //put primaryStage to window variable
        //primaryStage is the current form
        window = primaryStage;

        //set title of stage
        window.setTitle("This is Main page");

        //create the button
        Button dialogButton = new Button("Open Dialog box");

        //set action on button click
        dialogButton.setOnAction(e -> {
            boolean result = DialogBox.dialogDisplay("Yes or No?");
            System.out.println(result);
        });

        //set action on form/stage close
        window.setOnCloseRequest(e -> {
            e.consume();
            this.closeProgram();
        });

        //create a stackpane layout
        StackPane spLayout = new StackPane();
        //add element to layout
        spLayout.getChildren().add(dialogButton);

        //create a scene and pass the layout
        //scene is the functionality inside a form
        Scene mainScene = new Scene(spLayout,300,250);

        //set scene of stage
        window.setScene(mainScene);
        //show stage
        window.show();
    }

    //CREATE CLOSE PROGRAM METHOD
    public void closeProgram(){
        //call dialogbox
        boolean answer = DialogBox.dialogDisplay("Are you sure you want to close this window?");
        if (answer){
            window.close();
        }
    }
}
