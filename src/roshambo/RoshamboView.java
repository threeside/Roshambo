package roshambo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.beans.binding.*;

public class RoshamboView extends Application {
    
    protected Button b1, b2, b3, b4;
    protected Text wins, losses, ties, opponentMove;
    
    private final Label winsLabel, lossesLabel, tiesLabel, oppoentMoveLabel;
    
    public RoshamboView() {
    
        b1 = new Button("Rock");
        
        b2 = new Button("Paper");
        
        b3 = new Button("Scissors");
        
        b4 = new Button("Quit");
        
        wins = new Text();
        losses = new Text();
        ties = new Text();
        opponentMove = new Text();

        winsLabel = new Label("Wins: ");
        lossesLabel = new Label("Losses: ");
        tiesLabel = new Label("Ties: ");
        oppoentMoveLabel = new Label("   Opponent Move: ");
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        /* Set game stage */
        primaryStage.setTitle("Roshambo");
        primaryStage.setMinWidth(330);
        primaryStage.setMinHeight(160);
        
        
        
        /* Outer Grids - Grids to hold all content */
        
        // create grids to hold each content group
        GridPane moveButtonGrid = new GridPane();
        GridPane scoreInfoGrid = new GridPane();
        GridPane oponentMoveGrid = new GridPane();
        
        // determine grid dimensions
        NumberBinding gridWidth = Bindings.divide(primaryStage.widthProperty(), 2);
        NumberBinding gridHeight = Bindings.divide(primaryStage.heightProperty(), 2);
        
        // set grid dimensions
        moveButtonGrid.prefWidthProperty().bind(gridWidth);
        moveButtonGrid.prefHeightProperty().bind(gridHeight);
        
        scoreInfoGrid.prefWidthProperty().bind(gridWidth);
        scoreInfoGrid.prefHeightProperty().bind(gridHeight);
        
        oponentMoveGrid.prefWidthProperty().bind(gridWidth);
        oponentMoveGrid.prefHeightProperty().bind(gridHeight);
        
        
        
        /* Buttons */
        
        // Determine button dimensions
        NumberBinding buttonWidth = Bindings.divide(moveButtonGrid.widthProperty(), 2);
        NumberBinding buttonHeight = Bindings.divide(moveButtonGrid.heightProperty(), 2);
        
        // Set button dimensions and positions
        b1.prefWidthProperty().bind(buttonWidth);
        b1.prefHeightProperty().bind(buttonHeight);
        moveButtonGrid.add(b1, 0, 0);
        
        b2.prefWidthProperty().bind(buttonWidth);
        b2.prefHeightProperty().bind(buttonHeight);
        moveButtonGrid.add(b2, 0, 1);
        
        b3.prefWidthProperty().bind(buttonWidth);
        b3.prefHeightProperty().bind(buttonHeight);
        moveButtonGrid.add(b3, 1, 0);
        
        b4.prefWidthProperty().bind(buttonWidth);
        b4.prefHeightProperty().bind(buttonHeight);
        moveButtonGrid.add(b4, 1, 1);
        
        

        /* Score info */
        
        // Create grid to hold each result type
        GridPane winsGrid = new GridPane();
        GridPane lossesGrid = new GridPane();
        GridPane tiesGrid = new GridPane();
        
        // Determine grid widths
        NumberBinding scoreInfoCellWidth = Bindings.divide(primaryStage.widthProperty(), 3);
        
        // Set score info dimensions and positions
        winsGrid.prefWidthProperty().bind(scoreInfoCellWidth);
        winsGrid.add(winsLabel, 0, 0);
        winsGrid.add(wins, 1, 0);
        scoreInfoGrid.add(winsGrid, 0, 0);
        
        tiesGrid.prefWidthProperty().bind(scoreInfoCellWidth);
        tiesGrid.add(tiesLabel, 0, 0);
        tiesGrid.add(ties, 1, 0);
        scoreInfoGrid.add(tiesGrid, 1, 0);
        
        lossesGrid.prefWidthProperty().bind(scoreInfoCellWidth);
        lossesGrid.add(lossesLabel, 0, 0);
        lossesGrid.add(losses, 1, 0);
        scoreInfoGrid.add(lossesGrid, 2, 0);
        
        
        
        /* Opponent move info */
        
        oponentMoveGrid.add(oppoentMoveLabel, 0, 0);
        oponentMoveGrid.add(opponentMove, 1, 1);
        
        
        
        // Create main grid, add grids to main grid
        GridPane mainGrid = new GridPane();
        mainGrid.add(moveButtonGrid, 0, 0);
        mainGrid.add(scoreInfoGrid, 0, 1);
        mainGrid.add(oponentMoveGrid, 1, 0);
        
        Scene scene = new Scene(mainGrid, 650, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
