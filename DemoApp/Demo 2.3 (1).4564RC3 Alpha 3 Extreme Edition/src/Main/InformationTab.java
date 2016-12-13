/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import LogInMVC.LogInController;
import LogInMVC.LogInView;
import database.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author MQ0162246
 */
public class InformationTab extends Application {


    public static final String DEFAULT_FORMAT = "jpg";
    public static final Color DEFAULT_COLOR = Color.LIGHTGREY;
    BorderPane pane = new BorderPane();
    ReminderWidget box = new ReminderWidget();
    HBox borders = new HBox();
	    LogInView view = new LogInView();
    User user = LogInController.u;

    /*Temp Information Dropdown*/
    private String pf;

    public InformationTab() {

        HBox hbox = addHBox();
        pane.setTop(hbox);

        HBox hbox1 = addHBox1();

        Text centerText = new Text("More Information Goes here");

        pane.setCenter(getCenter());
        pane.setBottom(hbox1);
        pane.setLeft(getLeftSide());
        pane.setRight(getRightSide());

        BorderPane.setAlignment(hbox, Pos.CENTER);

    }

    private GridPane getCenter()
    {
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Label trans = new Label("Parking & Transportation");
        trans.setTextFill(Color.DARKBLUE);
        trans.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        trans.setMaxWidth(Double.MAX_VALUE);
        trans.setAlignment(Pos.CENTER);
        trans.setPadding(new Insets(20,0,20,0));


        Path currentPath3 = Paths.get("");
        String path03 = currentPath3.toAbsolutePath().toString();
        String path3 = path03;
        File t = new File(path3 + "/utrgv_twitter_feed.html");
        File p = new File(path3 + "/parking.html");
      

        WebView twitterFeed = new WebView();
        twitterFeed.setPrefSize(500, 400);
        try {
            twitterFeed.getEngine().load(t.toURI().toURL().toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(InformationTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        WebView parkingMap = new WebView();
        parkingMap.setPrefSize(660, 620);
        try {
            parkingMap.getEngine().load(p.toURI().toURL().toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(InformationTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        grid.add(trans,0,0);
        grid.add(twitterFeed, 0, 1);
        grid.add(parkingMap,0,2);
        
        return grid;
    }
    
    private GridPane getLeftSide() {
        
        GridPane pane = new GridPane();


        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(0, 0, 0, 0));
        pane.setHgap(5);
        pane.setVgap(5);

        Label cs = new Label("Contact Information");
        cs.setTextFill(Color.DARKBLUE);
        cs.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        cs.setPadding(new Insets(20,20,20,20));
        

        VBox vbox = new VBox();
        VBox.setMargin(addCombobox(), new Insets(0,0,5,5));
        vbox.getChildren().add(addCombobox());

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

        String s1 = String.format("%-20s %10s ", "Nov 17", "Last day to drop");
        String s2 = String.format("%-20s %14s ", "Nov 24-26", "Thanksgiving");
        String s3 = String.format("%-20s %18s", "Dec 8", "No Classes");
        String s4 = String.format("%-20s %20s", "Dec 9-15", "Finals");

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
    
    private VBox addCombobox()
    {
        VBox hbox = new VBox();
        hbox.setPadding(new Insets(20, 20, 0, 0));
        hbox.setAlignment(Pos.CENTER_LEFT);

        String id = String.valueOf(user.getId());
        Text pftitle = new Text("User information");
        ImageView profile = new ImageView();
        profile.setImage(user.getPic());
        Text name = new Text(user.getFirst()+" "+user.getLast());
        Text position = new Text("Not on database");
        Text email = new Text(user.getEmail());
        Text phone = new Text(user.getPos());
        Text ID = new Text(id);


        hbox.setStyle("-fx-font: 16 arial;");
        pftitle.setStyle("-fx-font: 20 arial; -fx-font-weight: bold;");

        hbox.getChildren().addAll(pftitle,profile, name,ID, position, email, phone);

//        
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
