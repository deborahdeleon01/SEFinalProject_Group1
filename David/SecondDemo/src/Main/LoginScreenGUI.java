package Main;

import java.net.MalformedURLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;

/**
 * This class creates the GUI for the log in screen
 *
 * @author Jesus
 * @version 1.0
 */
public class LoginScreenGUI extends Application {
    GridPane mainLogIn = new GridPane();
    @Override
    public void start(Stage primaryLogIn) throws Exception {
        mainLogIn.setAlignment(Pos.CENTER);
        mainLogIn.setVgap(10);
        mainLogIn.setHgap(10);
        mainLogIn.setPadding(new Insets(25, 25, 25, 25));

        Scene sceneLogIn = new Scene(mainLogIn, 600, 600);

        primaryLogIn.setScene(sceneLogIn);
        primaryLogIn.show();

        Text LogInTitle = new Text();
        LogInTitle.setText("Welcome to Vaq-Paq \n"
                + "Login to continue");

        mainLogIn.add(LogInTitle, 0, 0, 2, 1);

        Label Username = new Label("User Name:");
        mainLogIn.add(Username, 0, 1);

        TextField userNameText = new TextField();
        mainLogIn.add(userNameText, 1, 1);

        Label password = new Label("Password");
        mainLogIn.add(password, 0, 2);

        PasswordField passwordBox = new PasswordField();
        mainLogIn.add(passwordBox, 1, 2);

        Button logInButton = new Button("Log into Vaq-Paq");
        HBox logInfield = new HBox(10);
        logInfield.setAlignment(Pos.BOTTOM_RIGHT);
        logInfield.getChildren().add(logInButton);
        mainLogIn.add(logInfield, 1, 4);

        logInButton.setOnAction((ActionEvent event) -> {
                Platform.runLater(() -> {
                    try {
                        new FirstGUI().start(new Stage());
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(LoginScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
