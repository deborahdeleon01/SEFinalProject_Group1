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
     * SetupHandlers for send email button. It validates inputs as well as updating email label and sending info.
     */
    public void setupHandlers() {
        emailView.getSendEmail().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String current = new java.io.File( "." ).getCanonicalPath();
                    System.out.println("\n\n\n\n\n==========Current dir:" + current + "\\VacPac\\pdf\\EmailAttachment\\CombinedPDFFiles.txt\n\n\n\n\n");
                
                    //Variables
                    String attachment = current + "\\VacPac\\pdf\\EmailAttachment\\CombinedPDFFiles.pdf";

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
                        sendEmail.EmailSender(email, password, toEmail, subject, message, attachment, emailView.getEmailStatus());                    
                    }
                } catch (Exception e) {            
                    /*Stuff*/
                }
            }
        });
    }
    
    /**
     * 
     * @return email
     */
    public String getEmail() {
        String email = emailView.getEmailText().getText();
        return email;
    }
    
    /**
     * 
     * @return password
     */
    public String getPassword() {
        String password = emailView.getPassText().getText();
        return password;
    }
    
    /**
     * 
     * @return sendTo
     */
    public String getSendTo() {
        String sendTo = emailView.getToText().getText();
        return sendTo;
    }
    
    /**
     * 
     * @return subject
     */
    public String getEmailSubject() {
        String subject = emailView.getSubjectText().getText();
        return subject;
    }
    
    /**
     * 
     * @return message
     */
    public String getEmailMessage() {
        String message = emailView.getMessageText().getText();
        return message;
    }
}
