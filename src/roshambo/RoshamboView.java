/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roshambo;

import java.util.Scanner;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.scene.shape.*; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 
import javafx.scene.Group;
import javafx.scene.transform.*;

/**
 *
 * @author tjohn
 */
public class RoshamboView extends Application {
   
    
    protected static int myMove = 0;
    
    Button b1, b2, b3, b4;
    
    public RoshamboView() {
    b1 = new Button("Rock");
    b2 = new Button("Paper");
    b3 = new Button("Scissors");
    b4 = new Button("Quit");
    
    b1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        primaryStage.setTitle("Roshambo");
        GridPane grid = new GridPane();

        
        grid.add(b1, 0, 0);
        grid.add(b2, 0, 1);
        grid.add(b3, 1, 0);
        grid.add(b4, 1, 1);
        
   
        //Establish the scene which allows you to place buttons
        Scene scene = new Scene(grid, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   
}
