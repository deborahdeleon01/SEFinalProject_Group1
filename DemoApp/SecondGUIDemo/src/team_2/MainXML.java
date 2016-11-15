/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_2;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;

/**
 *
 * @author DR3
 */
public class MainXML {
     //private Scene scene;
    public Scene scene2;
    XMLGenerator gen = new XMLGenerator(null);
    public int count = 0;
    public int index = 0;
    Button back = new Button("BACK");
    Button forward = new Button("FORWARD");
    BorderPane mainXMLPane = new BorderPane();
    File[] listOfFiles2;
    HBox controls = new HBox(10);
    MyBrowser myBrowser;
    URL urlHello;
    
    Path currentPath = Paths.get("");
    String path = currentPath.toAbsolutePath().toString();

    ArrayList<File> xmlCourses = new ArrayList<>();

   
    String xmlFile;
    String xslFile = path + "/src/team_2/courseXsl.xsl";
    String htmlFile = path + "/src/team_2/output.html";
    File folder = new File(path + "/CoursesXML/");
        File[] listOfFiles = folder.listFiles();

   
    public  MainXML(Stage primaryStage2) throws MalformedURLException {

        configureDisplay();

        configureListeners();

        generateFiles();

        //Removed to make the xml appear on the tabs
        //scene2 = new Scene(mainXMLPane);

        //primaryStage2.setScene(scene2);
        //primaryStage2.show();

        //primaryStage2.setTitle("Prototype XML2HTML");
        //primaryStage2.setScene(scene2);
        //primaryStage2.show();
        
    }
    
    //Creat HBox for left border pane with drop box list of courses
    private HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(30, 200, 30, 200));
        hbox.setSpacing(10);   // Gap between nodes
       // hbox.setStyle("-fx-background-color: #336699
        Button go = new Button("GO");
        final ComboBox listOfCourses = new ComboBox();
        for (int i = 0; i < listOfFiles.length; i++)
        {
           
            listOfCourses.getItems().addAll(listOfFiles[i].getName());
        }
        go.setPrefSize(50, 20);
        listOfCourses.setValue("Choose a Course");
        index = listOfCourses.getSelectionModel().getSelectedIndex();
        hbox.getChildren().addAll(listOfCourses,go);
        go.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent event){
                index = listOfCourses.getSelectionModel().getSelectedIndex();
        XML2HTML xml2htmlObject = new XML2HTML(listOfFiles[index].getAbsolutePath(), xslFile, htmlFile);
        xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName());
        try {
                configureDisplay();
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
        
        return hbox;
    }
     //Configuering Event Listener
    private void configureListeners () throws MalformedURLException {

        /**
         * Forward click. Count increases to go to next XML file and merges said
         * file.
         */
        forward.setOnAction((ActionEvent event) -> {
            count++;
            XML2HTML xml2htmlObject = new XML2HTML(listOfFiles[count].getAbsolutePath(), xslFile, htmlFile);
            xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName());
            try {
                configureDisplay();
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        /**
         * Back button click, Count decreases in array to go to said XML file
         * and converts it again to output.htm
         */
        back.setOnAction((ActionEvent event) -> {
            count--;
            XML2HTML xml2htmlObject = new XML2HTML(listOfFiles[count].getAbsolutePath(), xslFile, htmlFile);
            xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName());
            try {
                configureDisplay();
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void configureDisplay() throws MalformedURLException {
        HBox hbox = addHBox();
        controls.getChildren().removeAll(back, forward);
        mainXMLPane.setLeft(hbox);
        myBrowser = new MyBrowser();
        mainXMLPane.setCenter(myBrowser);
        controls.setAlignment(Pos.CENTER);
        controls.getChildren().addAll(back, forward);
        mainXMLPane.setBottom(controls);
    }

    private void generateFiles() {
//        File folder = new File(path + "/CoursesXML/");
//        listOfFiles = folder.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                System.out.println("File " + listOfFile.getName());
            }
        }
        try {
            configureDisplay();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



/**
 * Create own browser to display .html document.
 *
 * @author DR3 
 *
 */
    
class MyBrowser extends Region {

    final String hellohtml = "output.html";

    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();
    Path currentPath = Paths.get("");
    String path = currentPath.toAbsolutePath().toString();
      

    public MyBrowser() throws MalformedURLException {

        String path2 = path + "/src/team_2/output.html";
        URL url = new URL("file:///" + path2);

        webEngine.load(url.toExternalForm());

        getChildren().add(webView);
   
    }
}

    //Getter and setter for Border Pane mainXMLPane
    public BorderPane getMainXMLPane() {
        return mainXMLPane;
    }

    public void setMainXMLPane(BorderPane mainXMLPane) {
        this.mainXMLPane = mainXMLPane;
    }

}
