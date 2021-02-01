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
public class RoshamboController {
    
    private int currentMove, totalWins, totalTies, totalLosses;
    
    public RoshamboController() {
        this.currentMove = -1;
        this.totalWins = 0;
        this.totalTies = 0;
        this.totalLosses = 0;
    }
    
    public void setMove(int moveId) {
        this.currentMove = moveId;
    }
    
    public void resetMove() {
        currentMove = -1;
    }
    
    public void acceptWin() {
        ++this.totalWins;
    }
    
    public void acceptTie() {
        ++this.totalTies;
    }
    
    public void acceptLoss() {
        ++this.totalLosses;
    }
    
    public int getCurrentMove() {
        return currentMove;
    }
    
    public int getTotalWins() {
        return totalWins;
    }
    
    public int getTotalTies() {
        return totalTies;
    }
    
    public int getTotalLosses() {
        return totalLosses;
    }
    
}
