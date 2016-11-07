/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

import java.util.Arrays;

/**
 *
 * @author MQ0162246
 */
public class Course {
  private String coursePrefix;
  private String courseNumber;
  private String courseName;
  private String description;
  private String hours;
  private String grade;

    public Course(String coursePrefix, String courseNumber, String courseName, String description, String hours, String grade) {
        this.coursePrefix = coursePrefix;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.description = description;
        this.hours = hours;
        this.grade = grade;
    }
    
    public Course(String coursePrefix, String courseNumber, String courseName, String description, String hours) {
        this.coursePrefix = coursePrefix;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.description = description;
        this.hours = hours;
        this.grade = grade;
    }    

    @Override
    public String toString() 
    {
        String s = "";
        s += coursePrefix + " "+
             courseNumber + " "+
             courseName   + " "+
             description  + " "+
             hours        + " "+
             grade;

        return s;
    } 

    /**
     * @return the coursePrefix
     */
    public String getCoursePrefix() {
        return coursePrefix;
    }

    /**
     * @param coursePrefix the coursePrefix to set
     */
    public void setCoursePrefix(String coursePrefix) {
        this.coursePrefix = coursePrefix;
    }

    /**
     * @return the courseNumber
     */
    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * @param courseNumber the courseNumber to set
     */
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the hours
     */
    public String getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
  
    
}
