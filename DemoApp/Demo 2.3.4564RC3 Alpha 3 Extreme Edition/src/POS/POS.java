
package POS;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @DR3
 */
public class POS  {

    MyBrowser myBrowser;
    MyBrowser myBrowser2;
    BorderPane rootPane = new BorderPane();
    Path currentPath = Paths.get("");
    String path = currentPath.toAbsolutePath().toString();

    
    public POS(Stage primaryStage3) throws MalformedURLException {
        configureWebView();
        HBox hboxx = addHBox();
        rootPane.setLeft(hboxx);
        rootPane.setPadding(new Insets(100, 30, 100, 30));
        rootPane.setCenter(myBrowser2);

    }
    
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


