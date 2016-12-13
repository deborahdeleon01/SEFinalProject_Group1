/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

import database.Course;
import database.User;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;

/**
 *
 * @author MQ0162246
 */
public class GPAWidget {

    GPAMeter meter;
    
    Course course = new Course();
    User user = new User();
    TextField[] gradeFields = new TextField[4];
    TextField[] hourFields = new TextField[4];
    BorderPane pane = new BorderPane();

    public GPAWidget(double width, double height, double v1, double v2, double v3, double delta) 
    {
        meter = new GPAMeter(width, height, v1, v2, v3, delta);

        // Create the Border pane
        Text topText = new Text();
        topText.setWrappingWidth(800);
        topText.setFont(Font.font("Arial", 40));
        topText.setFill(Color.RED);

        topText.setText("GPA Widget");
        topText.setTextAlignment(TextAlignment.CENTER);
        pane.setTop(topText);

        //
        meter.setMeterRotationAngleinDegrees(0);
        Rotate r = new Rotate(meter.getMeterRotationAngleinDegrees(), 300, 300);
        meter.getTransforms().addAll(r);
        
        VBox stack = new VBox();
        stack.setAlignment(Pos.CENTER);
        stack.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        stack.setSpacing(10);
        
        stack.getChildren().addAll(meter, getSemesterPane());
        
        pane.setCenter(stack);


        BorderPane.setAlignment(topText, Pos.CENTER);
        BorderPane.setAlignment(meter, Pos.CENTER);
    }

    private VBox getSemesterPane() {
        VBox vpane = new VBox();
        vpane.setAlignment(Pos.CENTER);
        vpane.setAlignment(Pos.TOP_CENTER);
        vpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        vpane.setSpacing(10);
        
//                  testing courses
//        user.addPastCourse(new Course("csci","2501","class5",1,'c',3));
//        user.addPastCourse(new Course("csci","2601","class6",1,'c',4));
//        user.addPastCourse(new Course("csci","2701","class7",1,'f',3));
//        user.addPastCourse(new Course("csci","2801","class8",1,'d',4));

        // Place nodes in the pane
//        Button btAdd1  = new Button("Calculate Old GPA");
        

//        
//        btAdd1.setOnAction((ActionEvent event) -> {
//            try {
//                
//                user.getPastCourses();
//
//            } catch (Exception e) {
//               String s = e.getMessage();
//               System.out.println(s);
//            }
//            
//            meter.paintMeter(GPAUtility.calcGPA(user.getPastCourses()));
//        });

//         Place nodes in the pane
        Label currentSemesterLabel = new Label("Current Semester Courses");
        currentSemesterLabel.setStyle("-fx-text-fill:black;-fx-font-size: 20px;-fx-font-weight: bold;");
        vpane.getChildren().add(currentSemesterLabel);
        
        //testing courses
//        user.addCurrentCourse(new Course("csci","1101","class1",1,'a',3));
//        user.addCurrentCourse(new Course("csci","1301","class2",1,'c',4));
//        user.addCurrentCourse(new Course("csci","1401","class3",1,'a',3));
//        user.addCurrentCourse(new Course("csci","1501","class4",1,'c',4));


        for (int i = 0; i < gradeFields.length; i++) {
            
             HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER);
            hbox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            hbox.setSpacing(10);
            
            TextField currentCourse = new TextField();
            currentCourse.setPromptText("Enter COURSE NAME");
            
            Separator separator1 = new Separator();
            separator1.setOrientation(Orientation.HORIZONTAL);
            separator1.setMaxWidth(200);

            
            gradeFields[i] = new TextField();
            gradeFields[i].setPromptText("ENTER GRADE");
            gradeFields[i].setPrefWidth(150);
            
            hourFields[i] = new TextField();
            hourFields[i].setPromptText("ENTER HOURS");
            hourFields[i].setPrefWidth(150);
            
            hbox.getChildren().addAll(currentCourse,gradeFields[i],hourFields[i]);
            
            vpane.getChildren().addAll(hbox,separator1);
        }

        Button btAdd2 = new Button("Calculate New GPA");

        btAdd2.setOnAction((ActionEvent event) -> {
            
         int hours;
        int totalHours = 0;
        double gpa = 0.0;
            
         for (int i = 0; i < gradeFields.length; i++) {
            
             if (isValidGrade(gradeFields[i].getText()))
             {
                 
             
             
            if (gradeFields[i].getText().toUpperCase().equals("A")) {
                hours = Integer.parseInt(hourFields[i].getText());
                totalHours += hours;
                gpa += 4.00 * hours;
            } else if (gradeFields[i].getText().toUpperCase().equals("B")) {
                hours = Integer.parseInt(hourFields[i].getText());
                totalHours += hours;
                gpa += 3.00 * hours;
            } else if (gradeFields[i].getText().toUpperCase().equals("C")) {
                hours = Integer.parseInt(hourFields[i].getText());
                totalHours += hours;
                gpa += 2.00 * hours;
            } else if (gradeFields[i].getText().toUpperCase().equals("D")) {
                hours = Integer.parseInt(hourFields[i].getText());
                totalHours += hours;
                gpa += 1.00 * hours;
            }
           else if (gradeFields[i].getText().toUpperCase().equals("F")) {
                hours = Integer.parseInt(hourFields[i].getText());
                totalHours += hours;
            }            
        }
         }

        gpa = gpa/totalHours;
        System.out.println("Your GPA from the Transcript/Semester  is: " + gpa);
            
//            double transcript_gpa = GPAUtility.calcGPA(user.getPastCourses());
            // update the meter!
           
            meter.paintMeter(gpa);
            
            
        });
        
        
        
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        buttons.getChildren().addAll(btAdd2);

        vpane.getChildren().addAll(buttons);
        return vpane;
    }
    
    private boolean isValidGrade(String grade)
    {
        if (grade==null)
                return false;
        if(
                grade.toUpperCase().equals("A") ||
                grade.toUpperCase().equals("B") ||
                grade.toUpperCase().equals("C") ||
                grade.toUpperCase().equals("D") ||
                grade.toUpperCase().equals("F")
          )
            return true;
        else
            return false;

    }

    private HBox getHBox(String cc) {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color:" + cc);
        hBox.getChildren().add(new Text("Pane is empty .."));
        return hBox;
    }

    /**
     * @return the pane
     */
    public BorderPane getPane() {
        return pane;
    }

    /**
     * @param pane the pane to set
     */
    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

}
