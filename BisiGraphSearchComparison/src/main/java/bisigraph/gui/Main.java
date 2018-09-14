/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.gui;
import bisigraph.domain.Graph;
import bisigraph.domain.SearchAlgos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author bisi
 */
public class Main {
    
    private static void createAndShowGui(int x, int y) {
        int cellWidth = 20;
        Graph graph = new Graph(x, y, cellWidth);
        JPanel panel = new JPanel();
        
        JButton goalbutton = new JButton("Set Goal");
        goalbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.setGoal();
            }
        });
        JButton startbutton = new JButton("Set Start");
        startbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.setStart();
            }
        });
        JButton wallbutton = new JButton("Set Wall");
        wallbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.setWall();
            }
        });
        JButton emptybutton = new JButton("Set Empty");
        emptybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.setEmpty();
            }
        });

        JButton resetbutton = new JButton("Reset");
        resetbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.reset();
            }
        });

        JButton bfsbutton = new JButton("BFS");
        bfsbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.BFS();
            }
        });

        JButton dfsbutton = new JButton("DFS");
        dfsbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.DFS();
            }
        });
        
        JButton wallifybutton = new JButton("Wallify");
        wallifybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.wallify();
            }
        });

        JFrame frame = new JFrame("Grapher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        panel.add(graph);
        panel.add(goalbutton);
        panel.add(startbutton);
        panel.add(wallbutton);
        panel.add(emptybutton);
        panel.add(resetbutton);
        panel.add(bfsbutton);
        panel.add(dfsbutton);
        panel.add(wallifybutton);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        
        
        int x = 10;
        int y = 10;
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGui(x, y);
            }
        });
    }

}
