package roshambo;

public class RoshamboGame {
    
    public static final String[] RPS_MOVES = {"Rock", "Paper", "Scissors"};

    private RoshamboController p1, p2;
    private int p1_gameWins, p1_gameLosses, p2_gameWins, p2_gameLosses, gameTies, gameRound;
    
    /**
     * 
     * @param p1 player 1 controller
     * @param p2 player 2 controller
     */
    public RoshamboGame(RoshamboController p1, RoshamboController p2) {
        this.p1 = p1;
        this.p2 = p2;
        
        this.p1_gameWins = p1.getTotalWins();
        this.p1_gameLosses = p1.getTotalLosses();
        this.p2_gameWins = p2.getTotalWins();
        this.p2_gameLosses = p2.getTotalLosses();
        this.gameTies = 0;
        this.gameRound = 0;
    }
    
    /**
     * Determines if whether the given move ID is valid
     * @param moveId
     * @return if whether the given move ID is valid
     */
    public static boolean isMoveValid(int moveId) {
        if (moveId < 0 || moveId >= RPS_MOVES.length) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Starts the roshambo battle
     * @return if whether the battle was successful or not; will be unsuccessful if no move is given or if the move is invalid
     */
    public boolean doBattle() {
        // start round if player moves are legal
        if (isMoveValid(p1.getCurrentMove()) && isMoveValid(p2.getCurrentMove())) {
        
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
        else return false;
    }
    
    private void roundIsTie() {
        p1.acceptTie();
        p2.acceptTie();
        
        ++gameTies;
    }
    
    private void p1HasWon() {
        p1.acceptWin();
        p2.acceptLoss();
        
        ++p1_gameWins;
        ++p2_gameLosses;
    }
    
    private void p2HasWon() {
        p1.acceptLoss();
        p2.acceptWin();
        
        ++p1_gameLosses;
        ++p2_gameWins;
    }
    
    /**
     * Gets a move's name form its ID
     * @param moveId
     * @return String name of passed move ID; empty if no such ID exists
     */
    public static String getMoveNameFromId(int moveId) {
        if (isMoveValid(moveId)) return RPS_MOVES[moveId];
        
        else return "";
    }
    
    public RoshamboController getP1() {
        return p1;
    }
    
    public RoshamboController getP2() {
        return p2;
    }
    
     /**
     * Gets number of Player 1's # of game wins
     * @return Player 1's # of game wins
     */
    public int getP1_gameWins() {
        return p1_gameWins;
    }
    
    /**
     * Gets number of Player 1's # of game losses
     * @return Player 1's # of game losses
     */
    public int getP1_gameLosses() {
        return p1_gameLosses;
    }
    
    
    /**
     * Gets number of Player 2's # of game wins
     * @return Player 2's # of game wins
     */
    public int getP2_gameWins() {
        return p2_gameWins;
    }
    
    /**
     * Gets number of Player 2's # of game losses
     * @return Player 2's # of game losses
     */
    public int getP2_gameLosses() {
        return p2_gameLosses;
    }
    
    /**
     * Gets number of game ties
     * @return number of game ties
     */
    public int getGameTies() {
        return gameTies;
    }
    
    /**
     * Gets game's current round #
     * @return game's current round #
     */
    public int getGameRound() {
        return gameRound;
    }
    
}
