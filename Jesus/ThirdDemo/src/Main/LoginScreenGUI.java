package Main;

import LogInMVC.LogInController;
import LogInMVC.LogInView;
import javafx.application.Application;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;


/**
 * This class creates the GUI for the log in screen
 *
 * @author Jesus
 */
public class LoginScreenGUI extends Application {

    @Override
    public void start(Stage primaryLogIn) throws Exception {
        LogInView login = new LogInView();
        LogInController controller = new LogInController(login);
        Scene scene = new Scene(login, 600, 500);
        
        
        String css = this.getClass().getResource("style.css").toExternalForm();
        login.getStylesheets().add(css);
        primaryLogIn.getIcons().addAll(new Image("vaq.png"));
        primaryLogIn.setTitle("test");
        primaryLogIn.setScene(scene);
        primaryLogIn.show();

    }

//    void incorrectInformation() {
//
//        final Stage dialog = new Stage();
//        dialog.initModality(Modality.APPLICATION_MODAL);
//        dialog.initOwner(primaryStage);
//        BorderPane dialogVbox = new BorderPane();
//        Text popupText = new Text("Incorrect username or password!");
//        dialogVbox.setCenter(popupText);
//        Scene dialogScene = new Scene(dialogVbox, 200, 100);
//        dialog.setScene(dialogScene);
//        dialog.setTitle("Incorrect");
//        dialog.getIcons().addAll(new Image("vaq.png"));
//        dialog.centerOnScreen();
//        dialog.show();
//    }



    public static void main(String[] args) {
        launch(args);
    }

//    Button logInButton() {
//        Button logInButton = new Button("Log into Vaq-Paq");
//
//        logInButton.setOnAction((ActionEvent e) -> {
//            LogInMethod();
//        });
//
//        return logInButton;
//    }

}
