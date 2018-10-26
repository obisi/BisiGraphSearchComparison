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
   int c = -1;


   public MyMouseListener(Graph colorGrid) {
      this.colorGrid = colorGrid;
   }

   @Override
   public void mousePressed(MouseEvent e) {
       if (c == 0) {
           if (e.getButton() == MouseEvent.BUTTON1) {
               colorGrid.labelPressedGoal((JLabel) e.getSource());
           }
       } else if (c == 1) {
           if (e.getButton() == MouseEvent.BUTTON1) {
               colorGrid.labelPressedStart((JLabel) e.getSource());
           }
       } else if (c == 2) {
           if (e.getButton() == MouseEvent.BUTTON1) {
               colorGrid.labelPressedWall((JLabel) e.getSource());
           }
       } else if (c == 3) {
           if (e.getButton() == MouseEvent.BUTTON1) {
               colorGrid.labelPressedEmpty((JLabel) e.getSource());
           }
       }
   }

   
    /**
     * Sets goal value to true, so a new goal can be selected from gui
     */
    public void setGoal(){
       c = 0;
   }

    /**
     * Sets start value to true, so a new start point can be selected from gui
     */
    public void setStart(){
       c = 1;
   }

    /**
     * Sets wall value to true, so new walls can be selected from gui
     */
    public void setWall(){
       c = 2;
   }

    /**
     * Sets empty value to true, so selected squares can be emptied can be selected from gui
     */
    public void setEmpty(){
       c = 3;
   }
   
}