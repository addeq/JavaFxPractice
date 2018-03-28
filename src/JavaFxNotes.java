import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.application.Platform.setImplicitExit;

//Need to extend Application to run GUI
public class JavaFxNotes extends Application{

    //Need to override start method from Application to start
    //primaryStage is the main Stage
    //Stage is like the Main form or container of the form
    @Override
    public void start(Stage primaryStage) {

        //CREATE ELEMENTS//

        //Button
        Button button = new Button(); //creates new button
        button.setText("Button"); //set button text

        //Label
        Label label = new Label(); //creates new label
        label.setText("Label"); //set label text

        //Checkbox
        CheckBox checkbox = new CheckBox(); //checkbox element
        checkbox.setText("Checkbox"); //set checkbox text
        checkbox.setSelected(true); //true for initially check the checkbox

        //ChoiceBox
        ChoiceBox<String> choiceBox = new ChoiceBox<>(); //drop down list
        ObservableList choiceBoxList = choiceBox.getItems(); //get items node
        choiceBoxList.addAll("A","B","C"); //insert items on list
        choiceBox.setValue("A"); //set a default value

        //


        //CREATE LAYOUT//

        //VBox
        VBox vbox = new VBox(); //vertical alignment layout
        vbox.setSpacing(10); //set spacing between elements
        //Pos.CENTER: enum for position
        vbox.setAlignment(Pos.CENTER); //set elements alignment

        //HBox
        HBox hBox = new HBox(); //horizontal alignment layout
        hBox.setSpacing(10); //set spacing between elements

        //BorderPane
        BorderPane borderPane = new BorderPane(); //set position of layouts (top,bot,left,right)
        borderPane.setTop(vbox); //set position of vbox layout to top
        borderPane.setLeft(hBox); //set position of hbox to left

        //GridPane
        GridPane gridPane = new GridPane(); //position elements by coordinates
        gridPane.add(label,0,0); //set label position to column 0, row 0

        //StackPane
        StackPane stackPane = new StackPane(); //stack up elements layout
        //ObservableList object contains the elements you want to put to a layout
        ObservableList observableList =  stackPane.getChildren(); //get children nodes
        observableList.add(button); //add elements to the layout
        observableList.addAll(label,checkbox); //add multiple elements


        //CREATE EVENTS
        //set action on button click
        button.setOnAction(e -> System.out.println("TODO"));
        //set action on stage close
        primaryStage.setOnCloseRequest(e -> {
            e.consume(); //disregard the close function of the form to explicitly put logic on close
            primaryStage.close(); //close the main stage
        });


        //CREATE SCENE
        Scene scene = new Scene(stackPane,100,100); //set layout to the scene

        //SET STAGE
        primaryStage.setTitle("Main Stage"); //set title of main stage
        //modality is the mode of form
        // e.g.:APPLICATION_MODAL sets the focus to the current form only
        primaryStage.initModality(Modality.APPLICATION_MODAL); //set modality of stage
        primaryStage.setScene(scene); //set scene to main stage
        primaryStage.show(); //show the stage/form


    }

    //override stop from Application to put logic if the app is totally closed/stopped
    @Override
    public void stop() throws Exception {
        super.stop();

        //to set own logic for app termination set this to false
        //setImplicitExit(false);
        //the explicitly call this
        //Platform.exit();
    }

    //override init if you want to initialize some things before starting the app
    @Override
    public void init() throws Exception {
        super.init();
    }

    public static void main(String [] args){
        //call static class of Application to launch the app
        launch(args);

    }
}
