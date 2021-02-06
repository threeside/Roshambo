/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roshambo;

/**
 *
 * @author Daniel
 */

public class RoshamboGame {
    
    private static final String[] RPS_MOVES = {"rock", "paper", "scissors"};

    RoshamboController p1, p2;
    private int p1_gameWins, p1_gameLosses, p2_gameWins, p2_gameLosses, gameTies;
    private int gameRound;
    
    /* intitalize game */
    public RoshamboGame(RoshamboController p1, RoshamboController p2) {
        this.p1 = p1;
        this.p2 = p2;
        
        this.p1_gameWins = 0;
        this.p1_gameLosses = 0;
        this.p2_gameWins = 0;
        this.p2_gameLosses = 0;
        this.gameTies = 0;
        this.gameRound = 0;
    }
    
    private static boolean isMoveValid(int moveId) {
        if (moveId < 0 || moveId >= RPS_MOVES.length) {
            return false;
        }
        
        return true;
    }
    
    public boolean startBattle() {
        
        // start round if player moves are legal
        if (isMoveValid(p1.getCurrentMove()) && isMoveValid( p2.getCurrentMove())) {
        
            // is it a tie?
            if (p1.getCurrentMove() == p2.getCurrentMove()) {
                roundIsTie();
            }
        
            // otherwise, did player 1 win?
            else if (p1.getCurrentMove() == ((p2.getCurrentMove()+1) % RPS_MOVES.length)) {
                 p1HasWon();
            }
        
            // else, player 2 won
            else {
                p2HasWon();
            }
        
            ++gameRound;
            
            p1.resetMove();
            p2.resetMove();
            
            return true;
        }
        
        // round cannot commence - illegal player moves
        else {
            return false;
        }
    }
    
    private void roundIsTie() {
        p1.acceptTie();
        p2.acceptTie();
        
        ++gameTies;
        
        System.out.println("You tied!");
        System.out.println(gameTies);
    }
    
    private void p1HasWon() {
        p1.acceptWin();
        p2.acceptLoss();
        
        ++p1_gameWins;
        ++p2_gameLosses;
        
        System.out.println("You have won!");
        System.out.println(p1_gameWins);
    }
    
    private void p2HasWon() {
        p1.acceptLoss();
        p2.acceptWin();
        
        ++p1_gameLosses;
        ++p2_gameWins;
        
        System.out.println("You have lost!");
    }
    
    public static String getMoveNameFromId(int moveId) {
        if (isMoveValid(moveId)) return RPS_MOVES[moveId];
        
        else return null;
    }
    
    public int getP1_gameWins() {
        return p1_gameWins;
    }
    
    public int getP1_gameLosses() {
        return p1_gameLosses;
    }
    
    public int getP2_gameWins() {
        return p2_gameWins;
    }
    
    public int getP2_gameLosses() {
        return p2_gameLosses;
    }
    
    public int getGameTies() {
        return gameTies;
    }
    
    public int getGameRound() {
        return gameRound;
    }
    
}
