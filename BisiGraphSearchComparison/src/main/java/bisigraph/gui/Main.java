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
        
        /*
        Node g = new Node(8,8);
        BisiHeap heap = new BisiHeap(g);
        
        Path o = new Path(new Node(0, 0), null, 0);
        Path p = new Path(new Node(0, 1), o, 1);
        Path q = new Path(new Node(1, 1), p, 2);
        Path r = new Path(new Node(2, 1), q, 3);
        Path s = new Path(new Node(2, 2), r, 4);
        Path t = new Path(new Node(3, 2), s, 5);
        Path u = new Path(new Node(3, 3), t, 6);
        Path v = new Path(new Node(4, 3), u, 7);
        Path w = new Path(new Node(4, 4), v, 8);
        Path x = new Path(new Node(5, 4), w, 9);
        Path y = new Path(new Node(5, 5), x, 10);
        Path z = new Path(new Node(6, 5), y, 11);
        heap.insert(z);
        heap.insert(o);
        heap.insert(q);
        heap.insert(x);
        heap.insert(y);
        heap.insert(v);
        heap.insert(p);
        heap.insert(r);
        heap.insert(t);
        heap.insert(u);
        heap.insert(s);
        heap.insert(w);
        
        for(int i = 0; i<heap.getHeap().length; i++){
            System.out.println(heap.getHeap()[i]);
        }
        while(!heap.isEmpty()){
            System.out.println("polled: " + heap.poll());
            for (int i = 0; i < heap.getHeap().length; i++) {
                System.out.println(heap.getHeap()[i]);
            }   
        }
        */
        
        
        
        
        int x = 10;
        int y = 10;
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGui(x, y);
            }
        });

    }

}
