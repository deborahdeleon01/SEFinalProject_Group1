package LogInMVC;

import database.User;

/**
 *
 * @author Jesus
 */
public class LogInController {

    public LogInController(LogInView logInView) {
        this.logInView = logInView;
        setupMethods();
    }

    LogInView logInView;

    private void setupMethods() {
        logInView.Register.setOnAction((event) -> {
            updateToregister();
            logInView.changeToRegistration();
        });

        logInView.ConfirmRegister.setOnAction((event) -> {
            System.out.println("registration confirmed");
        });
        logInView.SignIn.setOnAction((event) -> {
            User u = new User();
            String Password = logInView.getPasswordBox().getText();
            String Username = logInView.getUsernameLocal();
            u = database.Db.theDatabase().login(Password, Username);
            if (u != null){
                System.out.println("logged in!");
        }
        });

    }

    private void updateToregister() {
        logInView.getLogInTitle().setText("Welcome to VaqPaq!\nPlease register below");
    }

}
