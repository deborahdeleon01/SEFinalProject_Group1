/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import gpawidget.GPAWidget;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 

public class FirstGUI extends Application {
    GPAWidget gpaWidget = new GPAWidget(600,600,0,4,0,0.2);
    Info info = new Info();

  @Override
  public void start(Stage primaryStage) {
      primaryStage.setTitle("VaqPack -- Computer Science Program of Study");
      //set App icon
      primaryStage.getIcons().addAll(new Image("vaq.png"));
      Group root = new Group();
      Scene scene = new Scene(root);
      TabPane tabPane = new TabPane();
      BorderPane mainPane = new BorderPane();
      tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
     
//Basic CSS
       root.setId("eff");
       scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

      tabPane.getTabs().addAll(tabA(),tabB(),tabC());

      mainPane.setCenter(tabPane);
      mainPane.prefHeightProperty().bind(scene.heightProperty());
      mainPane.prefWidthProperty().bind(scene.widthProperty());
      root.getChildren().add(mainPane);
      primaryStage.setMaximized(true);
      primaryStage.setScene(scene);
      primaryStage.show();
  }
  
  private Tab tabA()
  {
      Tab tabA = new Tab();
      tabA.setText("Program of Study");
      //Add WebView in TabA
      WebView browser = new WebView();
      WebEngine webEngine = browser.getEngine();
      webEngine.load("http://klayden.com/");
      tabA.setContent(browser);
      return tabA;
  }
  
   
    private Tab tabB()
  {
      
      Tab tabB = new Tab();
      tabB.setText("Information");
      //Add GPA Widget in TabC
      StackPane tabB_stack = new StackPane();
      tabB_stack.setAlignment(Pos.CENTER);
      tabB_stack.getChildren().add(info.getPane());
      tabB.setContent(tabB_stack);
      return tabB;
  }
  
    private Tab tabC()
  {
      Tab tabC = new Tab();
      tabC.setText("Reporting");
      //Add something in TabB
      StackPane tabC_stack = new StackPane();
      tabC_stack.setAlignment(Pos.CENTER);
      tabC_stack.getChildren().add(gpaWidget.getPane());
      tabC.setContent(tabC_stack);
      return tabC;
  }
  


    /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      launch(args);
  }
}

    
    

