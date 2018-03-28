import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class QuestionBox {

    static boolean answer;

    public static boolean dialogDisplay(String message){

        //CREATE A STAGE
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Dialog box");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        //CREATE ELEMENTS
        Label dialogMessage = new Label(message);
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        //SET EVENT ACTIONS
        yesBtn.setOnAction(e -> {
            answer = true;
            dialogStage.close();
        });

        noBtn.setOnAction(e -> {
            answer = false;
            dialogStage.close();
        });

        //CREATE LAYOUT
        VBox vLayout = new VBox(20);
        vLayout.getChildren().addAll(dialogMessage,yesBtn,noBtn);
        vLayout.setAlignment(Pos.CENTER);

        //CREATE SCENE
        Scene dialogScene = new Scene(vLayout,200,150);

        //SET SCENE TO STAGE
        dialogStage.setScene(dialogScene);
        dialogStage.showAndWait();

        return answer;
    }

    public static void closeProgram(Stage stage){
        boolean answer = QuestionBox.dialogDisplay("Are you sure you want to close this window?");
        if (answer){
            stage.close();
        }
    }
}
