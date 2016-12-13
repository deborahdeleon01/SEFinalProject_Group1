package Main;

import java.net.MalformedURLException;
import javafx.application.Application;
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
import javafx.event.ActionEvent;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

/**
 * This class creates the GUI for the log in screen
 *
 * @author Jesus
 */
public class LoginScreenGUI extends Application {

    GridPane mainLogIn = new GridPane();
    Stage primaryStage = null;
    TextField userNameText = new TextField();
    PasswordField passwordBox = new PasswordField();

    @Override
    public void start(Stage primaryLogIn) throws Exception {
        mainLogIn.setAlignment(Pos.CENTER);
        mainLogIn.setVgap(10);
        mainLogIn.setHgap(10);
        mainLogIn.setPadding(new Insets(25, 25, 25, 25));

        Scene sceneLogIn = new Scene(mainLogIn, 400, 300);

        primaryLogIn.setScene(sceneLogIn);
        primaryLogIn.show();

        mainLogIn.add(loginText(), 0, 0, 2, 1);

        Label Username = new Label("User Name:");
        mainLogIn.add(Username, 0, 1);

        mainLogIn.add(userNameText, 1, 1);

        Label password = new Label("Password");
        mainLogIn.add(password, 0, 2);

        mainLogIn.add(passwordBox, 1, 2);

        HBox logInfield = new HBox(10);
        logInfield.setAlignment(Pos.BOTTOM_RIGHT);
        logInfield.getChildren().add(logInButton());
        mainLogIn.add(logInfield, 1, 4);

        String css = this.getClass().getResource("style.css").toExternalForm();
        mainLogIn.getStylesheets().add(css);
        primaryLogIn.getIcons().addAll(new Image("vaq.png"));

    }

    void incorrectInformation() {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        BorderPane dialogVbox = new BorderPane();
        Text popupText = new Text("Incorrect username or password!");
        dialogVbox.setCenter(popupText);
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.setTitle("Incorrect");
        dialog.getIcons().addAll(new Image("vaq.png"));
        dialog.centerOnScreen();
        dialog.show();
    }

    void LogInMethod() {
        String Password = passwordBox.getText();
        String Username = userNameText.getText();
        final Stage stage;

        if (Password.equalsIgnoreCase("admin") && Username.equalsIgnoreCase("admin")) {
            try {
                new Main().start(new Stage());
                stage = (Stage) mainLogIn.getScene().getWindow();
                stage.close();

            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.print(Password + "\b" + Username);
            incorrectInformation();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    Button logInButton() {
        Button logInButton = new Button("Log into Vaq-Paq");

        logInButton.setOnAction((ActionEvent e) -> {
            LogInMethod();
        });

        return logInButton;
    }

    Text loginText() {
        Text LogInTitle = new Text();
        LogInTitle.setText("Welcome to Vaq-Paq \n"
                + "Login to continue");
        return LogInTitle;
    }
}
