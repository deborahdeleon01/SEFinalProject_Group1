/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

/**
 *
 * @author MQ0162246
 */
public class Transcript {

    private ObservableList<Course> myCourses = FXCollections.observableArrayList();
    private Person person = new Person();

    public Transcript() {
        myCourses.addListener(new ListChangeListener<Course>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Course> c) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setContentText("Course List now has: " + getMyCourses().size()+" Course...\n");
//                alert.setContentText("Course added is: " + getMyCourses().get(getMyCourses().size()-1).toString()+ "\n");
//                alert.showAndWait();
            }
        });

    }

    
    public void readCourses() throws IOException {

        // Reset ArrayList
        myCourses.clear();

        //Open file
        String fname = null;
        Scanner s = null;
        final FileChooser fileChooser = new FileChooser();
        //
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home")));

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Text", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.txt"));

        //Handle the file
        File file = fileChooser.showOpenDialog(null);

        if (file != null && file.isFile()) {
            try {
                fname = file.getPath();
                System.out.println("Filename to open is: " + fname);
            } catch (Exception e) {
            }

            try {
                s = new Scanner(new BufferedReader(new FileReader(fname)));
                String currentCourse;
                while (s.hasNext()) {
                    currentCourse = s.nextLine();
                    System.out.println(currentCourse);
                    String[] fields = currentCourse.split(",");
                    for (int i = 0; i < fields.length; i++) {
                        String field = fields[i];
                        System.out.println("field is: " + field);
                    }
                    //coursePrefix,  courseNumber,  courseName,  description,  hours,  grade)
                    Course cCourse = new Course(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
                    myCourses.add(cCourse);
                }
            } finally {
                if (s != null) {
                    s.close();
                }
            }
        }

        //add to the mycourses list
    }    
    public void readCourses(String fname) throws IOException {

        // Reset ArrayList
        myCourses.clear();

        //Open file
        Scanner s = null;
      
            try {
                s = new Scanner(new BufferedReader(new FileReader(fname)));
                String currentCourse;
                while (s.hasNext()) {
                    currentCourse = s.nextLine();
                    System.out.println(currentCourse);
                    String[] fields = currentCourse.split(",");
                    for (int i = 0; i < fields.length; i++) {
                        String field = fields[i];
                        System.out.println("field is: " + field);
                    }
                    //coursePrefix,  courseNumber,  courseName,  description,  hours,  grade)
                    Course cCourse = new Course(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
                    myCourses.add(cCourse);
                }
            } finally {
                if (s != null) {
                    s.close();
                }
            }
        }

    /**
     * @return the myCourses
     */
    public ObservableList<Course> getMyCourses() {
        return myCourses;
    }

    /**
     * @param myCourses the myCourses to set
     */
    public void setMyCourses(ObservableList<Course> myCourses) {
        this.myCourses = myCourses;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

}
