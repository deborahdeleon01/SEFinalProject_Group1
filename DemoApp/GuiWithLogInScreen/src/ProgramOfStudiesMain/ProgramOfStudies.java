package ProgramOfStudiesMain;

import java.io.File;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jfxtras.scene.control.ListView;

public class ProgramOfStudies extends Application {

    StackPane rootPOS = new StackPane();

    public ProgramOfStudies() {
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

    }
    final ListView<String> listView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        rootPOS.getChildren().add(listView);
        //primaryStage.setScene(new Scene(rootPOS, 200, 250));
    }

    public StackPane getPane() {
        return rootPOS;
    }

    public void setPane(StackPane pane) {
        this.rootPOS = pane;
    }
}
