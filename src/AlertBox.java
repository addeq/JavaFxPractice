import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void displayAlertBox(String title,String message){

        //CREATE THE FORM
        Stage window = new Stage(); //create a stage
        window.setTitle(title); //set stage title
        window.initModality(Modality.APPLICATION_MODAL); //set the box to priority //cant click parent form while in this form
        window.setMinWidth(300); //set minimum width to 300

        //CREATE THE CONTROLS
        Label label = new Label(message); //create label
        Button button = new Button("Close"); //create button
        button.setOnAction(e -> window.close()); //set action on click to close the form

        //CREATE THE LAYOUT
        VBox vLayout = new VBox(10); //create vertical layout box
        vLayout.getChildren().addAll(label,button); //add controls to layout
        vLayout.setAlignment(Pos.CENTER); //set alignment to center

        //CREATE THE SCENE
        Scene scene = new Scene(vLayout,300,200); //create scene and pass the layout

        //SET SCENE TO FORM
        window.setScene(scene); //set scene to stage
        window.showAndWait(); //set stage to show and wait
    }

    public static void main(String [] args){}

}
