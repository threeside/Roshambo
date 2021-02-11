package roshambo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Roshambo extends RoshamboView {
    
    //Score variables
    public static int ties = 0;
    public static int wins = 0;
    public static int losses = 0;
    static int opMove;
    
    @Override
    public void start(Stage primaryStage) throws Exception { 
        
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
          
        b1.setOnAction(rock);
        b2.setOnAction(paper);
        b3.setOnAction(scissors);
        b4.setOnAction(quit);
      
    }
       
    
    public static void main(String[] args){
       
        Application.launch(args);
        
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
       
        //Set player and opponents moves
        p1.setMove(playerMove);
        p2.setMove(opMove);
        
        //Display opponents move in output window
        System.out.println("Opponent move: " + RoshamboGame.getMoveNameFromId(opMove));
        
        game.startBattle();
        
        //Update score variables
        wins += game.getP1_gameWins();
        losses += game.getP1_gameLosses();
        ties += game.getGameTies();
       
        //Update the label text in order to display score
        w.setText("Win: " + wins);
        l.setText("Loss: " + losses);
        t.setText("Tie: " + ties);
        opm.setText(RoshamboGame.getMoveNameFromId(opMove));
        System.out.println("Your score is, \nwins: " + wins + "\nlosses: " + losses + "\nties: " + ties);
        
    }

}
    
