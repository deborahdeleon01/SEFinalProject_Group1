/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author MQ0162246
 */
public class InformationTab extends Application {

        
    public static final String DEFAULT_FORMAT = "jpg";
    public static final Color DEFAULT_COLOR = Color.LIGHTGREY;
    BorderPane pane = new BorderPane();
    ReminderWidget box = new ReminderWidget();
    HBox borders = new HBox();
    
    /*Temp Information Dropdown*/
    private String pf;

    public InformationTab() {

        HBox hbox = addHBox();
        pane.setTop(hbox);

        HBox hbox1 = addHBox1();

        Text centerText = new Text("More Information Goes here");
        
        
        /***Jose Started Here***/
        /*Tab 3 Select and View*/
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);
        
        Text pftitle = new Text("Professor Information");
        Text name = new Text("");
        Text position = new Text("");
        Text email = new Text("");
        Text phone = new Text("");
        
        
        ObservableList<String> options = 
        FXCollections.observableArrayList(
            "Bari Siddique", "Hansheng Lei", "Domingo Molina", "Liyu Zhang", "Mahmoud Quweider"
        );
        ComboBox comboBox = new ComboBox(options);
        comboBox.setPromptText("Select a Professor");

        // Update the message Label when the selected item changes
        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov, final String oldvalue, final String newvalue) {
                System.out.print(newvalue);
                pf =  newvalue;
                
                if(pf == "Hansheng Lei") {
                    name.setText(pf);
                    position.setText("Associate Professor");
                    email.setText("hansheng.lei@utrgv.edu");
                    phone.setText("956-882-6585");
                }
                else if(pf == "Bari Siddique") {
                    name.setText(pf);
                    position.setText("Lecturer");
                    email.setText("bari.siddique@utrgv.edu");
                    phone.setText("956-882-6602");
                }
                else if(pf == "Liyu Zhang") {
                    name.setText(pf);
                    position.setText("Associate Professor");
                    email.setText("liyu.zhang@utrgv.edu");
                    phone.setText("956-882-6631");
                }
                else if(pf == "Mahmoud Quweider") {
                    name.setText(pf);
                    position.setText("Professor");
                    email.setText("mahmoud.quweider@utrgv.edu");
                    phone.setText("956-882-6630");
                }
                else if(pf == "Domingo Molina") {
                    name.setText(pf);
                    position.setText("Lecturer");
                    email.setText("956-882-6607");
                    phone.setText("domingo.molina@utrgv.edu");
                }
            }
        });
        
        grid.setStyle("-fx-font: 14 arial;");
        pftitle.setStyle("-fx-font: 20 arial; -fx-font-weight: bold;");
                
        grid.add(comboBox, 70, 5);
        grid.add(pftitle, 70, 10);
        
        grid.add(name, 70, 12);
        grid.add(position, 70, 13);
        grid.add(email, 70, 14);
        grid.add(phone, 70, 15);
        

        pane.setCenter(grid);
        /***Jose Ended Here***/
        pane.setBottom(hbox1);
        pane.setLeft(getLeftSide());
        pane.setRight(getRightSide());

        BorderPane.setAlignment(hbox, Pos.CENTER);
        BorderPane.setAlignment(grid, Pos.CENTER);
     
    }

    private GridPane getLeftSide() {
        GridPane pane = new GridPane();

        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(0, 0, 0, 0));
        pane.setHgap(5);
        pane.setVgap(5);

        Label cs = new Label("CONTACT INFORMATION");
        cs.setStyle("-fx-alignment:center;-fx-text-alignment:center;-fx-text-fill:blue;-fx-font-size:25px;-fx-label-padding:20px 20px 20px 20px;-font-weight:bold");

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20, 20, 20, 20));
        Text title = new Text("Edinburg Campus");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        vbox.getChildren().add(title);

        Text options[] = new Text[]{
            new Text("\nENGR 1.294"),
            new Text("1201 West University Drive"),
            new Text("Edinburg, TX 78539-2999"),
            new Text("(956)665-3510\n\n")};

        for (int i = 0; i < 4; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 5, 5));
            vbox.getChildren().add(options[i]);
        }

        Text title2 = new Text("Brownsville Campus");
        title2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        vbox.getChildren().add(title2);

        Text options1[] = new Text[]{
            new Text("\nLHSB 2.720"),
            new Text("One West University Boulevard"),
            new Text("Brownsville, TX 78520"),
            new Text("(956)882-6605\n\n")};

        for (int i = 0; i < 4; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options1[i], new Insets(0, 0, 5, 5));
            vbox.getChildren().add(options1[i]);
        }

        Text emailLabel = new Text();
        emailLabel.setText("E-mail: ");
        Text email = new Text();
        email.setText("coec@utrgv.edu");

        String eml = emailLabel.getText();
        String em = email.getText();

        Text emailField = new Text();
        emailField.setText(eml + em);

        vbox.getChildren().add(emailField);
        
    
        vbox.setPadding(new Insets(20, 20, 20, 20));
        Text title3 = new Text("\n\nImportant Upcoming Dates\n");
        title3.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        vbox.getChildren().add(title3);
        
        String s1 = String.format("%-20s %10s ", "Nov 17","Last day to drop");
        String s2 = String.format("%-20s %14s ", "Nov 24-26","Thanksgiving");
        String s3 = String.format("%-20s %18s", "Dec 8","No Classes");
        String s4 = String.format("%-20s %20s", "Dec 9-15","Finals");
        
        Text options2[] = new Text[]{
            new Text(s1),
            new Text(s2),
            new Text(s3),
            new Text(s4)};

        for (int i = 0; i < 4; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 5, 5));
            vbox.getChildren().add(options2[i]);
        }
        
        
        pane.add(cs, 0, 1);
        pane.add(vbox, 0, 2);

        return pane;
    }

    private GridPane getRightSide() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Text text = new Text("ttttt");
//        pane.add(box.reminderWidget(), 0, 3);
        pane.add(box.reminderWidget(), 0, 3);

        return pane;
    }

    private HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getStyleClass().add("hbox");

        Text topText = new Text();
        topText.setWrappingWidth(800);
        topText.setFont(Font.font("Verdana", 40));
        topText.setFill(Color.WHITE);

        topText.setText("Information");
        topText.setTextAlignment(TextAlignment.CENTER);

        hbox.getChildren().add(topText);

        return hbox;
    }

    private HBox addHBox1() {

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getStyleClass().add("hbox1");

        Text topText = new Text();
        topText.setWrappingWidth(800);
        topText.setFont(Font.font("Verdana", 20));
        topText.setFill(Color.WHITE);

        topText.setText("UTRGV Computer Science Program of Study");
        topText.setTextAlignment(TextAlignment.CENTER);

        hbox.getChildren().add(topText);

        return hbox;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
