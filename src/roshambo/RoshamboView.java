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
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Roshambo");

        GridPane grid = new GridPane();
        
        //Event handlers to assign the button presses an action
        EventHandler<ActionEvent> rock = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("rock");
              myMove = 0;
            }
        };
        EventHandler<ActionEvent> paper = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("paper");
              myMove = 1;
            }
        };
        EventHandler<ActionEvent> scissors = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("scissors");
              myMove = 2;
            }
        };
        EventHandler<ActionEvent> quit = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              myMove = 3;
              System.out.println(myMove);
            }
        };
        
        
        //Establish buttons, sizes, and location on grids
        Button b1 = new Button("Rock");
        b1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        grid.add(b1, 0, 0);
        //Set the action for the handler to process
        b1.setOnAction(rock);
        
    
        //Establish buttons, sizes, and location on grids
        Button b2 = new Button("Paper");
        b2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        grid.add(b2, 0, 1);
        //Set the action for the handler to process
        b2.setOnAction(paper);

        
        //Establish buttons, sizes, and location on grids
        Button b3 = new Button("Scissors");
        b3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        grid.add(b3, 1, 0);
        //Set the action for the handler to process
        b3.setOnAction(scissors);

        
        //Establish buttons, sizes, and location on grids
        Button b4 = new Button("Quit");
        b4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        grid.add(b4, 1, 1);
        //Set the action for the handler to process
        b4.setOnAction(quit);


        Scene scene = new Scene(grid, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
