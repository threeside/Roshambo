package roshambo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RoshamboView extends Application {
   
    
    protected static int myMove = 0;
    public static int ties;
    public static int wins;
    public static int losses;
    
    Button b1, b2, b3, b4;
    public static Label w, l, t, op, opm;
    //Image rock, paper, scissors;
    
    private static RoshamboController p1 = new RoshamboController();
    private static RoshamboController p2 = new RoshamboController();
    public static RoshamboGame score = new RoshamboGame(p1, p2);
  
    
    public RoshamboView() {
    
        //Establish buttons and labels
        b1 = new Button("Rock");
        b2 = new Button("Paper");
        b3 = new Button("Scissors");
        b4 = new Button("Quit");


        w = new Label("Win: " + score.getP1_gameWins());
        l = new Label("Loss: " + score.getP1_gameLosses());
        t = new Label("Tie: " + score.getGameTies());
        op = new Label("Opponent Move: ");
        opm = new Label();   


        b1.setPrefSize(200, 100);
        b2.setPrefSize(200, 100);
        b3.setPrefSize(200, 100);
        b4.setPrefSize(200, 100);

        w.setPrefSize(200, 100);
        l.setPrefSize(200, 100);
        t.setPrefSize(200, 100);
        op.setPrefSize(200, 100);
        opm.setPrefSize(200, 100);
    
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        primaryStage.setTitle("Roshambo");
        GridPane grid = new GridPane();

        //Set buttons and labels on the grid
        grid.add(b1, 0, 0);
        grid.add(b2, 0, 1);
        grid.add(b3, 1, 0);
        grid.add(b4, 1, 1);
        grid.add(op, 2, 0);
        grid.add(opm, 2, 1);
        grid.add(w, 0, 2);
        grid.add(l, 1, 2);
        grid.add(t, 2, 2);
        
   
        //Establish the scene which allows you to place buttons
        Scene scene = new Scene(grid, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
