//this class is for the backend code of fxml
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{   //implements Initializable to set logic on initialize

    public Button button = new Button();

    public void handleButtonClick(){    //this is the method you will call on fxml
        System.out.println("Hello");
    }

    //set logic on initialization of the app
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialize");
    }
}
