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

    /**
     * @param args the command line arguments
     */
    public void start(Stage primaryStage) throws Exception { 
        
        //Calls RoshamboView's start method
        super.start(primaryStage);      
        
        //Score variables
        int wins = 0;
        int losses = 0;
        int ties = 0;
        
        
        //Loop to keep asking user to play

        while(myMove != 3){
          

        while(true){
            
            System.out.print("Enter your move. Type rock, paper, or scissors. If you want to quit the game "
                    + "type in quit: ");
            String myMove = in.nextLine();

            //Check if user entered quit
            if(myMove == 3){
                System.out.println("It is 3");
                break;
            }
            
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
            }
        
            
    }
        
        //Print out the results
        /*
        System.out.println("Your score was, \nwins: " + wins + "\nlosses: " + losses + "\nties: " + ties);
        System.out.println("Thanks for playing!");
        */
    
    
    public static void main(String[] args){
        Application.launch(args);
    }

}
    
