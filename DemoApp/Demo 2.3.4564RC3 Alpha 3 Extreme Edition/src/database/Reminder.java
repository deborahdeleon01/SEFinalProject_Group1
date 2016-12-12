/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author josue
 */
public class Reminder{

    public Reminder(String StartTIME, String message, String reminderName, String ReminderID) {
        this.StartTIME = StartTIME;
//        this.EndTIME = EndTIME;
        this.message = message;
        this.reminderName = reminderName;
        this.ReminderID = ReminderID;
    }
    
    private String StartTIME;
    private String EndTIME;
    private String message;
    private String reminderName;
    private String ReminderID;

    Reminder() {
    }
    public Reminder(Reminder r) {
        this.StartTIME = r.StartTIME;
//        this.EndTIME = r.EndTIME;
        this.message = r.message;
        this.reminderName = r.reminderName;
        this.ReminderID = r.ReminderID;
    }

    public String getStartTIME() {
        return StartTIME;
    }

    public void setStartTIME(String StartTIME) {
        this.StartTIME = StartTIME;
    }

    public String getEndTIME() {
        return EndTIME;
    }

    public void setEndTIME(String EndTIME) {
        this.EndTIME = EndTIME;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReminderName() {
        return reminderName;
    }

    public void setReminderName(String reminderName) {
        this.reminderName = reminderName;
    }

    public String getReminderID() {
        return ReminderID;
    }

    public void setReminderID(String ReminderID) {
        this.ReminderID = ReminderID;
    }


}
