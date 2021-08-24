package roshambo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.util.*;
import static roshambo.RoshamboGame.RPS_MOVES;

public class Roshambo extends RoshamboView {
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception { 
        
        super.start(primaryStage);
        
        RoshamboController p1 = new RoshamboController(); // Player 1
        RoshamboController p2 = new RoshamboController(); // Computer player
        
        RoshamboGame game = new RoshamboGame (p1, p2);
        
        EventHandler<ActionEvent> rock = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E){
                //System.out.println("Your move: rock");
                battle(game, 0);
            }
        };
        
        EventHandler<ActionEvent> paper = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E){
                //System.out.println("Your move: paper");
                battle(game, 1);
            }
        };
        
        EventHandler<ActionEvent> scissors = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E){
                //System.out.println("Your move: scissors");
                battle(game, 2);
            }
        };
        
        EventHandler<ActionEvent> quit = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E) {
                System.exit(0); 
            }
        };
          
        b1.setOnAction(rock);
        b2.setOnAction(paper);
        b3.setOnAction(scissors);
        b4.setOnAction(quit);
      
    }
    
    /**
     * Randomly generates a roshambo move
     * @return generated move ID
     */
    public static int randomMove() {
        return (new Random(System.currentTimeMillis()).nextInt(RoshamboGame.RPS_MOVES.length));
    }
    
    /**
     * Starts battle from a game and P1 move against an AI
     * @param game
     * @param p1Move 
     */
    protected void battle(RoshamboGame game, int p1Move) {
        battle(game, p1Move, randomMove());
    }
    
    /**
     * Starts battle from game, P1 move, and P2 movie
     * @param game
     * @param p1Move
     * @param p2Move 
     */
    protected void battle(RoshamboGame game, int p1Move, int p2Move) {
       
        // Set player and opponents moves
        game.getP1().setMove(p1Move);
        game.getP2().setMove(p2Move);
        
        game.doBattle();
       
        // Score/status displays
        wins.setText( String.valueOf(game.getP1_gameWins()) );
        ties.setText( String.valueOf(game.getGameTies()) );
        losses.setText( String.valueOf(game.getP2_gameWins()) );
        opponentMove.setText(RoshamboGame.getMoveNameFromId(p2Move));
        
        // System.out.println("Opponent move: " + RoshamboGame.getMoveNameFromId(AI_Move));
        // System.out.println("Your score is, \nwins: " + wins + "\nlosses: " + losses + "\nties: " + ties);
    }

}