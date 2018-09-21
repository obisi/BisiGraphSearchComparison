/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class MyMouseListener extends MouseAdapter {
   private Graph colorGrid;
   private boolean goal = false;
   private boolean start = false;
   private boolean wall = false;
   private boolean empty = false;

   public MyMouseListener(Graph colorGrid) {
      this.colorGrid = colorGrid;
   }

   @Override
   public void mousePressed(MouseEvent e) {
       if (goal) {
           if (e.getButton() == MouseEvent.BUTTON1) {
               colorGrid.labelPressedGoal((JLabel) e.getSource());
           }
       } else if (start) {
           if (e.getButton() == MouseEvent.BUTTON1) {
               colorGrid.labelPressedStart((JLabel) e.getSource());
           }
       } else if (wall) {
           if (e.getButton() == MouseEvent.BUTTON1) {
               colorGrid.labelPressedWall((JLabel) e.getSource());
           }
       } else if (empty) {
           if (e.getButton() == MouseEvent.BUTTON1) {
               colorGrid.labelPressedEmpty((JLabel) e.getSource());
           }
       }
   }
   
    /**
     * Sets all boolean valued controls to false
     */
    public void setAllFalse(){
       goal = false;
       start = false;
       wall = false;
       empty = false;
   }
   
    /**
     * Sets goal value to true, so a new goal can be selected from gui
     */
    public void setGoal(){
       goal = true;
   }

    /**
     * Sets start value to true, so a new start point can be selected from gui
     */
    public void setStart(){
       start = true;
   }

    /**
     * Sets wall value to true, so new walls can be selected from gui
     */
    public void setWall(){
       wall = true;
   }

    /**
     * Sets empty value to true, so selected squares can be emptied can be selected from gui
     */
    public void setEmpty(){
       empty = true;
   }
   
}