package Main;

import LogInMVC.LogInController;
import LogInMVC.LogInView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * This class creates the GUI for the log in screen
 *
 * @author Jesus
 */
public class LoginScreenGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryLogIn) throws Exception {
        LogInView login = new LogInView();
        LogInController controller = new LogInController(login);
        Scene scene = new Scene(login, 600, 500);


        String css = this.getClass().getResource("style.css").toExternalForm();
        login.getStylesheets().add(css);
        // primaryLogIn.getIcons().addAll(new Image("vaq.png"));
        primaryLogIn.setTitle("test");
        primaryLogIn.setScene(scene);
        primaryLogIn.show();

    }
}
