/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Jose_Balle
 */
public class EmailView extends GridPane {

    private Text scenetitle = new Text("UTRGV Email");

    private Label emailLabel = new Label("Email:");
    private TextField emailText = new TextField("");

    private Label passLabel = new Label("Password:");
    private PasswordField passText = new PasswordField();

    private Label toLabel = new Label("Send Email To:");
    private TextField toText = new TextField("");

    private Label subjectLabel = new Label("Email Subject:");
    private TextField subjectText = new TextField("VacPak POS Email");

    private Label messageLabel = new Label("Message:");
    private TextArea messageText = new TextArea("Dear Student, \n\n\n");

    private Label emailStatus = new Label("");
    
    private Button sendEmail = new Button("Send Email");
    
    /**
     * Sets GridPane and all the labels and inputs.
     */
    public EmailView() {
        //Set GridPane        
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        //Add Fields
        this.add(scenetitle, 0, 0, 2, 1);
        this.add(emailLabel, 0, 1);
        this.add(emailText, 1, 1);
        this.add(passLabel, 0, 2);
        this.add(passText, 1, 2);
        this.add(toLabel, 0, 3);
        this.add(toText, 1, 3);
        this.add(subjectLabel, 0, 4);
        this.add(subjectText, 1, 4);
        this.add(messageLabel, 0, 5);
        this.add(messageText, 1, 5);
        this.add(sendEmail, 1, 7);
        this.add(emailStatus, 1, 8);
        
        //SetFont
        scenetitle.setFont(new Font(40));
        emailStatus.setFont(new Font(30));
    }
    
    /**
     * Clears all the inputs and resets them.
     */
    public void updateEmailView() {
        //this.getChildren().clear();
        emailText.setText("@utrgv.edu");
        passText.setText("");
        toText.setText("");
        subjectText.setText("VacPak POS Email");
        messageText.setText("Dear Student, \n\n\n");     
    }

    /**
     * @return the emailLabel
     */
    public Label getEmailLabel() {
        return emailLabel;
    }

    /**
     * @param emailLabel the emailLabel to set
     */
    public void setEmailLabel(Label emailLabel) {
        this.emailLabel = emailLabel;
    }

    /**
     * @return the emailText
     */
    public TextField getEmailText() {
        return emailText;
    }

    /**
     * @param emailText the emailText to set
     */
    public void setEmailText(TextField emailText) {
        this.emailText = emailText;
    }

    /**
     * @return the passLabel
     */
    public Label getPassLabel() {
        return passLabel;
    }

    /**
     * @param passLabel the passLabel to set
     */
    public void setPassLabel(Label passLabel) {
        this.passLabel = passLabel;
    }

    /**
     * @return the passText
     */
    public PasswordField getPassText() {
        return passText;
    }

    /**
     * @param passText the passText to set
     */
    public void setPassText(PasswordField passText) {
        this.passText = passText;
    }

    /**
     * @return the toLabel
     */
    public Label getToLabel() {
        return toLabel;
    }

    /**
     * @param toLabel the toLabel to set
     */
    public void setToLabel(Label toLabel) {
        this.toLabel = toLabel;
    }

    /**
     * @return the toText
     */
    public TextField getToText() {
        return toText;
    }

    /**
     * @param toText the toText to set
     */
    public void setToText(TextField toText) {
        this.toText = toText;
    }

    /**
     * @return the subjectLabel
     */
    public Label getSubjectLabel() {
        return subjectLabel;
    }

    /**
     * @param subjectLabel the subjectLabel to set
     */
    public void setSubjectLabel(Label subjectLabel) {
        this.subjectLabel = subjectLabel;
    }

    /**
     * @return the subjectText
     */
    public TextField getSubjectText() {
        return subjectText;
    }

    /**
     * @param subjectText the subjectText to set
     */
    public void setSubjectText(TextField subjectText) {
        this.subjectText = subjectText;
    }

    /**
     * @return the messageLabel
     */
    public Label getMessageLabel() {
        return messageLabel;
    }

    /**
     * @param messageLabel the messageLabel to set
     */
    public void setMessageLabel(Label messageLabel) {
        this.messageLabel = messageLabel;
    }

    /**
     * @return the messageText
     */
    public TextArea getMessageText() {
        return messageText;
    }

    /**
     * @param messageText the messageText to set
     */
    public void setMessageText(TextArea messageText) {
        this.messageText = messageText;
    }

    /**
     * @return the sendEmail
     */
    public Button getSendEmail() {
        return sendEmail;
    }

    /**
     * @param sendEmail the sendEmail to set
     */
    public void setSendEmail(Button sendEmail) {
        this.sendEmail = sendEmail;
    }

    /**
     * @return the emailStatus
     */
    public Label getEmailStatus() {
        return emailStatus;
    }

    /**
     * @param emailStatus the emailStatus to set
     */
    public void setEmailStatus(Label emailStatus) {
        this.emailStatus = emailStatus;
    }


}
