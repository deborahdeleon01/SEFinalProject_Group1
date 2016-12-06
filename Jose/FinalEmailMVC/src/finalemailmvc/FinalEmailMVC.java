/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalemailmvc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import email.*;

/**
 *
 * @author Jose_Balle
 */
public class FinalEmailMVC extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        EmailView root = new EmailView();
        EmailModel model = new EmailModel("@utrgv.edu", "", "", "VacPak POS Email", "Dear Student, ");
        EmailController emailController = new EmailController(model, root);
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Email Tab");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
