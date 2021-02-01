package roshambo;

import java.util.Scanner;

/**
 *
 * @author tjohn
 */
public class Roshambo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        //Get user input
        Scanner in =  new Scanner(System.in);
        
        //Score variables
        int wins = 0;
        int losses = 0;
        int ties = 0;
        
        
        //Loop to keep asking user to play
        while(true){
            
            System.out.print("Enter your move. Type rock, paper, or scissors. If you want to quit the game "
                    + "type in quit: ");
            String myMove = in.nextLine();


            //Check if user entered quit
            if(myMove.equals("quit")){
                break;
            }
            
            //Verify that my move is valid
            if (!myMove.equals("rock") && !myMove.equals("paper") && !myMove.equals("scissors")){
                System.out.println("Your move isn't valid!");
            } else{
                
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
                    case 3:
                        opponentMove = "scissors";
                    break;
                }

                System.out.println("Opponent move: " + opponentMove);

                //Calculate if the user won, lost, or tied
                if(myMove.equals(opponentMove)){
                    System.out.println("You tied!");
                    ties += 1;
                }
                else if((myMove.equals("rock") && opponentMove.equals("scissors"))
                || (myMove.equals("scissors") && opponentMove.equals("paper"))
                || (myMove.equals("paper") && opponentMove.equals("scissors"))){
                    System.out.println("You won!");
                    wins += 1;
                } else {
                    System.out.println("You lost!");
                    losses += 1;
                }
            }
        }
        
        //Print out the results
        System.out.println("Your score was, \nwins: " + wins + "\nlosses: " + losses + "\nties: " + ties);
        System.out.println("Thanks for playing!");
    }
    
}
