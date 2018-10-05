/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.gui;

import bisigraph.domain.Graph;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * This class will draw an animation of the search, instead of displaying it in the
 * GUI. This allows a slower display, so user can see how the search is conducted. 
 * It is a work in progress, at the moment it just draws squares and colors them.
 * 
 * 
 * @author bisi
 */
public class Drawgraph extends Application {

    public static void main() {
        launch();
    }

    public void start(Stage theStage) {
        theStage.setTitle("The Three Great Searches");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            private long lastUpdate = 0;
            int loop = 0;
            
            
            @Override
            public void handle(long currentNanoTime) {

                if (currentNanoTime - lastUpdate < 580000000) {
                } else {
                    for (int i = 0; i < 200; i++) {
                        for (int j = 0; j < 200; j++) {
                            Rectangle r = new Rectangle(i*10, j*10, 10, 10);
                            if(loop == 0){
                                r.setFill(Color.RED);
                                loop++;
                            }else if(loop==1){
                                r.setFill(Color.BLUE);
                                loop++;
                            }else if(loop==2){
                                r.setFill(Color.GREEN);
                                loop=0;
                            }
                            root.getChildren().addAll(r);
                        }
                    }
                    

                    /*} else {
                    if (loop == 0) {
                        gc.setFill(Color.RED);
                        gc.setStroke(Color.BLACK);
                        gc.setLineWidth(2);
                        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
                        gc.setFont(theFont);
                        gc.fillText("Hello, World!", 60, 50);
                        gc.strokeText("Hello, World!", 60, 50);
                        loop++;
                    } else if (loop == 1) {
                        gc.setFill(Color.YELLOW);
                        gc.setStroke(Color.BLACK);
                        gc.setLineWidth(2);
                        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
                        gc.setFont(theFont);
                        gc.fillText("Hello, World!", 60, 50);
                        gc.strokeText("Hello, World!", 60, 50);
                        loop++;
                    } else if (loop == 2) {
                        gc.setFill(Color.GREEN);
                        gc.setStroke(Color.BLACK);
                        gc.setLineWidth(2);
                        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
                        gc.setFont(theFont);
                        gc.fillText("Hello, World!", 60, 50);
                        gc.strokeText("Hello, World!", 60, 50);
                        loop = 0;

                    }
*/
                    lastUpdate = currentNanoTime;
                }
            }
        }.start();

        theStage.show();
    }

}
