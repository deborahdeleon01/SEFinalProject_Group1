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
 * @author Jesus
 *         Creates the design of the application
 */
public class LogInView extends GridPane {

    TextField userNameText = new TextField();
    TextField FirstName = new TextField();
    TextField LastName = new TextField();
    PasswordField passwordBox = new PasswordField();
    String PasswordLocal = passwordBox.getText();
    PasswordField ConfirmPasswordLocal = new PasswordField();
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
            + "Login to continue.");
    
    /**
     * LoginView Set Pane
     */
    public LogInView() {
        database.DirectoryStructure.createDirectoriesIfNotExists();
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
    
    /**
     * Changes pane to register.
     */
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
    
    /**
     * Changes pane back to login.
     */
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
    
    /**
     * 
     * @return FirstName
     */
    public TextField getFirstName() {
        return FirstName;
    }
    
    /**
     * 
     * @param FirstName set
     */
    public void setFirstName(TextField FirstName) {
        this.FirstName = FirstName;
    }
    
    /**
     * 
     * @return LastName
     */
    public TextField getLastName() {
        return LastName;
    }
    
    /**
     * 
     * @param LastName set
     */
    public void setLastName(TextField LastName) {
        this.LastName = LastName;
    }
    
    /**
     * 
     * @return FirstNameLable
     */
    public Label getFirstNameLable() {
        return FirstNameLable;
    }
    
    /**
     * 
     * @param FirstNameLable set
     */
    public void setFirstNameLable(Label FirstNameLable) {
        this.FirstNameLable = FirstNameLable;
    }
    
    /**
     * 
     * @return LastNameLable
     */
    public Label getLastNameLable() {
        return LastNameLable;
    }
    
    /**
     * 
     * @param LastNameLable set
     */
    public void setLastNameLable(Label LastNameLable) {
        this.LastNameLable = LastNameLable;
    }
    
    
    /**
     * 
     * @return userNameText
     */
    public TextField getUserNameText() {
        return userNameText;
    }
    
    /**
     * 
     * @param userNameText set
     */
    public void setUserNameText(TextField userNameText) {
        this.userNameText = userNameText;
    }
    
    /**
     * 
     * @return passwordBox
     */
    public PasswordField getPasswordBox() {
        return passwordBox;
    }
    
    /**
     * 
     * @param passwordBox set
     */
    public void setPasswordBox(PasswordField passwordBox) {
        this.passwordBox = passwordBox;
    }
    
    /**
     * 
     * @return PasswordLocal
     */
    public String getPasswordLocal() {
        return PasswordLocal;
    }
    
    /**
     * 
     * @param PasswordLocal set
     */
    public void setPasswordLocal(String PasswordLocal) {
        this.PasswordLocal = PasswordLocal;
    }
    
    /**
     * 
     * @return Register
     */
    public Button getRegister() {
        return Register;
    }
    
    /**
     * 
     * @param Register set
     */
    public void setRegister(Button Register) {
        this.Register = Register;
    }
    
    /**
     * 
     * @return SignIn
     */
    public Button getSignIn() {
        return SignIn;
    }
    
    /**
     * 
     * @param SignIn set
     */
    public void setSignIn(Button SignIn) {
        this.SignIn = SignIn;
    }
    
    /**
     * 
     * @return UsernameLable
     */
    public Label getUsernameLable() {
        return UsernameLable;
    }
    
    /**
     * 
     * @param UsernameLable set
     */
    public void setUsernameLable(Label UsernameLable) {
        this.UsernameLable = UsernameLable;
    }
    
    /**
     * 
     * @return PasswordLable
     */
    public Label getPasswordLable() {
        return PasswordLable;
    }
    
    /**
     * 
     * @param PasswordLable set
     */
    public void setPasswordLable(Label PasswordLable) {
        this.PasswordLable = PasswordLable;
    }
    
    /**
     * 
     * @return ConfirmPasswordLocal
     */
    public PasswordField getConfirmPasswordLocal() {
        return ConfirmPasswordLocal;
    }
    
    /**
     * 
     * @param ConfirmPasswordLocal set
     */
    public void setConfirmPasswordLocal(PasswordField ConfirmPasswordLocal) {
        this.ConfirmPasswordLocal = ConfirmPasswordLocal;
    }
    
    /**
     * 
     * @return ConfirmRegister
     */
    public Button getConfirmRegister() {
        return ConfirmRegister;
    }
    
    /**
     * 
     * @param ConfirmRegister set
     */
    public void setConfirmRegister(Button ConfirmRegister) {
        this.ConfirmRegister = ConfirmRegister;
    }
    
    /**
     * 
     * @return ConfirmPasswordLable
     */
    public Label getConfirmPasswordLable() {
        return ConfirmPasswordLable;
    }
    
    /**
     * 
     * @param ConfirmPasswordLable set
     */
    public void setConfirmPasswordLable(Label ConfirmPasswordLable) {
        this.ConfirmPasswordLable = ConfirmPasswordLable;
    }
    
    /**
     * 
     * @return LogInTitle
     */
    public Text getLogInTitle() {
        return LogInTitle;
    }
    
    /**
     * 
     * @param LogInTitle set
     */
    public void setLogInTitle(Text LogInTitle) {
        this.LogInTitle = LogInTitle;
    }
}
