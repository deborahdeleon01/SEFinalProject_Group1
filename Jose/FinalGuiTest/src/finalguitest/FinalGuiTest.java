/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalguitest;

import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JComboBox;



/**
 *
 * @author Jose_Balle
 */
public class FinalGuiTest extends Application {
    
    /*GUI Heigh and Width*/
    private double guiHeight;
    private double guiWidth;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        Button btn2 = new Button();
        btn.setText("Say 'Apples World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        
        btn2.getStyleClass().add("button2");
        StackPane root2 = new StackPane();
        root2.getChildren().add(btn2);
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        Tab tab = new Tab();
        tab.setText("Home Tab");
        tab.setContent(root2);
        
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load("http://klayden.com/");
        
        Tab tab2 = new Tab();
        tab2.setText("Web View");
        tab2.setContent(browser);
        
        /*Tab 3 Select and View*/

        Text txt = new Text();
        String professor = "Lei";
        String pfname = null, pfhours = null, pf;
            
        ObservableList<String> options = 
        FXCollections.observableArrayList(
            "Sidique", "Lei", "Qwueider", "Yang", "Molina"
        );
        ComboBox comboBox = new ComboBox(options);
        comboBox.setPromptText("Select a Professor");

        // Update the message Label when the selected item changes
        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov, final String oldvalue, final String newvalue) {
                System.out.print(newvalue);;
            }
        });
        
//        if(pf == professor) {
//            pfname = pf;
//            pfhours = "Always";
//        }
        
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text(pfname);
        grid.add(name, 0, 0);


        Text hours = new Text(pfhours);
        grid.add(hours, 0, 1);


        BorderPane bpane = new BorderPane();
        bpane.setTop(comboBox);
        bpane.setCenter(txt);
        
        
        
        Tab tab3 = new Tab();
        tab3.setText("Selection Test");
        tab3.setContent(bpane);
        
        tabPane.getTabs().add(tab);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        
        /*Get monitor resolution and adjust GUI height and width to display properly.*/
        Rectangle2D primaryScreenResolution = Screen.getPrimary().getVisualBounds();
        guiWidth = primaryScreenResolution.getWidth() - 200;
        guiHeight = primaryScreenResolution.getHeight() - 100;
              
        Scene scene = new Scene(tabPane, guiWidth, guiHeight);
        
        String css = this.getClass().getResource("style.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        
        primaryStage.setTitle("VaqPaq Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
