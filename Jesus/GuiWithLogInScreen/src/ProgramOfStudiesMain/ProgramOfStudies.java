package ProgramOfStudiesMain;

import java.io.File;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.samples.JFXtrasSampleBase;
import jfxtras.scene.control.ListView;


public class ProgramOfStudies extends JFXtrasSampleBase {

    public ProgramOfStudies() throws IOException {
        ObservableList<String> items = FXCollections.observableArrayList();

        String dirPath = "C:";
        File dir = new File(dirPath);
        String[] files = dir.list();
        if (files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            for (String aFile : files) {
                items.add(aFile);
            }
        }

        listView = new ListView<>();
        listView.setItems(items);
    }
    final ListView<String> listView;

    @Override
    public String getSampleName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Node getPanel(Stage stage) {
        VBox root = new VBox(5);
        root.setPadding(new Insets(30, 30, 30, 30));
        root.getChildren().add(listView);
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public String getJavaDocURL() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
