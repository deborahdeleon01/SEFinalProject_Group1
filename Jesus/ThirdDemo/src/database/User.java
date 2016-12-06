/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
/**
 *
 * @author E
 */
public class User 
{

    

   
    String email;
    String first;
    String last;
    String pass;
    String salt;
    String pos;
    int permission;
     Image pic;
    List courses;
    List reminders;
   
   public User(String email, String first, String last, String pass, String salt, String pos) 
   {
        this.email = email;
        this.first = first;
        this.last = last;
        this.pass = pass;
        this.pos = pos;
        this.salt=salt;
    }
    
 
    
    public User()
    {
        
    }
     
    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getFirst() {
        return first;
    }


    public String getSalt() {
        return salt;
    }

    public String getPos() {
        return pos;
    }

    public List getCourses() {
        return courses;
    }

    public List getReminders() {
        return reminders;
    }

    public Image getPic() {
        return pic;
    }


    

    public void setLast(String last) {
        this.last = last;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setFirst(String first) {
        this.first = first;
    }

  

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setCourses(List courses) {
        this.courses = courses;
    }

    public void setReminders(List reminders) {
        this.reminders = reminders;
    }

    public void setPic(Image pic) {
        this.pic = pic;
    }
 
}
