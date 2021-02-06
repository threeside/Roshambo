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
    
    public void start(Stage primaryStage) throws Exception { 
        
        //Calls RoshamboView's start method
        super.start(primaryStage);   
        
    
        primaryStage.setTitle("Roshambo");
        
        //Event handlers to assign the button presses an action
        EventHandler<ActionEvent> rock = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("Your move: rock");
              myMove = 0;
              
              opponentMove();
            }
        };
        EventHandler<ActionEvent> paper = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("Your move: paper");
              myMove = 1;
              
              opponentMove();
            }
        };
        EventHandler<ActionEvent> scissors = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              System.out.println("Your move: scissors");
              myMove = 2;
              
              opponentMove();
            }
        };
        EventHandler<ActionEvent> quit = new EventHandler<ActionEvent>(){
          public void handle(ActionEvent E){
              myMove = 3;
              System.out.println(myMove);
             
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
    
    static String opponentMove(){
        
        //Randomly generate the opponents move
        int rand = (int)(Math.random() * 3);

        String opponentMove = "";

        //Assigns the value in opponentMove
        switch(rand){
            case 0:
                opponentMove = "rock";
            break;
            case 1:
                opponentMove = "paper";
            break;
            case 2:
                opponentMove = "scissors";
            break;
        }

        System.out.println("Opponent move: " + opponentMove);

        //Calculate if the user won, lost, or tied
        if(false){
            System.out.println("You tied!");
            ties += 1;
        }
        else if((myMove == 0 && opponentMove.equals("scissors"))
        || (myMove == 2 && opponentMove.equals("paper"))
        || (myMove == 1 && opponentMove.equals("scissors"))){
            System.out.println("You won!");
            wins += 1;
        } else {
            System.out.println("You lost!");
            losses += 1;
        }
        
        return opponentMove;
    }
   

}
    
