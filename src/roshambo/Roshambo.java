package roshambo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.util.*;

public class Roshambo extends RoshamboView {
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception { 
        
        super.start(primaryStage);
        
        RoshamboController p1 = new RoshamboController(); // Player 1
        RoshamboController p2 = new RoshamboController(); // Computer player
        
        initGame(p1, p2);
      
    }
    
    protected void initGame(RoshamboController p1, RoshamboController p2) {
        RoshamboGame game = new RoshamboGame (p1, p2);
        
        EventHandler<ActionEvent> rock = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E){
                battle(game, 0);
            }
        };
        
        EventHandler<ActionEvent> paper = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E){
                battle(game, 1);
            }
        };
        
        EventHandler<ActionEvent> scissors = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E){
                battle(game, 2);
            }
        };
        
        EventHandler<ActionEvent> reset = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E){
                resetGame(p1);
            }
        };
          
        b1.setOnAction(rock);
        b2.setOnAction(paper);
        b3.setOnAction(scissors);
        b4.setOnAction(reset);
    }
    
    /**
     * Resets game state
     */
    protected void resetGame() {
        wins.setText( String.valueOf(0) );
        ties.setText( String.valueOf(0) );
        losses.setText( String.valueOf(0) );
        opponentMove.setText(null);
        
        RoshamboController p1 = new RoshamboController(); // Player 1
        RoshamboController p2 = new RoshamboController(); // Computer player
        
        initGame(p1, p2);
    }
    
    /**
     * Resets game state, but with the passed player as Player 1
     * @param preservedPlayer Player object to utilize as Player 1 in the next game
     */
    protected void resetGame(RoshamboController preservedPlayer) {
        ties.setText( String.valueOf(0) );
        opponentMove.setText(null);
        
        RoshamboController p2 = new RoshamboController(); // Computer player
        
        initGame(preservedPlayer, p2);
    }
    
    /**
     * Generates random Roshambo move
     * @return generated move ID
     */
    public static int randomMove() {
        return (new Random(System.currentTimeMillis()).nextInt(RoshamboGame.RPS_MOVES.length));
    }
    
    /**
     * Starts battle from a game and P1 move; pits P1 move against an AI move
     * @param game
     * @param p1Move 
     */
    protected void battle(RoshamboGame game, int p1Move) {
        battle(game, p1Move, randomMove());
    }
    
    /**
     * Starts battle from a game, P1 move, and P2 move
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
        losses.setText( String.valueOf(game.getP1_gameLosses()) );
        opponentMove.setText(RoshamboGame.getMoveNameFromId(p2Move));
    }

}