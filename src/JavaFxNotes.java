import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Iterator;

import static javafx.application.Platform.setImplicitExit;

//Need to extend Application to run GUI
public class JavaFxNotes extends Application{

    //Need to override start method from Application to start
    //primaryStage is the main Stage
    //Stage is like the Main form or container of the form
    @Override
    public void start(Stage primaryStage) {

        //CREATE CONTROLS//

        //Button
        Button button = new Button();                   //creates new button
        button.setText("Button");                       //set button text

        //TextField
        TextField textField = new TextField();      //create new textField
        textField.setText("Text Field");            //set text content
        textField.setPromptText("Text Field");      //set temporary initial content(will be deleted after inputting value)

        //Label
        Label label = new Label();          //creates new label
        label.setText("Label");             //set label text
        label.textProperty().bind(textField.textProperty());     //binding the label text property to text property(only works with properties)

        //Checkbox
        CheckBox checkbox = new CheckBox();         //checkbox element
        checkbox.setText("Checkbox");               //set checkbox text
        checkbox.setSelected(true);                 //true for initially check the checkbox

        //ChoiceBox
        ChoiceBox<String> choiceBox = new ChoiceBox<>();                //drop down list
        ObservableList<String> choiceBoxList = choiceBox.getItems();    //get items node
        choiceBoxList.addAll("A","B","C");                    //insert items on list
        choiceBox.setValue("A");                                        //set a default value
        String chcBoxVal = choiceBox.getValue();                        //get value of current selected

        //ComboBox
        ComboBox<String> comboBox = new ComboBox<>();                   //drop down list
        ObservableList<String> comboBoxList = comboBox.getItems();      //get items node
        comboBoxList.addAll("A","B","C");                     //insert items on list
        String cbBoxVal = choiceBox.getValue();                         //get value of current selected
        comboBox.setPromptText("Question");                             //set initial text on combo box

        //ListView
        ListView<String> listView = new ListView<>();                               //list of items
        ObservableList<String> listVal = listView.getItems();                       //get items node
        listVal.addAll("A","B","C");                                      //add items to the list
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);      //set selection to multiple
        listVal = listView.getSelectionModel().getSelectedItems();                  //get the selected items on list

        //TreeView
        TreeItem root = new TreeItem<>("Root");                              //create root node
        root.setExpanded(true);                                                    //set root to expand initially
        TreeItem parent = new TreeItem("Parent");                            //create parent node
        parent.setExpanded(true);                                                  //set parent to expand initially
        TreeItem<String> child = new TreeItem<>("Child");                    //create child node
        parent.getChildren().add(child);                                           //add child node to parent node
        root.getChildren().add(parent);                                            //add parent node to root node
        TreeView<String> treeView = new TreeView<>(root);                          //create tree view
        treeView.setShowRoot(false);                                               //hide root node

