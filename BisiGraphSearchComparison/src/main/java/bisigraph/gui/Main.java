/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.gui;
import bisigraph.datastructures.BisiHeap;
import bisigraph.domain.Graph;
import bisigraph.domain.Node;
import bisigraph.domain.Path;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
        JPanel panel = new JPanel(new BorderLayout());
        
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
        
        JButton astarbutton = new JButton("Astar");
        astarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.astar();
            }
        });
        
        JButton wallify = new JButton("Wallify");
        wallify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.wallify();
            }
        });

        JFrame frame = new JFrame("Grapher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        JPanel topPanel = new JPanel();
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(goalbutton);
        btnPanel.add(goalbutton);
        btnPanel.add(startbutton);
        btnPanel.add(wallbutton);
        btnPanel.add(emptybutton);
        btnPanel.add(resetbutton);
        btnPanel.add(bfsbutton);
        btnPanel.add(dfsbutton);
        btnPanel.add(astarbutton);
        btnPanel.add(wallify);
        topPanel.add(graph);
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(btnPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        // you can set the length and width of the grid with x and y.
        int x = 30;
        int y = 30;
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGui(x, y);
            }
        });
    }

}
