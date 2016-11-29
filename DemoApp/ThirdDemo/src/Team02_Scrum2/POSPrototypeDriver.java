
package Team02_Scrum2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Germex
 */
public class POSPrototypeDriver  {

    List<String> listOfAllFiles2 = new ArrayList<>();
    List<String> listOfWantedFiles2 = new ArrayList<>();
    List<File> listOfAllFiles = new ArrayList<>();
    List<File> listOfWantedFiles;

    Button btn = new Button();
    Button merge = new Button();
    MyBrowser myBrowser;
    MyBrowser myBrowser2;
    BorderPane rootPane = new BorderPane();
    Path currentPath = Paths.get("");
    String path = currentPath.toAbsolutePath().toString();

    
    public POSPrototypeDriver(Stage primaryStage3) throws MalformedURLException {

        //configureControls();

        configureWebView();

       // hbox.getChildren().addAll(btn, merge);
       HBox hboxx = addHBox();
        rootPane.setLeft(hboxx);
        rootPane.setPadding(new Insets(100, 30, 100, 30));
        rootPane.setCenter(myBrowser2);
       


    }
//    /**
//     * Generates files in all directories
//     */
//    public void generateFiles() {
//        File folder = new File("FILE:///../XML/COURSES/");
//        listOfAllFiles2 = new ArrayList<>(Arrays.asList(folder.list()));
//
//        for (int i = 0; i < listOfAllFiles2.size(); i++) {
//
//            //if (listOfAllFiles2.get(i)){
//                if (listOfAllFiles2.get(i).charAt(9) != '-' || listOfAllFiles2.get(i).charAt(0) == 'P') {
//                listOfAllFiles2.set(i, "Courses/" + listOfAllFiles2.get(i));
//                    listOfWantedFiles2.add(listOfAllFiles2.get(i));
//                }
//            //}
//
//        }
//    }
//       
//    public void generateFiles(String directoryName, List<File> files) {
//        File directory = new File(directoryName);
//        // get all the files from a directory
//        File[] fList = directory.listFiles();
//        for (File file : fList) {
//            if (file.isFile()) {
//                
//                if (file.getName().charAt(0) != 'P'){
//               
//                    files.add(file);
//                }
//                
//            } else if (file.isDirectory()) {
//                generateFiles(file.getAbsolutePath(), files);
//            }
//        }
//    }
    
    //Configures the Webview
    private void configureWebView() throws MalformedURLException {
        myBrowser2 = new MyBrowser();
        rootPane.setCenter(myBrowser2);
    }
    
    //HBox
    private HBox addHBox() {
        HBox hboxx = new HBox();
        hboxx.setPadding(new Insets(50, 275, 50, 275));
        hboxx.setSpacing(10);
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
    final String hellohtml2 = "output06.htm";
    WebView webView2 = new WebView();
    WebEngine webEngine2 = webView2.getEngine();
    Path currentPath3 = Paths.get("");
    String path03 = currentPath3.toAbsolutePath().toString();
    
    public MyBrowser() throws MalformedURLException {
        String path3 = path03 + "/TEMP/output06.html";
        URL url = new URL("file:///" + path3);
        webEngine2.load(url.toExternalForm());
        getChildren().add(webView2);
    } 
}


