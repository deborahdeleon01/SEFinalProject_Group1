/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalguitest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import gpawidget.*;

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
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        Tab tab = new Tab();
        tab.setText("Home Tab");
        tab.setContent(root);
        
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load("http://klayden.com/");
        
        Tab tab2 = new Tab();
        tab2.setText("Web View");
        tab2.setContent(browser);
        
        
        Tab tab3 = new Tab();
        tab3.setText("Test 2");
        tab3.setContent(root);
        
        tabPane.getTabs().add(tab);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        
        /*Get monitor resolution and adjust GUI height and width to display properly.*/
        Rectangle2D primaryScreenResolution = Screen.getPrimary().getVisualBounds();
        guiWidth = primaryScreenResolution.getWidth() - 200;
        guiHeight = primaryScreenResolution.getHeight() - 100;
              
        Scene scene = new Scene(tabPane, guiWidth, guiHeight);
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
