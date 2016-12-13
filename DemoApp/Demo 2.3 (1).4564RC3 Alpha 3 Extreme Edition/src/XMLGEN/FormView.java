package XMLGEN;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * @author DR3
 */
public class FormView {

    BorderPane gridPane = new BorderPane();
    
    /**
     * 
     * @param primaryStage4 
     */
    public FormView(Stage primaryStage4) {
        GridPane grid = addGridPane();
        gridPane.setLeft(grid);
    }

    /**
     * 
     * @return GridPane
     */
    private GridPane addGridPane() {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(16, 50, 16, 50));

        //Creating Lables
        Label departmentlabel = new Label("Department");
        Label prefixlabel = new Label("Prefix");
        Label numberlabel = new Label("Number");
        Label namelabel = new Label("Name");
        Label descriptionlabel = new Label("Description");
        Label credithourslabel = new Label("Credit-Hours");
        Label lecturehourslabel = new Label("Lecture-Hours");
        Label labhourslabel = new Label("Lab-Hours");
        Label levellabel = new Label("Level");
        Label schedulelabel = new Label("Schedule-Type");
        Label prerequisitelabel = new Label("Pre-requisite");
        Label corequisitelabel = new Label("Co-requisite");
        Label courseattributeslabel = new Label("Course-Atributes");
        Label legacynumberlabel = new Label("Legacy-Number");
        Label crosslistedlabel = new Label("Cross-Listed");
        Label restrictionslabel = new Label("Restrictions");

        //Creating TextFields 
        TextField departmentfield = new TextField();
        TextField prefixfield = new TextField();
        TextField numberfield = new TextField();
        TextField namefield = new TextField();
        TextField descriptionfield = new TextField();
        TextField credithoursfield = new TextField();
        TextField lecturehoursfield = new TextField();
        TextField labhoursfield = new TextField();
        TextField levelfield = new TextField();
        TextField schedulefield = new TextField();
        TextField prerequisitefield = new TextField();
        TextField corequisitefield = new TextField();
        TextField courseattributesfield = new TextField();
        TextField legacynumberfield = new TextField();
        TextField crosslistedfield = new TextField();
        TextField restrictionsfield = new TextField();

        //TextField Fonts
        departmentfield.setFont(new Font("Arial", 16));
        prefixfield.setFont(new Font("Arial", 16));
        numberfield.setFont(new Font("Arial", 16));
        namefield.setFont(new Font("Arial", 16));
        descriptionfield.setFont(new Font("Arial", 16));
        credithoursfield.setFont(new Font("Arial", 16));
        lecturehoursfield.setFont(new Font("Arial", 16));
        labhoursfield.setFont(new Font("Arial", 16));
        levelfield.setFont(new Font("Arial", 16));
        schedulefield.setFont(new Font("Arial", 16));
        prerequisitefield.setFont(new Font("Arial", 16));
        corequisitefield.setFont(new Font("Arial", 16));
        courseattributesfield.setFont(new Font("Arial", 16));
        legacynumberfield.setFont(new Font("Arial", 16));
        crosslistedfield.setFont(new Font("Arial", 16));
        restrictionsfield.setFont(new Font("Arial", 16));


        //Adding Lables and TextFields
        grid.add(departmentlabel, 0, 0);
        grid.add(departmentfield, 2, 0);

        grid.add(prefixlabel, 0, 1);
        grid.add(prefixfield, 2, 1);

        grid.add(numberlabel, 0, 2);
        grid.add(numberfield, 2, 2);

        grid.add(namelabel, 0, 3);
        grid.add(namefield, 2, 3);

        grid.add(descriptionlabel, 0, 4);
        grid.add(descriptionfield, 2, 4);

        grid.add(credithourslabel, 0, 5);
        grid.add(credithoursfield, 2, 5);

        grid.add(lecturehourslabel, 0, 6);
        grid.add(lecturehoursfield, 2, 6);

        grid.add(labhourslabel, 0, 7);
        grid.add(labhoursfield, 2, 7);

        grid.add(levellabel, 0, 8);
        grid.add(levelfield, 2, 8);

        grid.add(schedulelabel, 0, 9);
        grid.add(schedulefield, 2, 9);

        grid.add(prerequisitelabel, 0, 10);
        grid.add(prerequisitefield, 2, 10);

        grid.add(corequisitelabel, 0, 11);
        grid.add(corequisitefield, 2, 11);

        grid.add(courseattributeslabel, 0, 12);
        grid.add(courseattributesfield, 2, 12);

        grid.add(legacynumberlabel, 0, 13);
        grid.add(legacynumberfield, 2, 13);

        grid.add(crosslistedlabel, 0, 14);
        grid.add(crosslistedfield, 2, 14);

        grid.add(restrictionslabel, 0, 15);
        grid.add(restrictionsfield, 2, 15);


        Button btn = new Button();
        btn.setText("Submit");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                list2.add(departmentlabel.getText());
                list2.add(prefixlabel.getText());
                list2.add(numberlabel.getText());
                list2.add(namelabel.getText());
                list2.add(descriptionlabel.getText());
                list2.add(credithourslabel.getText());
                list2.add(lecturehourslabel.getText());
                list2.add(labhourslabel.getText());
                list2.add(levellabel.getText());
                list2.add(schedulelabel.getText());
                list2.add(prerequisitelabel.getText());
                list2.add(corequisitelabel.getText());
                list2.add(courseattributeslabel.getText());
                list2.add(crosslistedlabel.getText());
                list2.add(restrictionslabel.getText());
                list.add(departmentfield.getText());
                list.add(prefixfield.getText());
                list.add(numberfield.getText());
                list.add(namefield.getText());
                list.add(descriptionfield.getText());
                list.add(credithoursfield.getText());
                list.add(lecturehoursfield.getText());
                list.add(labhoursfield.getText());
                list.add(levelfield.getText());
                list.add(schedulefield.getText());
                list.add(prerequisitefield.getText());
                list.add(corequisitefield.getText());
                list.add(courseattributesfield.getText());
                list.add(crosslistedfield.getText());
                list.add(restrictionsfield.getText());

                XMLGEN x = new XMLGEN();
                x.generateXMLWithArrayLists(list2, list, prefixfield.getText() + "-" + numberfield.getText());

                departmentfield.clear();
                prefixfield.clear();
                numberfield.clear();
                namefield.clear();
                descriptionfield.clear();
                credithoursfield.clear();
                lecturehoursfield.clear();
                labhoursfield.clear();
                levelfield.clear();
                schedulefield.clear();
                prerequisitefield.clear();
                corequisitefield.clear();
                courseattributesfield.clear();
                crosslistedfield.clear();
                restrictionsfield.clear();
                legacynumberfield.clear();
                list.clear();


            }
        });

        grid.add(btn, 0, 16);
        return grid;
    }
    
    /**
     * 
     * @return gridPane pane
     */
    public BorderPane getFormPane() {
        return gridPane;
    }
    
    /**
     * 
     * @param gridPane set pane
     */
    public void setFormPane(BorderPane gridPane) {
        this.gridPane = gridPane;
    }

}
