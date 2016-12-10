/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.List;

import database.Course;
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
    ArrayList<Course> reminders;

    public User(String email, String first, String last, String pos, int permission) {
        this.email = email;
        this.first = first;
        this.last = last;
        this.pass = pass;
        this.pos = pos;
        this.permission = permission;
    }
    public User(String email, String first, String last, String pass, String pos, int permission) {
        this.email = email;
        this.first = first;
        this.last = last;
        this.pass = pass;
        this.pos = pos;
        this.permission = permission;
    }

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

    public User() {

    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrentCourses(ArrayList<Course> currentCourses) {
        this.currentCourses = currentCourses;
    }

    public void setPastCourses(ArrayList<Course> pastCourses) {
        this.pastCourses = pastCourses;
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

    public int getPermission() {
        return permission;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Course> getCurrentCourses() {
        return currentCourses;
    }

    public ArrayList<Course> getPastCourses() {
        return pastCourses;
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

    public void setReminders(ArrayList<Course> reminders) {
        this.reminders = reminders;
    }

    public void setPic(Image pic) {
        this.pic = pic;
    }

    public void addCurrentCourse(Course courseToAdd) {
        if (currentCourses != null) {
            currentCourses.add(new Course(courseToAdd));
        }
        else {
            currentCourses = new ArrayList<>();
            currentCourses.add(new Course(courseToAdd));
        }
    }
    public void addPastCourse(Course courseToAdd) {
        if (pastCourses != null) {
            pastCourses.add(new Course(courseToAdd));
        }
        else {
            pastCourses = new ArrayList<>();
            pastCourses.add(new Course(courseToAdd));
        }
    }
    protected void addPastCourses(ArrayList<Course> pastCourses){
        this.pastCourses = new ArrayList<>(pastCourses.size());
        for (int i = 0; i < currentCourses.size(); i++) {
            this.pastCourses.add(new Course(pastCourses.get(i)));
        }
    }
    protected void addCurrentCourses(ArrayList<Course> currentCourses){
        this.currentCourses = new ArrayList<>(currentCourses.size());
        for (int i = 0; i < currentCourses.size(); i++) {
            this.currentCourses.add(new Course(currentCourses.get(i)));
        }
    }
}