        //TableView
        TableColumn<Product,String> nameCol = new TableColumn<>("Name");        //create column for table
        nameCol.setMinWidth(200);                                                    //set minimum width
                                                                                     //PropertyValueFactory: specify the name of the field of object to be set in column
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));             //set the field of object to column
        TableView<Product> table = new TableView<>();                                //create a tableView
                                                                                     //setting the observableList interface to observableArrayList from FXCollections
        ObservableList<Product> products = FXCollections.observableArrayList();      //set data to observable list
        products.add(new Product("product",0.0,0));
        table.setItems(products);                                                    //pass the data to table
        table.getColumns().addAll(nameCol);                                          //add columns to the table

        //Menu
        Menu menu = new Menu("Menu");                                           //create menu
        //MenuItem
                                                                                     //_ on before the name sets the first letter of name as a shortcut
        MenuItem menuItem = new MenuItem("_Menu Item...");                      //create menu item
        //CheckMenuItem
        CheckMenuItem checkMenuItem = new CheckMenuItem("Check Menu item");     //create checkMenuItem
        //RadioMenuItem
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem radioMenuItem = new RadioMenuItem("Radio menu item");
        radioMenuItem.setToggleGroup(toggleGroup);
        ////
        menu.getItems().addAll(menuItem,checkMenuItem,radioMenuItem);               //adding menu item on menu
        menu.getItems().add(new SeparatorMenuItem());                               //add separator on menu item
        MenuBar menuBar = new MenuBar();                                            //create menu bar
        menuBar.getMenus().addAll(menu);                                            //add menu on menu bar


        //CREATE EVENTS

        //Button
        //set action on button click
        button.setOnAction(e -> System.out.println("TODO"));

        //CheckBox
        //set action on checkbox tick
        checkbox.setOnAction(e -> {
            System.out.println(checkbox.isSelected());                  //check if checkBox is checked
        });

        checkbox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });


        //ChoiceBox
        //set action to selection change of choice box
        //obvList = observable list
        //oldVal = old value
        //newVal = new value
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obvList, oldVal, newVal) -> {
            System.out.println(newVal);
        });

        //ComboBox
        //set action on selection on combo box
        comboBox.setOnAction(e ->{
            String cbBoxVale = comboBox.getValue();                     //get value of current selected
        });

        //TreeView
        //set action to item select on treeView
        //obvList = observable list
        //oldVal = old value
        //newVal = new value
        treeView.getSelectionModel().selectedItemProperty().addListener((obvList, oldVal, newVal) ->{
            System.out.println(newVal.getValue());
        });

        //MenuItem
        //set action on menu item click
        menuItem.setOnAction(e -> System.out.println());

        //Object Property
        //set an event when value of the object property is changed
        Product product = new Product();
        product.stringPropertyProperty().addListener( (v,oldVal,newVal) -> {
            System.out.println(product.getStringProperty());
        });

        //Stage
        //set action on stage close
        primaryStage.setOnCloseRequest(e -> {
            e.consume();                                        //disregard the close function of the form to explicitly put logic on close
            primaryStage.close();                               //close the main stage
        });


        //CREATE LAYOUT//

        //VBox
        VBox vbox = new VBox();                                                 //vertical alignment layout
        vbox.setSpacing(10);                                                    //set spacing between controls
        //Insets is an object containing 4 values
        vbox.setPadding(new Insets(20,20,20,20));          //set padding of layout
                                                                                //Pos.CENTER: enum for position
        vbox.setAlignment(Pos.CENTER);                                          //set controls alignment

        //HBox
        HBox hBox = new HBox();                                    //horizontal alignment layout
        hBox.setSpacing(10);                                       //   set spacing between controls

        //BorderPane
        BorderPane borderPane = new BorderPane();                   //set position of layouts (top,bot,left,right)
        borderPane.setTop(vbox);                                    //set position of vbox layout to top
        borderPane.setLeft(hBox);                                   //set position of hbox to left

        //GridPane
        GridPane gridPane = new GridPane();                         //position controls by coordinates
        gridPane.add(label,0,0);                //set label position to column 0, row 0

        //StackPane
        StackPane stackPane = new StackPane();                      //stack up controls layout
                                                                    //ObservableList object contains the controls you want to put to a layout
        ObservableList observableList =  stackPane.getChildren();   //get children nodes
        observableList.add(button);                                 //add controls to the layout
        observableList.addAll(label,checkbox);                      //add multiple controls

        //CREATE SCENE
        Scene scene = new Scene(stackPane,100,100);             //set layout to the scene


        //CSS
        scene.getStylesheets().add("JavaFxStyleSheet.css");         //set scene stylesheet
        button.getStyleClass().add("button-blue");                  //set specific custom style for this only
        button.setId("bold-text");                                  //use specific id for style

        //SET STAGE
        primaryStage.setTitle("Main Stage"); //set title of main stage
                                                                            //modality is the mode of form
                                                                            // e.g.:APPLICATION_MODAL sets the focus to the current form only
        primaryStage.initModality(Modality.APPLICATION_MODAL);              //set modality of stage
        primaryStage.setScene(scene);                                       //set scene to main stage
        primaryStage.show();                                                //show the stage/form


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
