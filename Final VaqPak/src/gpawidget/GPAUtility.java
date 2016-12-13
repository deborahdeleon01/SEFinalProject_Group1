/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

import database.Course;
import java.util.ArrayList;

/**
 *
 * @author MQ0162246
 */
public class GPAUtility {
    
    /**
     * 
     * @param myCourses
     * @return calcGPA
     */
    public static double calcGPA(ArrayList<Course> myCourses) {
        int hours;
        int totalHours = 0;
        double gpa = 0.0;
        
        for (int i = 0; i < myCourses.size(); i++) {
            String grade = Character.toString(myCourses.get(i).getGrade()).toUpperCase();
            if (grade.equals("A")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 4.00 * hours;
            } else if (grade.equals("B")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 3.00 * hours;
            } else if (grade.equals("C")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 1.00 * hours;
            }
            else if (grade.equals("D")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 1.00 * hours;
            }
            
            else if (grade.equals("")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                
            } else {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 4.00 * hours;
            }   
        }
        
        gpa /= totalHours;
        System.out.println("Your GPA is: " + gpa);

        // hard coded!
        return gpa;
    }
    
    /**
     * 
     * @param myCourses
     * @param mySemester
     * @return 
     */
    public static double calcGPA(ArrayList<Course> myCourses, ArrayList<Course> mySemester) {
        int hours;
        int totalHours = 0;
        double gpa = 0.0;

        for (int i = 0; i < myCourses.size(); i++) {
            String grade = Character.toString(myCourses.get(i).getGrade()).toUpperCase();
            if (grade.equals("A")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 4.00 * hours;
            } else if (grade.equals("B")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 3.00 * hours;
            } else if (grade.equals("C")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 2.00 * hours;
            } else if (grade.equals("D")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 1.00 * hours;
            }
           else if (grade.equals("F")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
            }

        }

        for (int i = 0; i < mySemester.size(); i++) {
            String grade = Character.toString(myCourses.get(i).getGrade()).toUpperCase();
            if (grade.equals("A")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 4.00 * hours;
            } else if (grade.equals("B")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 3.00 * hours;
            } else if (grade.equals("C")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 2.00 * hours;
            } else if (grade.equals("D")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
                gpa += 1.00 * hours;
            }
           else if (grade.equals("F")) {
                hours = (int) myCourses.get(i).getHours();
                totalHours += hours;
            }            
        }

        gpa /= totalHours;
        System.out.println("Your GPA for the Semester  is: " + gpa);

        return gpa;
    }

}
