package database;

import java.sql.Timestamp;

/**
 *
 * @author josue
 */
public class Reminder{
    
    /**
     * 
     * @param StartTIME
     * @param EndTIME
     * @param message
     * @param reminderName
     * @param ReminderID 
     */
    public Reminder(Timestamp StartTIME, Timestamp EndTIME, String message, String reminderName, String ReminderID) {
        this.StartTIME = StartTIME;
        this.EndTIME = EndTIME;
        this.message = message;
        this.reminderName = reminderName;
        this.ReminderID = ReminderID;
    }
    
    private Timestamp StartTIME;
    private Timestamp EndTIME;
    private String message;
    private String reminderName;
    private String ReminderID;
    
    /**
     * 
     */
    Reminder() {
    }
    
    /**
     * 
     * @param r 
     */
    public Reminder(Reminder r) {
        this.StartTIME = r.StartTIME;
        this.EndTIME = r.EndTIME;
        this.message = r.message;
        this.reminderName = r.reminderName;
        this.ReminderID = r.ReminderID;
    }
    
    /**
     * 
     * @return StartTIME
     */
    public Timestamp getStartTIME() {
        return StartTIME;
    }
    
    /**
     * 
     * @param StartTIME set
     */
    public void setStartTIME(Timestamp StartTIME) {
        this.StartTIME = StartTIME;
    }
    
    /**
     * 
     * @return EndTIME
     */
    public Timestamp getEndTIME() {
        return EndTIME;
    }
    
    /**
     * 
     * @param EndTIME set
     */
    public void setEndTIME(Timestamp EndTIME) {
        this.EndTIME = EndTIME;
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
    
    /**
     * 
     * @return reminderName
     */
    public String getReminderName() {
        return reminderName;
    }
    
    /**
     * 
     * @param reminderName set
     */
    public void setReminderName(String reminderName) {
        this.reminderName = reminderName;
    }
    
    /**
     * 
     * @return ReminderID
     */
    public String getReminderID() {
        return ReminderID;
    }
    
    /**
     * 
     * @param ReminderID set
     */
    public void setReminderID(String ReminderID) {
        this.ReminderID = ReminderID;
    }


}


