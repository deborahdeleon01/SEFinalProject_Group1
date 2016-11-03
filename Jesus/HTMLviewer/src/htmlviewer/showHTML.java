package htmlviewer;

import javafx.scene.Scene;
import javafx.scene.web.WebView;

/**
 * @author Jesus
 *
 * @version 1.0
 */
public class showHTML {
    showHTML(){
        HTMLloader();
    }
    WebView HTMLload = new WebView();    
    
    public void HTMLloader(){
        try{
        HTMLload.getEngine().load("test.html");
    }
       catch(Exception e)  {
        }
    }

    private void HTMLpreviewer() {
        try {
            Scene HTMLpreview = new Scene(HTMLload, 400,400);
        } catch(Exception e)  {
        }

    }
}
