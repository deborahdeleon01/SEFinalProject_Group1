/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
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
import javafx.util.StringConverter;

/**
 *
 * @author MQ0162246
 */
public class Info extends Application {

    BorderPane pane = new BorderPane();

    public Info() {

        HBox hbox = addHBox();
        pane.setTop(hbox);

        HBox hbox1 = addHBox1();
        Text centerText = new Text(" ");
        
        pane.setCenter(centerText);
        pane.setBottom(hbox1);
        pane.setLeft(getLeftSide());
        pane.setRight(getRightSide());

        BorderPane.setAlignment(hbox, Pos.CENTER);
        BorderPane.setAlignment(centerText, Pos.CENTER);

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

        String pattern = "MM-dd-yyyy";

        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };

        Text text = new Text();

        datePicker.setConverter(converter);
        datePicker.setPromptText(pattern.toLowerCase());
        datePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String date = datePicker.getValue().format(DateTimeFormatter.ofPattern(pattern));

                text.setText(date);
                datePicker.setValue(null);
            }
        });

        pane.add(datePicker, 0, 3);
        pane.add(text, 0, 4);
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
        topText.setFont(Font.font("Verdana", 10));
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

    /**
     * @param args the command line arguments
     */
}
