/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

/**
 *
 * @author Jose_Balle
 */
public class EmailModel {
    private String email;
    private String password;
    private String mailTo;
    private String subject;
    private String message;

    public EmailModel(String email, String password, String mailTo, String subject, String message) {
        this.email = email;
        this.password = password;
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }       

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
        
    
    
}
