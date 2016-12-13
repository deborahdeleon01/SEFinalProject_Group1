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
    
    /**
     * 
     * @param emailModel
     * @param emailView 
     */
    public EmailController(EmailModel emailModel, EmailView emailView) {
        this.emailModel = emailModel;
        this.emailView = emailView;
        setupHandlers();
    }
    
    /**
     * Send Email Button handlers. Ensures fields are populated and sends email.
     */
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
                
                //Set label to email sending.
                emailView.getEmailStatus().setText("Email Sending...");
                
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
                    sendEmail.EmailSender(email, password, toEmail, subject, message, attachment, emailView.getEmailStatus());                    
                }
            }
        });
    }

    /**
     * 
     * @return email label text
     */
    public String getEmail() {
        String email = emailView.getEmailText().getText();
        return email;
    }
    
    /**
     * 
     * @return password label text
     */
    public String getPassword() {
        String password = emailView.getPassText().getText();
        return password;
    }
    
    /**
     * 
     * @return sentTo email label text
     */
    public String getSendTo() {
        String sendTo = emailView.getToText().getText();
        return sendTo;
    }
    
    /**
     * 
     * @return subject label text
     */
    public String getEmailSubject() {
        String subject = emailView.getSubjectText().getText();
        return subject;
    }
    
    /**
     * 
     * @return message label text
     */
    public String getEmailMessage() {
        String message = emailView.getMessageText().getText();
        return message;
    }
}
