/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

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
    Transcript transcript = new Transcript();
    Semester semester = new Semester();
    TextField[] gradeFields = null;
    BorderPane pane = new BorderPane();

    public GPAWidget(double width, double height, double v1, double v2, double v3, double delta) 
    {
        meter = new GPAMeter(width, height, v1, v2, v3, delta);

        // Create the Border pane
        Text topText = new Text();
        topText.setWrappingWidth(800);
        topText.setFont(Font.font("Verdana", FontPosture.ITALIC, 40));
        topText.setFill(Color.BLUEVIOLET);

        topText.setText("GPA Widget");
        topText.setTextAlignment(TextAlignment.CENTER);
        pane.setTop(topText);

        //
        meter.setMeterRotationAngleinDegrees(0);
        Rotate r = new Rotate(meter.getMeterRotationAngleinDegrees(), 300, 300);
        meter.getTransforms().addAll(r);

        pane.setCenter(meter);
        // pane.setBottom(new Text("Empty Pane for now..."));
        pane.setLeft(getReadTranscript());
        pane.setRight(getSemesterPane());

        BorderPane.setAlignment(topText, Pos.CENTER);
        BorderPane.setAlignment(meter, Pos.CENTER);
    }

    private GridPane getReadTranscript() {
        GridPane transcriptPane = new GridPane();
        transcriptPane.setAlignment(Pos.CENTER);
        transcriptPane.setAlignment(Pos.TOP_CENTER);
        transcriptPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        transcriptPane.setHgap(5.5);
        transcriptPane.setVgap(5.5);

        // Place nodes in the pane
        Button btAdd  = new Button("Read Transcript/Courses File");
        Button btAdd2 = new Button("Read DefaultFile");
        
        // Allows for the buttons to be the same size!
        btAdd.setMaxWidth(Double.MAX_VALUE);
        btAdd2.setMaxWidth(Double.MAX_VALUE);
        
        btAdd.setOnAction((ActionEvent event) -> {
            try {
                transcript.readCourses();
                //should clear current semester fields

            } catch (Exception e) {
            }
            meter.paintMeter(GPAUtility.calcGPA(transcript.getMyCourses()));
        });


        btAdd2.setOnAction((ActionEvent event) -> {
            try {
                transcript.readCourses("transcript.txt");
                //should clear current semester fields

            } catch (Exception e) {
            }
            meter.paintMeter(GPAUtility.calcGPA(transcript.getMyCourses()));
        });
        
        transcriptPane.add(btAdd,  0, 0);
        transcriptPane.add(btAdd2, 0, 1);

        return transcriptPane;
    }

    private VBox getSemesterPane() {
        VBox vpane = new VBox();
        vpane.setAlignment(Pos.CENTER);
        vpane.setAlignment(Pos.TOP_CENTER);
        vpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        vpane.setSpacing(10);

        // Place nodes in the pane
        Label currentSemesterLabel = new Label("Current Semester Courses");
        currentSemesterLabel.setStyle("-fx-text-fill:black;-fx-font-size: 20px;-fx-font-weight: bold;");
        vpane.getChildren().add(currentSemesterLabel);

        //get current semester courses
        try {
            semester.readCourses("fall2016semester.txt");

        } catch (Exception e) {
        }

        gradeFields = null;
        try {
            gradeFields = new TextField[semester.getMyCourses().size()];

        } catch (Exception e) {
        }

        for (int i = 0; i < semester.getMyCourses().size(); i++) {
            Label currentCourseLabel = new Label();
            currentCourseLabel.setText(semester.getMyCourses().get(i).toString());

            Separator separator1 = new Separator();
            separator1.setOrientation(Orientation.HORIZONTAL);

            Label courseGrade = new Label("Enter Grade:");
            courseGrade.setStyle("-fx-text-fill:red;-fx-font-size: 15px;-fx-font-weight: bold;");
            gradeFields[i] = new TextField();
            vpane.getChildren().addAll(currentCourseLabel, separator1, courseGrade, gradeFields[i]);
        }

        Button btAdd = new Button("Update Meter");
        btAdd.setMaxWidth(Double.MAX_VALUE);

        btAdd.setOnAction((ActionEvent event) -> {
            for (int i = 0; i < gradeFields.length; i++) {
                System.out.println("for course: " + semester.getMyCourses().get(i).toString());
                if(isValidGrade(gradeFields[i].getText().trim()))
                {
                  semester.getMyCourses().get(i).setGrade(gradeFields[i].getText().trim());
                }
                else
                {
                    System.out.println("Invalid grade was entered!");
                    semester.getMyCourses().get(i).setGrade("None");
                }
                System.out.println("grade is : " + semester.getMyCourses().get(i).getGrade());
            }
            
            // pass semester with grades & courses to grade calculator!
            double transcript_gpa = GPAUtility.calcGPA(transcript.getMyCourses());
            double total_gpa = GPAUtility.calcGPA(transcript.getMyCourses(), semester.getMyCourses());
            
            //double gpa = GPAUtility.calcGPA(transcript.getMyCourses(), semester.getMyCourses());
            
            // update the meter!
            meter.paintMeter(transcript_gpa,total_gpa);
        });

        vpane.getChildren().add(btAdd);
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
