import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ListIterator;
import java.util.Stack;

public class SimpleTableView extends Application{

    public static void main(String [] args){
        //launch this program
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Table");

        //Controls to test goes here

        //create columns of table
        //name
        TableColumn<Product,String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        //price
        TableColumn<Product,Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(200);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        //quantity
        TableColumn<Product,Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setMinWidth(200);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableView<Product> table = new TableView<>();
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setItems(getProduct());
        table.getColumns().addAll(nameCol,priceCol,quantityCol);

        Button delBut = new Button("Delete");

        //

        //Events for that controls goes here
        delBut.setOnAction(e -> {
            table.getItems().removeAll(table.getSelectionModel().getSelectedItems());

    });

        //
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(table,delBut); //change the control here

        Scene scene = new Scene(stackPane,200,200);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop",100.00,50));
        products.add(new Product("Phone",50.00,100));
        products.add(new Product("Tablet",40.00,20));

        return products;

    }

}
