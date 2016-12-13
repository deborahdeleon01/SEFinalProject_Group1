/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Jose_Balle
 */
public class EmailController {
    EmailModel emailModel;
    EmailView emailView;
    EmailSender sendEmail = new EmailSender();

    public EmailController(EmailModel emailModel, EmailView emailView) {
        this.emailModel = emailModel;
        this.emailView = emailView;
        setupHandlers();
    }

    public void setupHandlers() {
        emailView.getSendEmail().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //Variables
                String attachment = "test.txt";

                String email = getEmail();
                String password = getPassword();
                String toEmail = getSendTo();
                String subject = getEmailSubject();
                String message = getEmailMessage();
                
                           
                if(email.equals("@utrgv.edu") || email.isEmpty()) {
                    emailView.getEmailStatus().setText("Email Input is empty!");   
                }
                else if(password.isEmpty()) {
                    emailView.getEmailStatus().setText("Password Input is empty!");
                }
                else if(toEmail.isEmpty()) {
                    emailView.getEmailStatus().setText("Send Email To Input is empty!");
                }
                else {
                    //Update label.
                    emailView.updateEmailView();
                    
                    //Send Email
                    sendEmail.EmailSender(email, password, toEmail, subject, message, attachment);                    
                }
            }
        });
    }

    public String getEmail() {
        String email = emailView.getEmailText().getText();
        return email;
    }

    public String getPassword() {
        String password = emailView.getPassText().getText();
        return password;
    }

    public String getSendTo() {
        String sendTo = emailView.getToText().getText();
        return sendTo;
    }

    public String getEmailSubject() {
        String subject = emailModel.getSubject();
        return subject;
    }

    public String getEmailMessage() {
        String message = emailModel.getMessage();
        return message;
    }
}
