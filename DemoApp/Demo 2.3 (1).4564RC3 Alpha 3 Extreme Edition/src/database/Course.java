
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
    
    public Course(){
        coursePrefix = " ";
        courseNumber = " ";
        courseName = " ";
        active = 0;
        grade = ' ';
        hours = 0.0;
    }
    public Course(String coursePrefix, String courseNumber, String courseName, int active, char grade, double hours){
        this.coursePrefix = coursePrefix;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.active = active;
        this.grade = grade;
        this.hours = hours;
    }
    public Course(Course copyCourse){
        coursePrefix = copyCourse.coursePrefix;
        courseNumber = copyCourse.courseNumber;
        courseName = copyCourse.courseName;
        active = copyCourse.active;
        grade = copyCourse.grade;
        hours = copyCourse.hours;
    }
    public void setCoursePrefix(String coursePrefix) {
        this.coursePrefix = coursePrefix;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setActive(int active) {
        this.active = active;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public String getCoursePrefix() {
        return coursePrefix;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getActive() {
        return active;
    }
    public char getGrade() {
        return grade;
    }

    public double getHours() {
        return hours;
    }
}