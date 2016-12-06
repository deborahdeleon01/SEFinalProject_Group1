package gpawidget;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package javafxapplication21;
////import database.Course;
//
//import javafx.collections.ObservableList;
//import javafx.scene.control.TextField;
//
///**
// *
// * @author MQ0162246
// */
//public class GPAUtility {
////
////    public static double calcGPA(ObservableList<Course> myCourses) {
////        int hours;
////        int totalHours = 0;
////        double gpa = 0.0;
////        for (int i = 0; i < myCourses.size(); i++) {
////            String grade = myCourses.get(i).getGrade().toUpperCase();
////            if (grade.equals("A")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////                gpa += 4.00 * hours;
////            } else if (grade.equals("B")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////                gpa += 3.00 * hours;
////            } else if (grade.equals("C")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////                gpa += 2.00 * hours;
////            } else if (grade.equals("D")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////                gpa += 1.00 * hours;
////            } 
////            else if (grade.equals("F")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////            }
////            
////        }
////        gpa /= totalHours;
////        System.out.println("Your GPA from the Transcript text file is: " + gpa);
////
////        // hard coded!
////        return gpa;
////    }
//
////        public static double calcGPA(ObservableList<Course> myCourses, ObservableList<Course> mySemester) {
//    public static double calcGPA() {
//        int hours;
//        int totalHours = 0;
//        double gpa = 0.0;
//        TextField[] gradeFields = null;
//        TextField[] hourFields = null;
////        for (int i = 0; i < myCourses.size(); i++) {
////            String grade = myCourses.get(i).getGrade().toUpperCase();
////            if (grade.equals("A")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////                gpa += 4.00 * hours;
////            } else if (grade.equals("B")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////                gpa += 3.00 * hours;
////            } else if (grade.equals("C")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////                gpa += 2.00 * hours;
////            } else if (grade.equals("D")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////                gpa += 1.00 * hours;
////            }
////           else if (grade.equals("F")) {
////                hours = Integer.parseInt(myCourses.get(i).getHours());
////                totalHours += hours;
////            }
////
////        }
//
//for (int i = 0; i < gradeFields.length; i++) {
//            String grade = gradeFields[i].getText();
//            if (grade.equals("A")) {
//                hours = Integer.parseInt(hourFields[i].getText());
//                totalHours += hours;
//                gpa += 4.00 * hours;
//            } else if (grade.equals("B")) {
//                hours = Integer.parseInt(hourFields[i].getText());
//                totalHours += hours;
//                gpa += 3.00 * hours;
//            } else if (grade.equals("C")) {
//                hours = Integer.parseInt(hourFields[i].getText());
//                totalHours += hours;
//                gpa += 2.00 * hours;
//            } else if (grade.equals("D")) {
//                hours = Integer.parseInt(hourFields[i].getText());
//                totalHours += hours;
//                gpa += 1.00 * hours;
//            }
//           else if (grade.equals("F")) {
//                hours = Integer.parseInt(hourFields[i].getText());
//                totalHours += hours;
//            }
//            
//        }
//        gpa /= totalHours;
////        System.out.println("Your GPA from the Transcript text file is: " + gpa);
//
//        // hard coded!
//        return gpa;
//    }
////
//}
