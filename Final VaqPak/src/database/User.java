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
public class User {

    String email;
    String first;
    String last;
    String pass;
    String salt;
    String pos;
    int permission;
    int id;
    Image pic;
    ArrayList<Course> currentCourses;
    ArrayList<Course> pastCourses;
    ArrayList<Reminder> reminders;
    
    /**
     * 
     * @param email
     * @param first
     * @param last
     * @param pos
     * @param permission 
     */
    public User(String email, String first, String last, String pos, int permission) {
        this.email = email;
        this.first = first;
        this.last = last;
        this.pass = pass;
        this.pos = pos;
        this.permission = permission;
    }
    
    /**
     * 
     * @param email
     * @param first
     * @param last
     * @param pass
     * @param pos
     * @param permission 
     */
    public User(String email, String first, String last, String pass, String pos, int permission) {
        this.email = email;
        this.first = first;
        this.last = last;
        this.pass = pass;
        this.pos = pos;
        this.permission = permission;
    }
    
    /**
     * 
     * @param email
     * @param first
     * @param last
     * @param pass
     * @param salt
     * @param pos
     * @param permission
     * @param id 
     */
    public User(String email, String first, String last, String pass, String salt, String pos, int permission, int id) {
        this.email = email;
        this.first = first;
        this.last = last;
        this.pass = pass;
        this.pos = pos;
        this.salt = salt;
        this.permission = permission;
        this.id = id;
    }
    
    /**
     * 
     * @param email
     * @param first
     * @param last
     * @param pass
     * @param salt
     * @param pos
     * @param permission
     * @param id
     * @param currentCourses
     * @param pastCourses 
     */
    public User(String email, String first, String last, String pass, String salt, String pos, int permission, int id, ArrayList<Course> currentCourses, ArrayList<Course> pastCourses) {
        this.email = email;
        this.first = first;
        this.last = last;
        this.pass = pass;
        this.pos = pos;
        this.salt = salt;
        this.permission = permission;
        this.id = id;
        this.currentCourses = new ArrayList<>(currentCourses.size());
        this.pastCourses = new ArrayList<>(pastCourses.size());
        for (int i = 0; i < currentCourses.size(); i++) {
            this.currentCourses.set(i, new Course(currentCourses.get(i)));
        }
        for (int i = 0; i < currentCourses.size(); i++) {
            this.pastCourses.set(i, new Course(pastCourses.get(i)));
        }
    }
    
    /**
     * 
     */
    public User() {

    }
    
    /**
     * 
     * @param permission set
     */
    public void setPermission(int permission) {
        this.permission = permission;
    }
    
    /**
     * 
     * @param id set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @param currentCourses set
     */
    public void setCurrentCourses(ArrayList<Course> currentCourses) {
        this.currentCourses = currentCourses;
    }
    
    /**
     * 
     * @param pastCourses set
     */
    public void setPastCourses(ArrayList<Course> pastCourses) {
        this.pastCourses = pastCourses;
    }
    
    /**
     * 
     * @return last
     */
    public String getLast() {
        return last;
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
     * @return pass
     */
    public String getPass() {
        return pass;
    }
    
    /**
     * 
     * @return first
     */
    public String getFirst() {
        return first;
    }
    
    /**
     * 
     * @return salt
     */
    public String getSalt() {
        return salt;
    }
    
    /**
     * 
     * @return pos
     */
    public String getPos() {
        return pos;
    }
    
    /**
     * 
     * @return permission
     */
    public int getPermission() {
        return permission;
    }
    
    /**
     * 
     * @return id
     */
    public int getId() {
        return id;
    }
    
    /**
     * 
     * @return currentCourses ArrayList
     */
    public ArrayList<Course> getCurrentCourses() {
        return currentCourses;
    }
    
    /**
     * 
     * @return pastCourses ArrayList 
     */
    public ArrayList<Course> getPastCourses() {
        return pastCourses;
    }
    
    /**
     * 
     * @return reminders
     */
    public List getReminders() {
        return reminders;
    }

    /**
     * 
     * @return pic
     */
    public Image getPic() {
        return pic;
    }
    
    /**
     * 
     * @param last set
     */
    public void setLast(String last) {
        this.last = last;
    }
    
    /**
     * 
     * @param email set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 
     * @param pass set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    /**
     * 
     * @param first set
     */
    public void setFirst(String first) {
        this.first = first;
    }
    
    /**
     * 
     * @param salt set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    /**
     * 
     * @param pos set
     */
    public void setPos(String pos) {
        this.pos = pos;
    }
    
    /**
     * 
     * @param pic set
     */
    public void setPic(Image pic) {
        this.pic = pic;
    }
    
    /**
     * 
     * @param courseToAdd add currentCourses
     */
    public void addCurrentCourse(Course courseToAdd) {
        if (currentCourses != null) {
            currentCourses.add(new Course(courseToAdd));
        } 
        else {
            currentCourses = new ArrayList<>();
            currentCourses.add(new Course(courseToAdd));
        }
    }
    
    /**
     * 
     * @param courseToAdd add pastCourses
     */
    public void addPastCourse(Course courseToAdd) {
        if (pastCourses != null) {
            pastCourses.add(new Course(courseToAdd));
        } 
        else {
            pastCourses = new ArrayList<>();
            pastCourses.add(new Course(courseToAdd));
        }
    }
    
    /**
     * 
     * @param pastCourses 
     */
    public void addPastCourses(ArrayList<Course> pastCourses){
        this.pastCourses = new ArrayList<>(pastCourses.size());
        for (int i = 0; i < currentCourses.size(); i++) {
            this.pastCourses.add(new Course(pastCourses.get(i)));
        }
    }
    
    /**
     * 
     * @param currentCourses 
     */
    public void addCurrentCourses(ArrayList<Course> currentCourses){
        this.currentCourses = new ArrayList<>(currentCourses.size());
        for (int i = 0; i < currentCourses.size(); i++) {
            this.currentCourses.add(new Course(currentCourses.get(i)));
        }
    }
    
    /**
     * 
     * @param prefix 
     */
    public void removeCourse(String prefix){
        if(currentCourses.size() > 0 && currentCourses != null){
            for(int i = 0; i < currentCourses.size(); i++) {
                if(currentCourses.get(i).getCoursePrefix().equalsIgnoreCase(prefix)){
                    currentCourses.remove(i);
                    break;
                }
            }
        }
    }
    
    /**
     * 
     * @param prefix
     * @param grade 
     */
    public void editCourse(String prefix, char grade){
        if(currentCourses.size() > 0 && currentCourses != null){
            for(int i = 0; i < currentCourses.size(); i++) {
                if(currentCourses.get(i).getCoursePrefix().equalsIgnoreCase(prefix)){
                    currentCourses.get(i).setGrade(grade);
                    break;
                }
            }
        }
    }
    
    /**
     * 
     * @param r 
     */
    public void addReminder(Reminder r){
        if(reminders == null)
            reminders = new ArrayList<>();
        reminders.add(new Reminder(r));
    }
   
}
