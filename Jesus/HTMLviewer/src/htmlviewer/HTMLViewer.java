package htmlviewer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Jesus
 */
public class HTMLViewer extends Application {

    @Override
    public void start(Stage htmlpane) {
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

    public static void main(String[] args) {
        launch(args);
    }

}
