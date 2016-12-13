package Main;

import LogInMVC.LogInController;
import LogInMVC.LogInView;
import htmlconverter.PDFConverter;
import htmlconverter.XML2HTML;
import htmlconverter.XMLMerger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * This class creates the GUI for the log in screen
 *
 * @author Jesus
 */
public class LoginScreenGUI extends Application {
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * 
     * @param primaryLogIn
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryLogIn) throws Exception {
        LogInView login = new LogInView();
        LogInController controller = new LogInController(login);
        Scene scene = new Scene(login, 600, 500);


        String css = this.getClass().getResource("style.css").toExternalForm();
        login.getStylesheets().add(css);
        primaryLogIn.getIcons().addAll(new Image("vaq.png"));
        primaryLogIn.setTitle("VaqPack -- Computer Science Program of Study");
        primaryLogIn.setScene(scene);
        primaryLogIn.show();
        //      Converts entire directory and outputs each file into another (input directory, input xsl file, output directory)
        XML2HTML.convertDirectory2Html("XML", "STYLES/course.xsl", "HTML/");
        
//      Creating POS... Merge files together
        XMLMerger.mergeFilesFromDirectory("XML", "POS",  "STYLES/CSCI-POS.xml");
        XML2HTML.convert2Html("CSCI-POS.xml", "STYLES/CSCI-POS.xsl", "TEMP/output.html");
        PDFConverter.testConvert2Pdf();

    }
}
