
package database;
/**
 *
 * @author juand This class will hold all the course information needed by the user. 
 */
public class Course {
    // Course fields
    private String coursePrefix;
    private String courseNumber;
    private String courseName;
    private int active;
    private char grade;
    private double hours;
    
    /**
     * Course Constructor
     */
    public Course(){
        coursePrefix = " ";
        courseNumber = " ";
        courseName = " ";
        active = 0;
        grade = ' ';
        hours = 0.0;
    }
    
    /**
     * 
     * @param coursePrefix
     * @param courseNumber
     * @param courseName
     * @param active
     * @param grade
     * @param hours 
     */
    public Course(String coursePrefix, String courseNumber, String courseName, int active, char grade, double hours){
        this.coursePrefix = coursePrefix;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.active = active;
        this.grade = grade;
        this.hours = hours;
    }
    
    /**
     * 
     * @param copyCourse 
     */
    public Course(Course copyCourse){
        coursePrefix = copyCourse.coursePrefix;
        courseNumber = copyCourse.courseNumber;
        courseName = copyCourse.courseName;
        active = copyCourse.active;
        grade = copyCourse.grade;
        hours = copyCourse.hours;
    }
    
    /**
     * 
     * @param coursePrefix set 
     */
    public void setCoursePrefix(String coursePrefix) {
        this.coursePrefix = coursePrefix;
    }
    
    /**
     * 
     * @param courseNumber set 
     */
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
    
    /**
     * 
     * @param courseName set 
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    /**
     * 
     * @param active set 
     */
    public void setActive(int active) {
        this.active = active;
    }
    
    /**
     * 
     * @param grade set 
     */
    public void setGrade(char grade) {
        this.grade = grade;
    }
    
    /**
     * 
     * @param hours set
     */
    public void setHours(double hours) {
        this.hours = hours;
    }
    
    /**
     * 
     * @return coursePrefix
     */
    public String getCoursePrefix() {
        return coursePrefix;
    }
    
    /**
     * 
     * @return courseNumber
     */
    public String getCourseNumber() {
        return courseNumber;
    }
    
    /**
     * 
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }
    
    /**
     * 
     * @return active
     */
    public int getActive() {
        return active;
    }
    
    /**
     * 
     * @return grade
     */
    public char getGrade() {
        return grade;
    }
    
    /**
     * 
     * @return hours
     */
    public double getHours() {
        return hours;
    }
}