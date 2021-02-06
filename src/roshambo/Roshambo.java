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
public class Roshambo extends RoshamboView{
    
    //Score variables
    static int ties = 0;
    static int wins = 0;
    static int losses = 0;
    static int opMove;
    
    public void start(Stage primaryStage) throws Exception { 
        
        //Calls RoshamboView's start method
        super.start(primaryStage);   
        
    
        primaryStage.setTitle("Roshambo");
        
        //Event handlers to assign the button presses an action
        EventHandler<ActionEvent> rock = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("Your move: rock");
              battle(0);
              
              opMove = opponentMove();
             
            }
        };
        EventHandler<ActionEvent> paper = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("Your move: paper");
              battle(1);

              
              opMove = opponentMove();
            }
        };
        EventHandler<ActionEvent> scissors = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("Your move: scissors");
              battle(2);
              
              opMove = opponentMove();
            }
        };
        EventHandler<ActionEvent> quit = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              myMove = 3;
              System.exit(0); 
             
            }
        };
          
        //Set the action for the handler to process
        b1.setOnAction(rock);
        
    
  
        
        //Set the action for the handler to process
        b2.setOnAction(paper);

 

        //Set the action for the handler to process
        b3.setOnAction(scissors);

        
 
        //Set the action for the handler to process
        b4.setOnAction(quit);
      
    }
       
    
    public static void main(String[] args){
       
        Application.launch(args);
        
        
        /*
        //Print out the results
        System.out.println("Your score was, \nwins: " + wins + "\nlosses: " + losses + "\nties: " + ties);
        System.out.println("Thanks for playing!");
        */
    }
    
    static int opponentMove(){
        
        //Randomly generate the opponents move
        int opponentMove = (int)(Math.random() * 3);
        return opponentMove;
    }
    
    static void battle(int playerMove){
        
        RoshamboController p1 = new RoshamboController();
        RoshamboController p2 = new RoshamboController();
        
        RoshamboGame game = new RoshamboGame (p1, p2);
        
        
        p1.setMove(playerMove);
        p2.setMove(opMove);
        
        System.out.println("Opponent move: " + RoshamboGame.getMoveNameFromId(opMove));
        
        game.startBattle();
        
    }
   

}
    
