package POS;


import htmlconverter.XML2HTML;
import htmlconverter.XMLMerger;
import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * @DR3
 */
public class POS {

    MyBrowser myBrowser;
    MyBrowser myBrowser2;
    BorderPane rootPane = new BorderPane();
    Path currentPath = Paths.get("");
    String path = currentPath.toAbsolutePath().toString();
    File folder = new File(path + "/TEMP/");
    File[] listOfFiles = folder.listFiles();
    public int index = 0;
    public int count = 0;
    HBox hbx;


    public POS(Stage primaryStage3) throws MalformedURLException {
        configureWebView();

          rootPane.setPadding(new Insets(100, 30, 100, 30));
   
    }

    //Configures the Webview
    private void configureWebView() throws MalformedURLException {
        HBox hboxx = addHBox();
        rootPane.setLeft(hboxx);
        myBrowser2 = new MyBrowser();
        rootPane.setCenter(myBrowser2);
        
    }

    //HBox
    private HBox addHBox() {
        HBox hboxx = new HBox();
        hboxx.setPadding(new Insets(50, 75, 50, 75));
        hboxx.setSpacing(10);
        ObservableList<String> ProgOfStudy = 
    FXCollections.observableArrayList(
        "ComputerScienceProgramOfStudy",
        "ComputerEngineeringProgramOfStudy"  
    );
        ComboBox listOfPOS = new ComboBox(ProgOfStudy);
        listOfPOS.setValue("Choose a Program Of Study");
        //posf = String.valueOf(listOfPOS.get.toString());
        hboxx.getChildren().addAll(listOfPOS);
        listOfPOS.valueProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue ov, String t, String t1) {
        //      Creating POS... Merge files together
            if ("ComputerEngineeringProgramOfStudy".equals(t1)) {
                XMLMerger.mergeFilesFromDirectory("XML", "POS",  "STYLES/CMPE-POS.xml");
        XML2HTML.convert2Html("CMPE-POS.xml", "STYLES/CMPE-POS.xsl", "TEMP/output.html");
        
        
            }
            else if ("ComputerScienceProgramOfStudy".equals(t1)){
        XMLMerger.mergeFilesFromDirectory("XML", "POS",  "STYLES/CSCI-POS.xml");
        XML2HTML.convert2Html("CSCI-POS.xml", "STYLES/CSCI-POS.xsl", "TEMP/output.html");
        
            }
       
        }    
    });
       
       
        return hboxx;
        
    }

    public BorderPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(BorderPane root) {
        this.rootPane = root;
    }
}

//Browser Class
class MyBrowser extends Region {
    final String hellohtml2 = "ComputerScienceProgramOfStudy.html";
    WebView webView2 = new WebView();
    WebEngine webEngine2 = webView2.getEngine();
    Path currentPath2 = Paths.get("");
    String path02 = currentPath2.toAbsolutePath().toString();
    String pos = "output.html";

    public MyBrowser() throws MalformedURLException {
        String path2 = path02 + "/TEMP/"+ pos;
        URL url = new URL("file:///" + path2);
     
        
        webEngine2.load(url.toExternalForm());
        getChildren().add(webView2);
        
    }

}


