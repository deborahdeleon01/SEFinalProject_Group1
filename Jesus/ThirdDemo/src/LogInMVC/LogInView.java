package LogInMVC;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Jesus
 * Creates the design of the application
 */
public class LogInView extends GridPane {

    TextField userNameText = new TextField();
    TextField FirstName = new TextField();
    TextField LastName = new TextField();
    PasswordField passwordBox = new PasswordField();
    String PasswordLocal = passwordBox.getText();
    PasswordField ConfirmPasswordLocal = new PasswordField();
    String UsernameLocal = userNameText.getText();
    Button Register = new Button("Register");
    Button ConfirmRegister = new Button("Register");
    Button SignIn = new Button("Sign in");
    Button BackSignIn = new Button("Sign in");
    Label UsernameLable = new Label("User Name:");
    Label FirstNameLable = new Label("First Name:");
    Label LastNameLable = new Label("Last Name:");
    Label PasswordLable = new Label("Password");
    Label ConfirmPasswordLable = new Label("Confirm Password");
    Text LogInTitle = new Text("Welcome to Vaq-Paq \n"
            + "Login to continue");

    public LogInView() {
        this.ConfirmPasswordLocal = new PasswordField();
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        this.add(LogInTitle, 0, 0, 2, 1);
        this.add(UsernameLable, 0, 1);
        this.add(userNameText, 1, 1);
        this.add(PasswordLable, 0, 2);
        this.add(passwordBox, 1, 2);
        this.add(SignIn, 1, 3);
        this.add(Register, 1, 4);

    }

    public void changeToRegistration() {
        this.getChildren().clear();

        this.add(LogInTitle, 0, 0, 2, 1);
        this.add(UsernameLable, 0, 1);
        this.add(userNameText, 1, 1);
        this.add(FirstNameLable, 0, 2);
        this.add(FirstName, 1, 2);
        this.add(LastNameLable, 0, 3);
        this.add(LastName, 1, 3);
        this.add(PasswordLable, 0, 4);
        this.add(passwordBox, 1, 4);
        this.add(ConfirmPasswordLable, 0, 5);
        this.add(ConfirmPasswordLocal, 1, 5);
        this.add(ConfirmRegister, 1, 6);
        this.add(BackSignIn, 1, 7);
    }

    public void changeToLogin() {
        this.getChildren().clear();

        this.add(LogInTitle, 0, 0, 2, 1);
        this.add(UsernameLable, 0, 1);
        this.add(userNameText, 1, 1);
        this.add(PasswordLable, 0, 2);
        this.add(passwordBox, 1, 2);
        this.add(SignIn, 1, 3);
        this.add(Register, 1, 4);

    }

    public TextField getFirstName() {
        return FirstName;
    }

    public void setFirstName(TextField FirstName) {
        this.FirstName = FirstName;
    }

    public TextField getLastName() {
        return LastName;
    }

    public void setLastName(TextField LastName) {
        this.LastName = LastName;
    }

    public Label getFirstNameLable() {
        return FirstNameLable;
    }

    public void setFirstNameLable(Label FirstNameLable) {
        this.FirstNameLable = FirstNameLable;
    }

    public Label getLastNameLable() {
        return LastNameLable;
    }

    public void setLastNameLable(Label LastNameLable) {
        this.LastNameLable = LastNameLable;
    }

    public TextField getUserNameText() {
        return userNameText;
    }

    public void setUserNameText(TextField userNameText) {
        this.userNameText = userNameText;
    }

    public PasswordField getPasswordBox() {
        return passwordBox;
    }

    public void setPasswordBox(PasswordField passwordBox) {
        this.passwordBox = passwordBox;
    }

    public String getPasswordLocal() {
        return PasswordLocal;
    }

    public void setPasswordLocal(String PasswordLocal) {
        this.PasswordLocal = PasswordLocal;
    }

    public String getUsernameLocal() {
        return UsernameLocal;
    }

    public void setUsernameLocal(String UsernameLocal) {
        this.UsernameLocal = UsernameLocal;
    }

    public Button getRegister() {
        return Register;
    }

    public void setRegister(Button Register) {
        this.Register = Register;
    }

    public Button getSignIn() {
        return SignIn;
    }

    public void setSignIn(Button SignIn) {
        this.SignIn = SignIn;
    }

    public Label getUsernameLable() {
        return UsernameLable;
    }

    public void setUsernameLable(Label UsernameLable) {
        this.UsernameLable = UsernameLable;
    }

    public Label getPasswordLable() {
        return PasswordLable;
    }

    public void setPasswordLable(Label PasswordLable) {
        this.PasswordLable = PasswordLable;
    }

    public PasswordField getConfirmPasswordLocal() {
        return ConfirmPasswordLocal;
    }

    public void setConfirmPasswordLocal(PasswordField ConfirmPasswordLocal) {
        this.ConfirmPasswordLocal = ConfirmPasswordLocal;
    }

    public Button getConfirmRegister() {
        return ConfirmRegister;
    }

    public void setConfirmRegister(Button ConfirmRegister) {
        this.ConfirmRegister = ConfirmRegister;
    }

    public Label getConfirmPasswordLable() {
        return ConfirmPasswordLable;
    }

    public void setConfirmPasswordLable(Label ConfirmPasswordLable) {
        this.ConfirmPasswordLable = ConfirmPasswordLable;
    }

    public Text getLogInTitle() {
        return LogInTitle;
    }

    public void setLogInTitle(Text LogInTitle) {
        this.LogInTitle = LogInTitle;
    }
}
