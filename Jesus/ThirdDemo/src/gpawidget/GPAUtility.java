/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

import javafx.collections.ObservableList;

/**
 *
 * @author MQ0162246
 */
public class GPAUtility {

    public static double calcGPA(ObservableList<Course> myCourses) {
        int hours;
        int totalHours = 0;
        double gpa = 0.0;
        for (int i = 0; i < myCourses.size(); i++) {
            String grade = myCourses.get(i).getGrade().toUpperCase();
            if (grade.equals("A")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
                gpa += 4.00 * hours;
            } else if (grade.equals("B")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
                gpa += 3.00 * hours;
            } else if (grade.equals("C")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
                gpa += 2.00 * hours;
            } else if (grade.equals("D")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
                gpa += 1.00 * hours;
            } 
            else if (grade.equals("F")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
            }
            
        }
        gpa /= totalHours;
        System.out.println("Your GPA from the Transcript text file is: " + gpa);

        // hard coded!
        return gpa;
    }

    public static double calcGPA(ObservableList<Course> myCourses, ObservableList<Course> mySemester) {
        int hours;
        int totalHours = 0;
        double gpa = 0.0;

        for (int i = 0; i < myCourses.size(); i++) {
            String grade = myCourses.get(i).getGrade().toUpperCase();
            if (grade.equals("A")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
                gpa += 4.00 * hours;
            } else if (grade.equals("B")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
                gpa += 3.00 * hours;
            } else if (grade.equals("C")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
                gpa += 2.00 * hours;
            } else if (grade.equals("D")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
                gpa += 1.00 * hours;
            }
           else if (grade.equals("F")) {
                hours = Integer.parseInt(myCourses.get(i).getHours());
                totalHours += hours;
            }

        }

        for (int i = 0; i < mySemester.size(); i++) {
            String grade = mySemester.get(i).getGrade().toUpperCase();
            if (grade.equals("A")) {
                hours = Integer.parseInt(mySemester.get(i).getHours());
                totalHours += hours;
                gpa += 4.00 * hours;
            } else if (grade.equals("B")) {
                hours = Integer.parseInt(mySemester.get(i).getHours());
                totalHours += hours;
                gpa += 3.00 * hours;
            } else if (grade.equals("C")) {
                hours = Integer.parseInt(mySemester.get(i).getHours());
                totalHours += hours;
                gpa += 2.00 * hours;
            } else if (grade.equals("D")) {
                hours = Integer.parseInt(mySemester.get(i).getHours());
                totalHours += hours;
                gpa += 1.00 * hours;
            }
           else if (grade.equals("F")) {
                hours = Integer.parseInt(mySemester.get(i).getHours());
                totalHours += hours;
            }            
        }

        gpa /= totalHours;
        System.out.println("Your GPA from the Transcript/Semester  is: " + gpa);

        return gpa;
    }

}
