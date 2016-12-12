/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import POS.POS;
import XMLGEN.FormView;
import email.EmailController;
import email.EmailModel;
import email.EmailView;
import gpawidget.GPAWidget;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main extends Application {

    GPAWidget gpaWidget = new GPAWidget(600, 600, 0, 4, 0, 0.2);
    InformationTab info = new InformationTab();
    Stage kstage = new Stage();
    Stage POSstage = new Stage();
    POS posLinks;
    EmailView root = new EmailView();
    EmailModel model = new EmailModel("@utrgv.edu", "", "", "VacPak POS Email", "Dear Student, ");
    EmailController emailController = new EmailController(model, root);
    Stage FormXMLstage = new Stage();
    File directoryPDF = new File("./VacPac/pdf/");
    File directoryHTML = new File("./VacPac/html");
    FormView fView;

    public Main() throws MalformedURLException {
        this.posLinks = new POS(POSstage);
        this.fView = new FormView(FormXMLstage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        //launch(args); //in case the other does not work
    }

    public static void delete(File file)
            throws IOException {

        if (file.isDirectory()) {

            //directory is empty, then delete it
            if (file.list().length == 0) {

                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());

            } else {

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    delete(fileDelete);
                }

                //check the directory again, if empty then delete it
                if (file.list().length == 0) {
                    file.delete();
                    System.out.println("Directory is deleted : "
                            + file.getAbsolutePath());
                }
            }

        } else {
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        primaryStage.setTitle("VaqPack -- Computer Science Program of Study");
        //set App icon
        primaryStage.getIcons().addAll(new Image("vaq.png"));
        Group root = new Group();
        Scene scene = new Scene(root);
        TabPane tabPane = new TabPane();
        BorderPane mainPane = new BorderPane();
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

//Basic CSS
        root.setId("eff");
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        tabPane.getTabs().addAll(tabA(), tabB(), tabC(), tabD(), tabE());

        mainPane.setCenter(tabPane);
        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().add(mainPane);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((event) -> {

            //make sure directory exists
            if (!directoryHTML.exists() || directoryPDF.exists()) {

                System.out.println("Directory does not exist.");
                System.exit(0);

            } else {

                try {

                    delete(directoryHTML);
                    delete(directoryPDF);

                } catch (IOException e) {
                    System.exit(0);
                }
            }

        });
        primaryStage.show();
    }

    private Tab tabA() throws MalformedURLException {
        Tab tabA = new Tab();
        tabA.setText("Program Of Study");
        tabA.setContent(posLinks.getRootPane());
        return tabA;
    }

    private Tab tabB() {
        Tab tabB = new Tab();
        tabB.setText("Information");
        //Add Information on TabB
        StackPane tabB_stack = new StackPane();
        tabB_stack.setAlignment(Pos.CENTER);
        tabB_stack.getChildren().add(info.getPane());
        tabB.setContent(tabB_stack);
        return tabB;
    }

    private Tab tabC() {
        Tab tabC = new Tab();
        tabC.setText("Reporting");
        //Add GPA Widget in TabC
        StackPane tabC_stack = new StackPane();
        tabC_stack.setAlignment(Pos.CENTER);
        tabC_stack.getChildren().add(gpaWidget.getPane());
        tabC.setContent(tabC_stack);
        return tabC;
    }

    private Tab tabD() {
        Tab tabD = new Tab();
        tabD.setText("XML Generator");
        tabD.setContent(fView.getFormPane());
        return tabD;
    }

    private Tab tabE() {
        Tab tabE = new Tab();
        tabE.setText("Email");
        tabE.setContent(root);
        return tabE;
    }
}
