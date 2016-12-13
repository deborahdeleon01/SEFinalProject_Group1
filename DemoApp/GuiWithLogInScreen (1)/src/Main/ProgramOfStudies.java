package Main;

import java.io.File;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class ProgramOfStudies extends Application {
    
    ListView<String> listView;
       
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("List View Sample");        
        ObservableList<String> items = FXCollections.observableArrayList();
        String dirPath = "C:\\Users\\Jesus\\OneDrive\\Documents\\SEFinalGroupProject\\DemoApp";
        File dir = new File(dirPath);
        String[] files = dir.list();
        if (files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            items.addAll(Arrays.asList(files));
        }

        listView = new ListView<>();
        listView.setItems(items);
         
        StackPane root = new StackPane();
        root.getChildren().add(listView);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }
}