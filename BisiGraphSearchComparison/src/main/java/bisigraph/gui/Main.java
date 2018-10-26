/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.gui;

import bisigraph.domain.Graph;
import bisigraph.searchalgos.TestCaller;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author bisi
 */
public class Main {

    private static GUIbuilder gb = new GUIbuilder();

    public static void main(String[] args) {
        System.out.println("Welcome to BisiGraper!\n\n");

        System.out.println("First, select width and height of your graph. \n"
                + "Size is limited 5-100");
        int x = getInt("Width: ");
        int y = getInt("Height: ");

        System.out.println("Graph is being drawn. Some tips:\n"
                + "You can choose Start and Goal by clicking the button,\nand then "
                + "clicking a cell on the graph. \nSame goes for walls. You can "
                + "erase cells using Empty. \nWallify randomly walls about one third "
                + "of the map. Clear removes everything.\nEach test has their own button. "
                + "\nYou can test larger maps "
                + "by clicking test.\n"
                + "Remember to keep console open! Information is printed here!\n");
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                gb.createAndShowGui(x, y);
            }

        });

    }
    
    // safe int input
    
    
    private static int getInt(String line) {
        Scanner sc = new Scanner(System.in);
        System.out.println(line);
        int i = -1;
        while (i < 5 || i > 100) {
            String input = sc.next();
            try {
                i = Integer.parseInt(input);
            } catch (NumberFormatException n) {
                System.out.println("Incorrect input.\n");
                continue;
            }
            if(i < 5 || i > 100){
                System.out.println("5-100!\n");
            }
        }
        return i;
    }

}
