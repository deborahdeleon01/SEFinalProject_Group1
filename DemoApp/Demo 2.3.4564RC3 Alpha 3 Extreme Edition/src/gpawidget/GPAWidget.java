/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author MQ0162246
 */
public class GPAWidget {

    final int fields = 4;
    public int index = 0;
    GPAMeter meter;
    BorderPane pane = new BorderPane();
    ComboBox coursesComboBox;
    TextField[] gradeFields = new TextField[fields];
    TextField[] hourFields = new TextField[fields];
    //    Label[] hourFields = new Label[fields];
    ObservableList<String> options;

    FileInputStream file;
    DocumentBuilderFactory builderFactory;
    DocumentBuilder builder;
    Document xmlDocument;
    XPath xPath;
    Path currentPath3 = Paths.get("");
    String path03 = currentPath3.toAbsolutePath().toString();

    public GPAWidget(double width, double height, double v1, double v2, double v3, double delta) {
        meter = new GPAMeter(width, height, v1, v2, v3, delta);

        // Create the Border pane
        Text topText = new Text();
        topText.setWrappingWidth(800);
        topText.setFont(Font.font("Verdana", FontPosture.ITALIC, 30));
        topText.setFill(Color.RED);

        topText.setText("Calculate GPA");
        topText.setTextAlignment(TextAlignment.CENTER);

        VBox panevbox = new VBox();
        panevbox.setAlignment(Pos.CENTER);
        panevbox.setAlignment(Pos.TOP_CENTER);
        panevbox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        panevbox.setSpacing(10);

        pane.setTop(topText);

        //
        meter.setMeterRotationAngleinDegrees(0);
        Rotate r = new Rotate(meter.getMeterRotationAngleinDegrees(), 300, 300);
        meter.getTransforms().addAll(r);


        panevbox.getChildren().addAll(meter, getSemesterPane());
        pane.setCenter(panevbox);

        BorderPane.setAlignment(topText, Pos.CENTER);
        BorderPane.setAlignment(meter, Pos.CENTER);
    }


    private VBox getSemesterPane() {

        VBox vpane = new VBox();
        vpane.setAlignment(Pos.CENTER);
        vpane.setAlignment(Pos.TOP_CENTER);
        vpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        vpane.setSpacing(10);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        hbox.setSpacing(10);

        // Place nodes in the pane
        Label currentSemesterLabel = new Label("Current Semester Courses");
        currentSemesterLabel.setStyle("-fx-text-fill:black;-fx-font-size: 20px;-fx-font-weight: bold;");
        vpane.getChildren().add(currentSemesterLabel);
        VBox vbox = new VBox();


        for (int i = 0; i < gradeFields.length; i++) {

            HBox hbox1 = new HBox();
            hbox1.setAlignment(Pos.CENTER);
            hbox1.setAlignment(Pos.TOP_CENTER);
            hbox1.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            hbox1.setSpacing(10);


            gradeFields[i] = new TextField();
            gradeFields[i].setPromptText("Grade");
            gradeFields[i].setPrefWidth(65);
            hourFields[i] = new TextField();
//        hourFields[i] = new Label();
            ComboBox cb = coursesComboBox();
            hourFields[i].setPromptText("Hours");
            hourFields[i].setPrefWidth(65);

            hbox1.getChildren().addAll(cb, gradeFields[i], hourFields[i]);
            vbox.getChildren().add(hbox1);
        }

        vpane.getChildren().addAll(vbox);

        Button btAdd = new Button("Update Meter");
//        btAdd.setMaxWidth(Double.MAX_VALUE);

        btAdd.setOnAction((ActionEvent event) -> {

            int hours;
            int totalHours = 0;
            double gpa = 0.0;

            for (int i = 0; i < gradeFields.length; i++) {

                if (isValidGrade(gradeFields[i].getText())) {


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
                    } else if (gradeFields[i].getText().toUpperCase().equals("F")) {
                        hours = Integer.parseInt(hourFields[i].getText());
                        totalHours += hours;
                    }
                }
            }

            gpa = gpa / totalHours;
            System.out.println("Your GPA from the Transcript/Semester  is: " + gpa);

            // update the meter!
            meter.paintMeter(gpa);
        });

        vpane.getChildren().add(btAdd);
        return vpane;
    }

    private boolean isValidGrade(String grade) {
        if (grade == null)
            return false;
        if (
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

    private ComboBox coursesComboBox() {

        options = FXCollections.observableArrayList();

        coursesComboBox = new ComboBox();
        coursesComboBox.setValue("Choose a Course");
        String path3 = path03;

        try {

            file = new FileInputStream(new File(path3 + "/POS_XML.xml"));
            builderFactory = DocumentBuilderFactory.newInstance();
            builder = builderFactory.newDocumentBuilder();
            xmlDocument = builder.parse(file);
            xPath = XPathFactory.newInstance().newXPath();

            String expression1 = "/POS/Course/Prefix";
            String expression2 = "/POS/Course/Number";
            String expression3 = "/POS/Course/Name";
//                        String expression4 = "/POS/Course/Credit-hours";


            NodeList nodeList1 = (NodeList) xPath.compile(expression1).evaluate(xmlDocument, XPathConstants.NODESET);
            NodeList nodeList2 = (NodeList) xPath.compile(expression2).evaluate(xmlDocument, XPathConstants.NODESET);
            NodeList nodeList3 = (NodeList) xPath.compile(expression3).evaluate(xmlDocument, XPathConstants.NODESET);
//                        NodeList nodeList4 = (NodeList) xPath.compile(expression4).evaluate(xmlDocument, XPathConstants.NODESET);


            for (int i = 0; i < nodeList1.getLength(); i++) {
                String prfx = nodeList1.item(i).getFirstChild().getNodeValue();
                String num = nodeList2.item(i).getFirstChild().getNodeValue();
                String name = nodeList3.item(i).getFirstChild().getNodeValue();


                String exp = prfx + " " + num + " " + name;
                coursesComboBox.getItems().addAll(exp);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return coursesComboBox;
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
