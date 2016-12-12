package LogInMVC;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Main.Main;
import database.User;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Jesus
 *         Controls the link between the database and the view. It updates
 *         the log in screen as necessary depending on log in or register
 */
public class LogInController {

    Stage primaryStage;
    LogInView logInView;

    public LogInController(LogInView logInView) {
        this.logInView = logInView;
        setupMethods();
    }

    //sets up the methods for the buttons.
    private void setupMethods() {
        logInView.Register.setOnAction((event) -> {
            updateToregister();
            logInView.changeToRegistration();
        });
        logInView.ConfirmRegister.setOnAction((ActionEvent event) -> {
            String Password = logInView.getPasswordBox().getText();
            String Password2 = logInView.getConfirmPasswordLocal().getText();
            String Email = logInView.getUserNameText().getText();
            String FirstName = logInView.getFirstName().getText();
            String LastName = logInView.getLastName().getText();

            User u= new User(Email,FirstName,LastName,Password,"CSCI",1);
            if (Password.equals(Password2)) {
                System.out.println("Passowrds are the same");
                if (database.Db.theDatabase().register(u)) {
                    System.out.println("Success!");
                }

            } else {
                System.out.println("Passwords do not match");
            }
        });

        logInView.SignIn.setOnAction((ActionEvent event) -> {
            String Password = logInView.getPasswordBox().getText();
            String Email = logInView.getUserNameText().getText();

            User u = null;
            if (database.Db.theDatabase().login(Email,Password,u)==true) {
                try {
                    new Main().start(new Stage());
                    Stage stage = (Stage) logInView.getScene().getWindow();
                    stage.close();

                } catch (MalformedURLException ex) {
                    Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                incorrectInformation();
            }
        });

        logInView.BackSignIn.setOnAction((ActionEvent event) -> {
            logInView.changeToLogin();
        });

    }

    private void updateToregister() {
        logInView.getLogInTitle().setText("Welcome to VaqPaq!\nPlease register below");
        logInView.getUsernameLable().setText("E-Mail");
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
}
