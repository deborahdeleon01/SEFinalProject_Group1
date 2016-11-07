package htmlviewer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author Jesus This class will load an HTML class from a predetermined
 * source(local or database) and add it to a scene
 *
 * @version 1.0.1
 */
public class showHTML {

    WebView HTMLload = new WebView();

    /*
     * @param htmlpane precreates the stage 
     * This class will use exception handling to compensate in case that the file does not exist 
     */
    public void HTMLloader(Stage htmlpane) {
        try {
            WebView HTMLload = new WebView();
//            String path = System.getProperty("user.dir");  
//            path.replace("\\\\", "/");  
//            path +=  "test.html";  
            HTMLload.getEngine().load(getClass().getResource("test.html").toExternalForm());
            Scene HTMLview = new Scene(HTMLload, 400, 400);
            htmlpane.setScene(HTMLview);
            htmlpane.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}