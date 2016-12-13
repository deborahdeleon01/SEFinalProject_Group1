/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

/**
 * @author Jose_Balle
 */
public class EmailModel {
    private String email;
    private String password;
    private String mailTo;
    private String subject;
    private String message;
    
    /**
     * 
     * @param email
     * @param password
     * @param mailTo
     * @param subject
     * @param message 
     */
    public EmailModel(String email, String password, String mailTo, String subject, String message) {
        this.email = email;
        this.password = password;
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }
    
    /**
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * 
     * @return mailTo
     */
    public String getMailTo() {
        return mailTo;
    }
    
    /**
     * 
     * @param mailTo 
     */
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }
    
    /**
     * 
     * @return subject
     */
    public String getSubject() {
        return subject;
    }
    
    /**
     * 
     * @param subject 
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    /**
     * 
     * @return message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * 
     * @param message 
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
