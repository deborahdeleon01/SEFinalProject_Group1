package LogInMVC;

import database.User;
import javafx.event.ActionEvent;

/**
 *
 * @author Jesus Controls the link between the database and the view. It updates
 * the log in screen as necessary depending on log in or register
 *
 */
public class LogInController {

    public LogInController(LogInView logInView) {
        this.logInView = logInView;
        setupMethods();
    }

    LogInView logInView;

    //sets up the methods for the buttons.
    private void setupMethods() {
        logInView.Register.setOnAction((event) -> {
            updateToregister();
            logInView.changeToRegistration();
        });

        logInView.ConfirmRegister.setOnAction((ActionEvent event) -> {
            String Password = logInView.getPasswordBox().getText();
            String Password2 = logInView.getConfirmPasswordLocal().getText();
            String Email = logInView.getUsernameLocal();
            String FirstName = logInView.getFirstName().getText();
            String LastName = logInView.getLastName().getText();
            if (Password.equals(Password2)) {
                System.out.println("Passowrds are the same");

            } else {
                System.out.println("Passwords do not match");
            }
        });

        logInView.SignIn.setOnAction((ActionEvent event) -> {
            User u = new User();
            String Password = logInView.getPasswordBox().getText();
            String Username = logInView.getUsernameLocal();
            u = database.Db.theDatabase().login(Password, Username);
            if (u != null) {
                System.out.println("logged in!");
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

}
